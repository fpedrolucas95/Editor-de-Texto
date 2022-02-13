package textEditor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.*;
import javax.swing.text.Caret;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.JTextComponent;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	JTextArea area = new JTextArea(20, 20);
	private JFrame frame;
	JFileChooser fileChooser = new JFileChooser();


	GUI() {

		frame = new JFrame("Text Editor");
		fileChooser.setFileFilter(new FileNameExtensionFilter("Generic Text File", "txt"));
		frame.setIconImage(new ImageIcon(getClass().getResource("editor.png")).getImage());
		JScrollPane scr = new JScrollPane();
		scr.setViewportView(area);
		frame.getContentPane().add(scr);

		JMenuBar menu = new JMenuBar();
		menu.setBackground(Color.WHITE);
		JMenu arquivo = new JMenu("File");
		JMenuItem novo = new JMenuItem("New");
		novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame a = new GUI();
			}
		});
		JMenuItem abrir = new JMenuItem("Open");
		abrir.addActionListener(new AbrirArquivo());
		JMenuItem salvar = new JMenuItem("Save");
		salvar.addActionListener(new SalvarArquivo());
		JMenuItem imprimir = new JMenuItem("Print");
		JMenuItem fechar = new JMenuItem("Close");
		fechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		JMenu editar = new JMenu("Edit");
		JMenuItem copiar = new JMenuItem("Copy");
		JMenuItem cortar = new JMenuItem("Cut");
		JMenuItem colar = new JMenuItem("Paste");
		JMenuItem buscar = new JMenuItem("Search");
		buscar = new JMenuItem(new acaoBuscar(area));

		JMenu ferramentas = new JMenu("Tools");
		JMenuItem calculadora = new JMenuItem("Calculator");

		JMenu ajuda = new JMenu("Help");
		JMenuItem sobre = new JMenuItem("About");

		menu.add(arquivo);
		arquivo.add(novo);
		arquivo.add(abrir);
		arquivo.add(salvar);
		arquivo.add(new JSeparator());
		arquivo.add(imprimir);
		arquivo.add(new JSeparator());
		arquivo.add(fechar);
		menu.add(editar);
		editar.add(copiar);
		editar.add(cortar);
		editar.add(colar);
		editar.add(new JSeparator());
		editar.add(buscar);
		menu.add(ferramentas);
		ferramentas.add(calculadora);
		calculadora.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Calculadora();
			}

		});
		menu.add(ajuda);
		ajuda.add(sobre);
		sobre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Sobre();
			}

		});

		frame.setSize(512, 384);
		frame.setVisible(true);
		frame.setJMenuBar(menu);
		frame.getContentPane().add(scr);

		ActionListener acao = new ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuEditar(evt);
			}
		};

		abrir.addActionListener(acao);
		salvar.addActionListener(acao);
		fechar.addActionListener(acao);
		copiar.addActionListener(acao);
		cortar.addActionListener(acao);
		colar.addActionListener(acao);
		buscar.addActionListener(acao);
		imprimir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				imprimir();
			}
		});

	}

	// IMPRIMIR ARQUIVO
	public void imprimir() {
		String total = area.getText();
		PrintJob print = getToolkit().getPrintJob(this, "Print file", null);
		Graphics printGraphics = print.getGraphics();
		printGraphics.setFont(new Font("Arial", Font.PLAIN, 10));
		printGraphics.drawString("Printing:", 100, 100);
		int inicio = 0;
		int linhas = 1;
		for (int i = 0; i < total.length(); i++) {
			if ((int) total.charAt(i) == 10) {
				printGraphics.drawString(total.substring(inicio, i - 1), 100, 100 + (15 * linhas));
				inicio = i + 1;
				linhas++;
			}
		}
		printGraphics.drawString(total.substring(inicio, total.length()), 100, 100 + (15 * linhas));
		printGraphics.dispose();
		print.end();

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// ABRIR ARQUIVO
	class AbrirArquivo implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			int retval = fileChooser.showOpenDialog(GUI.this);
			if (retval == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				area.setText("");

				BufferedReader reader = null;
				try {
					reader = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException ex) {
					Logger.getLogger(AbrirArquivo.class.getName()).log(Level.SEVERE, null, ex);
				}
				String linha = null;
				try {
					linha = reader.readLine();
				} catch (IOException ex) {
					Logger.getLogger(AbrirArquivo.class.getName()).log(Level.SEVERE, null, ex);
				}
				while (linha != null) {
					area.append(linha);
					area.append(System.getProperty("line.separator"));
					try {
						linha = reader.readLine();
					} catch (IOException ex) {
						Logger.getLogger(AbrirArquivo.class.getName()).log(Level.SEVERE, null, ex);
					}
				}

			}
		}
	}

	// SALVAR O ARQUIVO
	public class SalvarArquivo implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			int retval = fileChooser.showSaveDialog(GUI.this);
			if (retval == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();

				PrintWriter writer = null;
				try {
					writer = new PrintWriter(file);
					fileChooser.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));
				} catch (FileNotFoundException ex) {
					Logger.getLogger(SalvarArquivo.class.getName()).log(Level.SEVERE, null, ex);
				}
				writer.print(area.getText());
				writer.close();

			}
		}
	}

	// FUNÇÃO LOCALIZAR
	public class acaoBuscar extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JTextComponent area;

		public acaoBuscar(JTextComponent area) {
			this.area = area;
			this.putValue(Action.NAME, "Search");
		}

		public void actionPerformed(ActionEvent arg0) {

			String buscarTexto = area.getSelectedText();

			if (buscarTexto == null) {
				buscarTexto = "";
			}

			buscarTexto = JOptionPane.showInputDialog(area, "Search words in file:", buscarTexto);

			String texto = area.getText();
			Caret selecao = area.getCaret();
			int posicao = 0;
			if (selecao.getDot() != selecao.getMark()) {
				posicao = selecao.getDot();
			}

			posicao = texto.indexOf(buscarTexto, posicao);
			if (posicao == -1) {
				return;
			}
			area.setCaretPosition(posicao);
			area.moveCaretPosition(posicao + buscarTexto.length());
		}
	}

	private void menuEditar(ActionEvent evt) {

		if (evt.getActionCommand().contentEquals("Copy")) {

			javax.swing.Action acaoCopiar = area.getActionMap().get(DefaultEditorKit.copyAction);
			acaoCopiar.actionPerformed(evt);
		} else if (evt.getActionCommand().contentEquals("Cut")) {
			javax.swing.Action acaoCortar = area.getActionMap().get(DefaultEditorKit.cutAction);
			acaoCortar.actionPerformed(evt);
		} else if (evt.getActionCommand().contentEquals("Paste")) {
			javax.swing.Action acaoColar = area.getActionMap().get(DefaultEditorKit.pasteAction);
			acaoColar.actionPerformed(evt);
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		JFrame a = new GUI();

	}

}
