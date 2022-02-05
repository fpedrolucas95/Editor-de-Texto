package textEditor;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import code.code;

public class Calculadora extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuBar menuSuperior = new JMenuBar();

	JMenu arquivo = new JMenu("Arquivo");
	JMenuItem novo = new JMenuItem("Novo");
	JMenuItem fechar = new JMenuItem("Fechar");
	JMenu ajuda = new JMenu("Ajuda");
	JMenuItem sobre = new JMenuItem("Sobre a Calculadora");

	JTextField saidaCalc = new JTextField("0");

	JButton btDel = new JButton("←");
	JButton btCE = new JButton("CE");
	JButton btC = new JButton("C");
	JButton btMaisMenos = new JButton("±");
	JButton btRaiz = new JButton("√");

	JButton btSete = new JButton("7");
	JButton btOito = new JButton("8");
	JButton btNove = new JButton("9");
	JButton btDiv = new JButton("/");
	JButton btPorc = new JButton("%");

	JButton btQuatro = new JButton("4");
	JButton btCinco = new JButton("5");
	JButton btSeis = new JButton("6");
	JButton btMult = new JButton("*");
	JButton btRecp = new JButton("1/X");

	JButton btUm = new JButton("1");
	JButton btDois = new JButton("2");
	JButton btTres = new JButton("3");
	JButton btSub = new JButton("-");
	JButton btIgual = new JButton("=");

	JButton btZero = new JButton("0");
	JButton btVirg = new JButton(",");
	JButton btSoma = new JButton("+");

	code operacao = new code();

	String sinal = null;
	double valor1 = 0, valor2 = 0;

	public Calculadora() {
		super("Calculadora");

		Container paine = this.getContentPane();
		paine.setLayout(null);

		menuSuperior.setFont(new Font("Arial", Font.PLAIN, 10));
		menuSuperior.add(arquivo);
		menuSuperior.add(ajuda);
		menuSuperior.setBackground(Color.WHITE);
		super.setJMenuBar(menuSuperior);
		arquivo.add(novo);
		novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calculadora calc = new Calculadora();
			}
		});
		arquivo.add(fechar);
		fechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		ajuda.add(sobre);
		sobre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new aboutBox();
			}

		});

		// EXIBIÇÃO DOS DADOS
		saidaCalc.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		saidaCalc.setFont(new Font("Segoe UI", Font.BOLD, 23));
		saidaCalc.setLocation(16, 16);
		saidaCalc.setSize(269, 58);
		saidaCalc.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		paine.add(saidaCalc);

		// PRIMEIRA LINHA
		btDel.setMargin(new Insets(1, 1, 1, 1));
		btDel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		btDel.setLocation(16, 87);
		btDel.setSize(48, 48);
		btDel.setBackground(Color.lightGray);
		btDel.setForeground(Color.darkGray);
		paine.add(btDel);

		btDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saidaCalc.setText("0");
			}
		});

		btCE.setMargin(new Insets(1, 1, 1, 1));
		btCE.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		btCE.setLocation(71, 87);
		btCE.setSize(48, 48);
		btCE.setBackground(Color.lightGray);
		btCE.setForeground(Color.darkGray);
		paine.add(btCE);

		btCE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saidaCalc.setText("0");
			}
		});

		btC.setMargin(new Insets(1, 1, 1, 1));
		btC.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		btC.setLocation(126, 87);
		btC.setSize(48, 48);
		btC.setBackground(Color.lightGray);
		btC.setForeground(Color.darkGray);
		paine.add(btC);

		btC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saidaCalc.setText("0");
			}
		});

		btMaisMenos.setMargin(new Insets(1, 1, 1, 1));
		btMaisMenos.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		btMaisMenos.setLocation(181, 87);
		btMaisMenos.setSize(48, 48);
		btMaisMenos.setBackground(Color.lightGray);
		btMaisMenos.setForeground(Color.darkGray);
		paine.add(btMaisMenos);

		btRaiz.setMargin(new Insets(1, 1, 1, 1));
		btRaiz.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		btRaiz.setLocation(236, 87);
		btRaiz.setSize(48, 48);
		btRaiz.setBackground(Color.lightGray);
		btRaiz.setForeground(Color.darkGray);
		paine.add(btRaiz);

		btRaiz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				valor1 = Double.parseDouble(saidaCalc.getText());
				sinal = "raiz";
				saidaCalc.setText(operacao.raizQ(valor1) + "");
			}
		});

		// SEGUNDA LINHA
		btSete.setMargin(new Insets(1, 1, 1, 1));
		btSete.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		btSete.setLocation(16, 142);
		btSete.setSize(48, 48);
		btSete.setBackground(Color.lightGray);
		btSete.setForeground(Color.darkGray);
		paine.add(btSete);

		btSete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (saidaCalc.getText().equals("0")) {
					saidaCalc.setText("7");
				} else {
					saidaCalc.setText(saidaCalc.getText() + "7");
				}
			}
		});

		btOito.setMargin(new Insets(1, 1, 1, 1));
		btOito.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		btOito.setLocation(71, 142);
		btOito.setSize(48, 48);
		btOito.setBackground(Color.lightGray);
		btOito.setForeground(Color.darkGray);
		paine.add(btOito);

		btOito.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (saidaCalc.getText().equals("0")) {
					saidaCalc.setText("8");
				} else {
					saidaCalc.setText(saidaCalc.getText() + "8");
				}
			}
		});

		btNove.setMargin(new Insets(1, 1, 1, 1));
		btNove.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		btNove.setLocation(126, 142);
		btNove.setSize(48, 48);
		btNove.setBackground(Color.lightGray);
		btNove.setForeground(Color.darkGray);
		paine.add(btNove);

		btNove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (saidaCalc.getText().equals("0")) {
					saidaCalc.setText("9");
				} else {
					saidaCalc.setText(saidaCalc.getText() + "9");
				}
			}
		});

		btDiv.setMargin(new Insets(1, 1, 1, 1));
		btDiv.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		btDiv.setLocation(181, 142);
		btDiv.setSize(48, 48);
		btDiv.setBackground(Color.lightGray);
		btDiv.setForeground(Color.darkGray);
		paine.add(btDiv);

		btDiv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				valor1 = Double.parseDouble(saidaCalc.getText());
				sinal = "div";
				saidaCalc.setText("0");
			}
		});

		btPorc.setMargin(new Insets(1, 1, 1, 1));
		btPorc.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		btPorc.setLocation(236, 142);
		btPorc.setSize(48, 48);
		btPorc.setBackground(Color.lightGray);
		btPorc.setForeground(Color.darkGray);
		paine.add(btPorc);

		// TERCEIRA LINHA
		btQuatro.setMargin(new Insets(1, 1, 1, 1));
		btQuatro.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		btQuatro.setLocation(16, 197);
		btQuatro.setSize(48, 48);
		btQuatro.setBackground(Color.lightGray);
		btQuatro.setForeground(Color.darkGray);
		paine.add(btQuatro);

		btQuatro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (saidaCalc.getText().equals("0")) {
					saidaCalc.setText("4");
				} else {
					saidaCalc.setText(saidaCalc.getText() + "4");
				}
			}
		});

		btCinco.setMargin(new Insets(1, 1, 1, 1));
		btCinco.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		btCinco.setLocation(71, 197);
		btCinco.setSize(48, 48);
		btCinco.setBackground(Color.lightGray);
		btCinco.setForeground(Color.darkGray);
		paine.add(btCinco);

		btCinco.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (saidaCalc.getText().equals("0")) {
					saidaCalc.setText("5");
				} else {
					saidaCalc.setText(saidaCalc.getText() + "5");
				}
			}
		});

		btSeis.setMargin(new Insets(1, 1, 1, 1));
		btSeis.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		btSeis.setLocation(126, 197);
		btSeis.setSize(48, 48);
		btSeis.setBackground(Color.lightGray);
		btSeis.setForeground(Color.darkGray);
		paine.add(btSeis);

		btSeis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (saidaCalc.getText().equals("0")) {
					saidaCalc.setText("6");
				} else {
					saidaCalc.setText(saidaCalc.getText() + "6");
				}
			}
		});

		btMult.setMargin(new Insets(1, 1, 1, 1));
		btMult.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		btMult.setLocation(181, 197);
		btMult.setSize(48, 48);
		btMult.setBackground(Color.lightGray);
		btMult.setForeground(Color.darkGray);
		paine.add(btMult);

		btMult.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				valor1 = Double.parseDouble(saidaCalc.getText());
				sinal = "mult";
				saidaCalc.setText("0");
			}
		});

		btRecp.setMargin(new Insets(1, 1, 1, 1));
		btRecp.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		btRecp.setLocation(236, 197);
		btRecp.setSize(48, 48);
		btRecp.setBackground(Color.lightGray);
		btRecp.setForeground(Color.darkGray);
		paine.add(btRecp);

		btRecp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				valor1 = Double.parseDouble(saidaCalc.getText());
				sinal = "recp";
				saidaCalc.setText(operacao.reciproco(valor1) + "");
			}
		});

		// QUARTA LINHA
		btUm.setMargin(new Insets(1, 1, 1, 1));
		btUm.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		btUm.setLocation(16, 252);
		btUm.setSize(48, 48);
		btUm.setBackground(Color.lightGray);
		btUm.setForeground(Color.darkGray);
		paine.add(btUm);

		btUm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (saidaCalc.getText().equals("0")) {
					saidaCalc.setText("1");
				} else {
					saidaCalc.setText(saidaCalc.getText() + "1");
				}
			}
		});

		btDois.setMargin(new Insets(1, 1, 1, 1));
		btDois.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		btDois.setLocation(71, 252);
		btDois.setSize(48, 48);
		btDois.setBackground(Color.lightGray);
		btDois.setForeground(Color.darkGray);
		paine.add(btDois);

		btDois.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (saidaCalc.getText().equals("0")) {
					saidaCalc.setText("2");
				} else {
					saidaCalc.setText(saidaCalc.getText() + "2");
				}
			}
		});

		btTres.setMargin(new Insets(1, 1, 1, 1));
		btTres.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		btTres.setLocation(126, 252);
		btTres.setSize(48, 48);
		btTres.setBackground(Color.lightGray);
		btTres.setForeground(Color.darkGray);
		paine.add(btTres);

		btTres.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (saidaCalc.getText().equals("0")) {
					saidaCalc.setText("3");
				} else {
					saidaCalc.setText(saidaCalc.getText() + "3");
				}
			}
		});

		btSub.setMargin(new Insets(1, 1, 1, 1));
		btSub.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		btSub.setLocation(181, 252);
		btSub.setSize(48, 48);
		btSub.setBackground(Color.lightGray);
		btSub.setForeground(Color.darkGray);
		paine.add(btSub);

		btSub.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				valor1 = Double.parseDouble(saidaCalc.getText());
				sinal = "sub";
				saidaCalc.setText("0");
			}
		});

		btIgual.setMargin(new Insets(1, 1, 1, 1));
		btIgual.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		btIgual.setLocation(236, 252);
		btIgual.setSize(48, 103);
		btIgual.setBackground(Color.lightGray);
		btIgual.setForeground(Color.darkGray);
		paine.add(btIgual);

		btIgual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				valor2 = Double.parseDouble(saidaCalc.getText());

				if (sinal.equals("soma")) {
					saidaCalc.setText(operacao.somar(valor1, valor2) + "");
				} else if (sinal.equals("sub")) {
					saidaCalc.setText(operacao.subtrair(valor1, valor2) + "");
				} else if (sinal.equals("mult")) {
					saidaCalc.setText(operacao.multiplicar(valor1, valor2) + "");
				} else if (sinal.equals("div")) {
					saidaCalc.setText(operacao.dividir(valor1, valor2) + "");
				} else if (sinal.equals("raiz")) {
					saidaCalc.setText(operacao.raizQ(valor1) + "");
				} else if (sinal.equals("recp")) {
					saidaCalc.setText(operacao.reciproco(valor1) + "");
				}
			}
		});

		// QUINTA LINHA
		btZero.setMargin(new Insets(1, 1, 1, 1));
		btZero.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		btZero.setLocation(16, 307);
		btZero.setSize(103, 48);
		btZero.setBackground(Color.lightGray);
		btZero.setForeground(Color.darkGray);
		paine.add(btZero);

		btZero.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (saidaCalc.getText().equals("0")) {
					saidaCalc.setText("0");
				} else {
					saidaCalc.setText(saidaCalc.getText() + "0");
				}
			}
		});

		btVirg.setMargin(new Insets(1, 1, 1, 1));
		btVirg.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		btVirg.setLocation(126, 307);
		btVirg.setSize(48, 48);
		btVirg.setBackground(Color.lightGray);
		btVirg.setForeground(Color.darkGray);
		paine.add(btVirg);

		btVirg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (saidaCalc.getText().equals("0")) {
					saidaCalc.setText(".");
				} else {
					saidaCalc.setText(saidaCalc.getText() + ".");
				}

			}
		});

		btSoma.setMargin(new Insets(1, 1, 1, 1));
		btSoma.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		btSoma.setLocation(181, 307);
		btSoma.setSize(48, 48);
		btSoma.setBackground(Color.lightGray);
		btSoma.setForeground(Color.darkGray);
		paine.add(btSoma);

		btSoma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				valor1 = Double.parseDouble(saidaCalc.getText());
				sinal = "soma";
				saidaCalc.setText("0");
			}
		});

		this.setSize(317, 433);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);

	}

	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Calculadora calc = new Calculadora();

	}
}
