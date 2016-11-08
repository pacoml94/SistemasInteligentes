package Puzzle_Nuevo;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Rectangulo extends JLabel{
	private  BufferedImage image;
	private int ID;

    public Rectangulo(BufferedImage image, int ID) {
        this.image=image;
        this.ID = ID;
    }

 
	public BufferedImage getImage() {
		
		return  image ;
	}
}
