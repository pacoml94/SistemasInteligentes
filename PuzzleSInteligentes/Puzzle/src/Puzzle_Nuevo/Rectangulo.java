package Puzzle_Nuevo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Rectangulo extends JLabel{
	private Image image;
	
    public Rectangulo(Image image) {
        super(new ImageIcon(image));
        this.image = image;
    }

    public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int hashCode() {
		
		int hash = 1;
		hash = hash*31 + image.hashCode();
		
		return hash;
	}
}
