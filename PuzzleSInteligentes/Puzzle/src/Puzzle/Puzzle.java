package Puzzle;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Puzzle {

	private JFrame frame;
	private final JButton btnNewButton = new JButton("Cargar");
	private final JButton btnNewButton_1 = new JButton("Mezclar");
	private final JButton btnNewButton_2 = new JButton("Resolver");
	private final JLabel label = new JLabel("");
	private BufferedImage source;
	private ImageIcon imagen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Puzzle window = new Puzzle();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Puzzle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 547, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 18, 58, 71, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		{
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton.gridx = 1;
			gbc_btnNewButton.gridy = 0;
			btnNewButton.addActionListener(new BtnNewButtonActionListener());
			frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		}
		{
			GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
			gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton_1.gridx = 2;
			gbc_btnNewButton_1.gridy = 0;
			btnNewButton_1.addActionListener(new BtnNewButton_1ActionListener());
			frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		}
		{
			GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
			gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton_2.gridx = 3;
			gbc_btnNewButton_2.gridy = 0;
			frame.getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
		}
		{
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.gridheight = 2;
			gbc_lblNewLabel.gridwidth = 3;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 2;
			frame.getContentPane().add(label, gbc_lblNewLabel);
		}
	}

	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fcAbrir = new JFileChooser();
			int valorDevuelto = fcAbrir.showOpenDialog(frame);
			if (valorDevuelto == JFileChooser.APPROVE_OPTION){
				File file = fcAbrir.getSelectedFile();
				try {
					source = ImageIO.read(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imagen = new ImageIcon(source);
				label.setIcon(imagen);
			}
		}
	}
	
	private class BtnNewButton_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Mezcla mezcla;

				try {
					mezcla = new Mezcla(source);
					mezcla.setVisible(true);
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			
		}
	}
	private BufferedImage loadImage(String img) throws URISyntaxException {
        
        BufferedImage bimg = null;
        try {
        	bimg = ImageIO.read(new File(getClass().getResource(img).toURI()));
        
        } catch (IOException e) {
        	System.out.println(""+e.getMessage());
        }

        return bimg;
    }
}
