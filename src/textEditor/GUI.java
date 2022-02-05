zpackage textEditor;

import java.awt.Color;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.io.*;
import javax.swing.text.DefaultEditorKit;

public class GUI extends JFrame 
{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	JTextArea area = new JTextArea();
	private JFrame frame;
	JFileChooser fileChooser = new JFileChooser();
	
	GUI() 
	{

		frame = new JFrame ("Editor de Texto");
		JScrollPane scr = new JScrollPane();
		scr.setViewportView(area);
		frame.getContentPane().add(scr);

		JMenuBar menu = new JMenuBar();
		menu.setBackground(Color.WHITE);
		JMenu arquivo = new JMenu("Arquivo");
		JMenuItem abrir = new JMenuItem("Abrir");
			abrir.addActionListener(new AbrirArquivo());
		JMenuItem salvar = new JMenuItem("Salvar");
			salvar.addActionListener(new SalvarArquivo());
		JMenuItem fechar = new JMenuItem("Fechar");
			fechar.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							System.exit(0);
						}
					});
		JMenu editar = new JMenu("Editar");
		JMenuItem copiar = new JMenuItem("Copiar");
		JMenuItem cortar = new JMenuItem("Recortar");
		JMenuItem colar = new JMenuItem("Colar");
		JMenu ajuda = new JMenu("Ajuda");
		JMenuItem sobre = new JMenuItem("Sobre");
		
		menu.add(arquivo);
		arquivo.add(abrir);
		arquivo.add(salvar);
		arquivo.add(fechar);
		menu.add(editar);
		editar.add(copiar);
		editar.add(cortar);
		editar.add(colar);
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

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
	}
	
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
	
	public class SalvarArquivo implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			int retval = fileChooser.showSaveDialog(GUI.this);
			if (retval == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();

				PrintWriter writer = null;
				try {
					writer = new PrintWriter(file);
				} catch (FileNotFoundException ex) {
					Logger.getLogger(SalvarArquivo.class.getName()).log(Level.SEVERE, null, ex);
				}
				writer.print(area.getText());
				writer.close();

			}
		}
	}
	
	private void menuEditar(ActionEvent evt) {

		if (evt.getActionCommand().contentEquals("Copiar")) {

			javax.swing.Action acaoCopiar = area.getActionMap().get(DefaultEditorKit.copyAction);
			acaoCopiar.actionPerformed(evt);
		} else if (evt.getActionCommand().contentEquals("Recortar")) {
			javax.swing.Action acaoCortar = area.getActionMap().get(DefaultEditorKit.cutAction);
			acaoCortar.actionPerformed(evt);
		} else if (evt.getActionCommand().contentEquals("Colar")) {
			javax.swing.Action acaoColar = area.getActionMap().get(DefaultEditorKit.pasteAction);
			acaoColar.actionPerformed(evt);
		}
	} 
	
	public static void main(String[] args) {
		JFrame a = new GUI();
		
	}
		
	
}
