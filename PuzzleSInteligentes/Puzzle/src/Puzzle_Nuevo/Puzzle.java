package Puzzle_Nuevo;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import com.sun.xml.internal.ws.api.Component;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Puzzle extends java.awt.Component {

	private JFrame frame;
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnArchivo = new JMenu("Archivo");
	private final JMenuItem mntmAbrir = new JMenuItem("Abrir");
	private final JSeparator separator = new JSeparator();
	private final JMenuItem mntmSalir = new JMenuItem("Salir");
	private final JPanel panel = new JPanel();
	private final JButton btnCargarImagen1 = new JButton("Cargar imagen 1");
	private final JButton btnCargarImagen2 = new JButton("Cargar imagen 2");
	private BufferedImage source1, source2;
	private ImageIcon image;
	private final JButton btnComprobarImgenes = new JButton("Comprobar imágenes");
	private ArrayList<Rectangulo> imagen1, imagen2;
	private int f, c;
	private final JLabel lblNmeroDeFilas = new JLabel("Número de filas:");
	private final JTextField txtFilas = new JTextField();
	private final JLabel lblNmeroDeColumnas = new JLabel("Número de columnas");
	private final JTextField txtColumnas = new JTextField();
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
		imagen1 = new ArrayList<>();
		imagen2 = new ArrayList<>();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		txtColumnas.setBounds(233, 127, 86, 20);
		txtColumnas.setColumns(10);
		txtFilas.setBounds(233, 102, 86, 20);
		txtFilas.setColumns(10);
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			frame.setJMenuBar(menuBar);
		}
		{
			menuBar.add(mnArchivo);
		}
		{
			mnArchivo.add(mntmAbrir);
		}
		{
			mnArchivo.add(separator);
		}
		{
			mnArchivo.add(mntmSalir);
		}
		{
			frame.getContentPane().add(panel, BorderLayout.CENTER);
		}
		panel.setLayout(null);
		{
			btnCargarImagen1.addActionListener(new BtnCargarImagen1ActionListener());
			btnCargarImagen1.setBounds(43, 42, 184, 23);
			panel.add(btnCargarImagen1);
		}
		{
			btnCargarImagen2.setEnabled(false);
			btnCargarImagen2.addActionListener(new BtnCargarImagen2ActionListener());
			btnCargarImagen2.setBounds(290, 42, 172, 23);
			panel.add(btnCargarImagen2);
		}
		{
			btnComprobarImgenes.setEnabled(false);
			btnComprobarImgenes.addActionListener(new BtnComprobarImgenesActionListener());
			btnComprobarImgenes.setBounds(153, 172, 172, 23);
			panel.add(btnComprobarImgenes);
		}
		{
			lblNmeroDeFilas.setBounds(114, 105, 87, 14);
			panel.add(lblNmeroDeFilas);
		}
		{
			panel.add(txtFilas);
		}
		{
			lblNmeroDeColumnas.setBounds(114, 130, 105, 14);
			panel.add(lblNmeroDeColumnas);
		}
		{
			panel.add(txtColumnas);
		}
	}
	private class BtnCargarImagen1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fcAbrir = new JFileChooser();
			
			int valpr = fcAbrir.showOpenDialog(frame);
			
			if(valpr == JFileChooser.APPROVE_OPTION) {
				File archivo = fcAbrir.getSelectedFile();
				
				try {
					source1 = ImageIO.read(archivo);
					btnCargarImagen2.setEnabled(true);
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
		}
	}

	private class BtnCargarImagen2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fcAbrir = new JFileChooser();

			int valpr = fcAbrir.showOpenDialog(frame);

			if (valpr == JFileChooser.APPROVE_OPTION) {
				File archivo = fcAbrir.getSelectedFile();

				try {
					source2 = ImageIO.read(archivo);
					btnComprobarImgenes.setEnabled(true);
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}

	private class BtnComprobarImgenesActionListener implements ActionListener {
		
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent arg0) {
			
			if(iguales(source1,source2)){
				System.out.print("Las imagenes son iguales");
				//imagen1 = cortar(source1);
				imagen2 = cortar(source2);
				
				Imagen_Puzzle imagen_Puzzle = new Imagen_Puzzle(imagen2, f, c);
				imagen_Puzzle.show(true);

			}else System.out.print("Las imagenes no son iguales");
			
		}

		private ArrayList<Rectangulo> cortar(BufferedImage source) {
			int width = source.getWidth();
			int height = source.getHeight();
			Image image;
			
			f=Integer.parseInt(txtFilas.getText());
			c=Integer.parseInt(txtColumnas.getText());

			ArrayList<Rectangulo> rectangulos = new ArrayList<>();

			for (int i = 0; i < f; i++) {
				for (int j = 0; j < c; j++) {
					image = createImage(new FilteredImageSource(source.getSource(),
							new CropImageFilter(j * width / c, i * height / f, (width / c), height / f)));
					Rectangulo rec = new Rectangulo(image);

					rectangulos.add(rec);
				}

			}

			return rectangulos;
		}
		
		private boolean iguales(BufferedImage img1, BufferedImage img2){
			boolean equivale=false;
			int alto, ancho;
			if(img1.getHeight()==img2.getHeight() && img1.getWidth()==img2.getWidth()){
				alto=img2.getHeight();
				ancho=img2.getHeight();
				
				for(int i=0;i<alto;i++){
					for(int j=0;j<ancho;j++){
						if (img1.getRGB(i, j)==img2.getRGB(i, j)){
							equivale=true;
						}
					}
				}
			}
			return equivale;
		}
	}		
}