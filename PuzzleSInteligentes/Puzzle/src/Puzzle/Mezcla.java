package Puzzle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Mezcla extends JFrame {
	//private BufferedImage source;
	private BufferedImage negro;
	private ArrayList <Rectangulo> rectangulos;
	private JPanel contentPane;
	private Image image;
	private Rectangulo firstrec;
	private int width, height;
//
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mezcla frame = new Mezcla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @throws URISyntaxException 
	 */
	public Mezcla()throws URISyntaxException{
		
	}
	public Mezcla(BufferedImage source) throws URISyntaxException {
		int f=3, c=3;
		rectangulos = new ArrayList();
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(f,c,0,0));
		//setContentPane(contentPane);
	
		//source = loadImage("alhambra.png");
        width = source.getWidth();
        height = source.getHeight();
        add(contentPane, BorderLayout.CENTER);
        for (int i = 0; i < f; i++) {

            for (int j = 0; j < c; j++) {

                image = createImage(new FilteredImageSource(source.getSource(), new CropImageFilter(j * width / c, i * height / f, (width / c), height / f)));
                Rectangulo rec = new Rectangulo(image);
                rec.putClientProperty("position", new Point(i, j));
                if (i == 0 && j == 0) {
                	negro = loadImage("cuadradonegro.png");
                	image = createImage(new FilteredImageSource(negro.getSource(), new CropImageFilter(j * width / c, i * height / f, (width / c), height / f)));
                    firstrec = new Rectangulo(image);
                    firstrec.setFirstRec();
                    rec.putClientProperty("position", new Point(i, j));
                    
                } else {
                    rectangulos.add(rec);
                }
                
            }
           
        }
        Collections.shuffle(rectangulos);
        rectangulos.add(firstrec);
        for (int i = 0; i < c*f; i++) {

        	Rectangulo rec = rectangulos.get(i);
            contentPane.add(rec);
            rec.setBorder(BorderFactory.createLineBorder(Color.gray));
        }
        pack();
        setTitle("Puzzle");
        setLocationRelativeTo(null);
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
