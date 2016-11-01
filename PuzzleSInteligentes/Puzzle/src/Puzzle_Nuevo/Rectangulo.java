package Puzzle_Nuevo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Rectangulo extends JLabel{
	private boolean firstRec;

    public Rectangulo() {

    }

    public Rectangulo(Image image) {

        super(new ImageIcon(image));
    }

 

    public void setFirstRec() {
        
        firstRec = true;
    }

    public boolean firstRec() {

        return firstRec;
    }
}
