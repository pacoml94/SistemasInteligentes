package Puzzle;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Rectangulo extends JLabel {
	private BufferedImage image;
	private int idImage;

	public Rectangulo(BufferedImage image, int idImage) {
		super(new ImageIcon(image));
		this.image = image;
		this.idImage = idImage;
	}

	public int getIdImage() {
		return idImage;
	}

	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

	public BufferedImage getImage() {
		return image;
	}
}
