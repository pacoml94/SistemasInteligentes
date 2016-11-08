package Puzzle_Nuevo;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Puzzle{

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private final JButton btnCargarImagen = new JButton("Cargar Imagen 1");
	private final JButton btnCargarImagen_1 = new JButton("Cargar Imagen 2");
	private final JPanel panel_1 = new JPanel();
	private final JButton btnComprobar = new JButton("Comprobar");
	private BufferedImage source1, source2;
	//private ImageIcon image;
	private ArrayList<Rectangulo> imagen1, imagen2;
	private int f, c;
	private final JTextField textFilas = new JTextField();
	private final JTextField textColumnas = new JTextField();
	private final JLabel lblFilas = new JLabel("Filas:");
	private final JLabel lblColumnas = new JLabel("Columnas:");
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
		textColumnas.setBounds(180, 42, 105, 26);
		textColumnas.setColumns(10);
		textFilas.setBounds(180, 0, 105, 26);
		textFilas.setColumns(10);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			frame.getContentPane().add(panel, BorderLayout.NORTH);
		}
		{
			btnCargarImagen.addActionListener(new BtnCargarImagenActionListener());
			panel.add(btnCargarImagen);
		}
		{
			btnCargarImagen_1.addActionListener(new BtnCargarImagen_1ActionListener());
			panel.add(btnCargarImagen_1);
		}
		{
			frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		}
		{
			btnComprobar.setBounds(157, 103, 117, 23);
			btnComprobar.addActionListener(new BtnComprobarActionListener());
			panel_1.setLayout(null);
			panel_1.add(btnComprobar);
		}
		{
			panel_1.add(textFilas);
		}
		{
			panel_1.add(textColumnas);
		}
		{
			lblFilas.setBounds(78, 6, 69, 20);
			panel_1.add(lblFilas);
		}
		{
			lblColumnas.setBounds(78, 45, 87, 20);
			panel_1.add(lblColumnas);
		}
	}

	private class BtnCargarImagenActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fcAbrir = new JFileChooser();

			int valpr = fcAbrir.showOpenDialog(frame);

			if(valpr == JFileChooser.APPROVE_OPTION) {
				File archivo = fcAbrir.getSelectedFile();

				try {
					source1 = ImageIO.read(archivo);
					btnCargarImagen_1.setEnabled(true);
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
	private class BtnCargarImagen_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fcAbrir = new JFileChooser();

			int valpr = fcAbrir.showOpenDialog(frame);

			if (valpr == JFileChooser.APPROVE_OPTION) {
				File archivo = fcAbrir.getSelectedFile();

				try {
					source2 = ImageIO.read(archivo);
					btnComprobar.setEnabled(true);
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
	private class BtnComprobarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			f=Integer.parseInt(textFilas.getText());
			c=Integer.parseInt(textColumnas.getText());
			imagen1 = cortar(source1);
			imagen2 = cortar(source2);
			if(compare(imagen1, imagen2))System.out.print("Las imagenes son iguales ");
			else System.out.print("Las imagenes no son iguales ");
		}
		private ArrayList<Rectangulo> cortar(BufferedImage source) {
			int width = source.getWidth();
			int height = source.getHeight();
			int widthRec = width/c;
			int heightRec = height/f;
			ArrayList<Rectangulo> rectangulos = new ArrayList<>();
			//cortamos la imagen en el numero de filas y columnas indicado y la vamos guardando al array de rectangulos
			for (int i = 0; i < f; i++) {
				for (int j = 0; j < c; j++) {
					BufferedImage image=new BufferedImage(widthRec, heightRec, source.getType());
					Graphics2D g= image.createGraphics();
					// gr.drawImage(img, 0, 0, anchoCelda, altoCelda, anchoCelda * y, altoCelda * x,
					  //          anchoCelda * y + anchoCelda, altoCelda * x + altoCelda, null);
					g.drawImage(image,0,0, widthRec, heightRec, widthRec*j, heightRec*i,
					 widthRec*j+widthRec,heightRec*i+heightRec, null);
					g.dispose();
					Rectangulo rec= new Rectangulo (image);
					rectangulos.add(rec);
					
				}

			}

			return rectangulos;
		}
		private boolean compare(ArrayList<Rectangulo>imagen1, ArrayList<Rectangulo> imagen2){
				boolean igual=false;
				int cont=0;
				for(int i=0;i<imagen1.size();i++){
					for(int j=0;j<imagen2.size();j++){
						if(iguales(imagen1.get(i).getImage(),imagen2.get(j).getImage())){
							cont++;
							j=imagen2.size();
							
						}
					}
				}
				if(cont==(f*c)){
					igual=true;
						}
				return igual;
			}
		private boolean iguales(BufferedImage img1, BufferedImage img2){
		      boolean equivale=false;
		      int alto, ancho;
		      //Primero comparamos que los tamaños de ambas imagenes sean iguales, 
		      //en caso de que no lo sean, las imagenes ya no son iguales.

		      if(img1.getHeight()==img2.getHeight() && img1.getWidth()==img2.getWidth()){
		        alto=img2.getHeight();
		        ancho=img2.getWidth();
		       // System.out.println(alto);
		       // System.out.println(ancho);
		        //Recorremos todos los pixel para comprobar si las imagenes son iguales

		        for(int i=0;i<alto;i++){
		          for(int j=0;j<ancho;j++){
		            if (img1.getRGB(j, i)==img2.getRGB(j, i)){
		              equivale=true;
		            System.out.print(img1.getRGB(j,i)<< 2);
		              System.out.println(" "+img2.getRGB(j,i));
		            // System.out.println(" Iguales");
		            }else{
		            	System.out.println("No iguales");
		            	equivale=false;
		            
		            	i=alto;
		            	j=ancho;
		            	
		            }
		          }
		        
		        }
		      }
		      return equivale;
		    }
	}
}

