package textEditor;

import javax.swing.*;

public class Sobre {
	JFrame frame = new JFrame();
	JLabel label = new JLabel("Sobre");

	Sobre() {
		JFrame window = new JFrame("Sobre");
		window.add(new JLabel(
				"<html><body style=\"background-color:grey;\"><h1 style=\"color: #4485b8; text-align: center;\">Editor de Texto em Java</h1>\r\n"
						+ "<p style=\"text-align: center;\"><strong style=\"color: #000;\">Vers&atilde;o:</strong> 1.0.2 c7f1da0 - 05/02/2022 - 16:45</p>\r\n"
						+ "<p style=\"text-align: center;\"><strong style=\"color: #000;\">Para Windows, Linux e macOS</strong></p>\r\n"
						+ "<p style=\"text-align: center;\"><strong style=\"color: #000;\"></strong> <a href=\"https://github.com/fpedrolucas95\" target=\"_blank\" rel=\"noopener\" title=\"Editor de Texto\">https://github.com/fpedrolucas95/</a></p>"));
		label.setLocation(48, 16);
		window.pack();
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setSize(280, 186);
	}

	public static void main(String[] args) {
		new Sobre();
	}
}
