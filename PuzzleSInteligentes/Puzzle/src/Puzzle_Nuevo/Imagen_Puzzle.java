package Puzzle_Nuevo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.javafx.geom.transform.BaseTransform;

public class Imagen_Puzzle extends JFrame {

	private JPanel panel;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Imagen_Puzzle frame = new Imagen_Puzzle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Imagen_Puzzle(ArrayList<Rectangulo> img, int f, int c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.gray));
		panel.setLayout(new GridLayout(f, c, 0, 0));
		
		add(panel, BorderLayout.CENTER);
		
		for(int i=0;i<f*c;i++){
			Rectangulo rectangulo= img.get(i);
			panel.add(rectangulo);
			rectangulo.setBorder(BorderFactory.createLineBorder(Color.gray));
			
		}
		pack();
		setLocationRelativeTo(null);
	}

}
