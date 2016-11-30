package Puzzle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Mezcla extends JFrame {

	private JPanel panel;
//
	public Mezcla(Rectangulo[][] img, int f, int c) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.gray));
		panel.setLayout(new GridLayout(f, c, 0, 0));
		add(panel, BorderLayout.CENTER);

		Rectangulo rec = null;

		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {
				rec = img[i][j];
				panel.add(rec);
				rec.setBorder(BorderFactory.createLineBorder(Color.gray));
			}
		}
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}

}
