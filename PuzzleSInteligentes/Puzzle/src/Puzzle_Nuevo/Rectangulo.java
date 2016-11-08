package Puzzle_Nuevo;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Rectangulo extends JLabel{
	private  BufferedImage image;


    public Rectangulo(BufferedImage image) {

        this.image=image;
    }

 
	public BufferedImage getImage() {
		
		return  image ;
	}
}
