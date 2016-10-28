package Puzzle;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
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
	private final JButton btnCargar = new JButton("Cargar");
	private final JButton btnMezclar = new JButton("Mezclar");
	private final JButton btnResolver = new JButton("Resolver");
	private final JLabel lblImagen = new JLabel("");
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
		frame.setResizable(false);
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 18, 58, 71, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		{
			GridBagConstraints gbc_btnCargar = new GridBagConstraints();
			gbc_btnCargar.insets = new Insets(0, 0, 5, 5);
			gbc_btnCargar.gridx = 1;
			gbc_btnCargar.gridy = 0;
			btnCargar.addActionListener(new CargarActionListener());
			frame.getContentPane().add(btnCargar, gbc_btnCargar);
		}
		{
			GridBagConstraints gbc_btnMezclar = new GridBagConstraints();
			gbc_btnMezclar.insets = new Insets(0, 0, 5, 5);
			gbc_btnMezclar.gridx = 2;
			gbc_btnMezclar.gridy = 0;
			btnMezclar.addActionListener(new MezclarActionListener());
			frame.getContentPane().add(btnMezclar, gbc_btnMezclar);
		}
		{
			GridBagConstraints gbc_btnResolver = new GridBagConstraints();
			gbc_btnResolver.insets = new Insets(0, 0, 5, 5);
			gbc_btnResolver.gridx = 3;
			gbc_btnResolver.gridy = 0;
			frame.getContentPane().add(btnResolver, gbc_btnResolver);
		}
		{
			GridBagConstraints gbc_lblImagen = new GridBagConstraints();
			gbc_lblImagen.gridheight = 2;
			gbc_lblImagen.gridwidth = 3;
			gbc_lblImagen.insets = new Insets(0, 0, 5, 5);
			gbc_lblImagen.gridx = 1;
			gbc_lblImagen.gridy = 2;
			frame.getContentPane().add(lblImagen, gbc_lblImagen);
		}
	}

	private class CargarActionListener implements ActionListener {
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
				Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_DEFAULT));
				lblImagen.setIcon(icono);
			}
		}
	}
	
	private class MezclarActionListener implements ActionListener {
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
