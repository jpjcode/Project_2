//Lior Sapir

/*
 * This class is a JLabel with a custom paintComponent method that makes its text display sideways
 */

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

public class SidewaysLabel extends JLabel {
	//ATTRIBUTES (none)

	//CONSTRUCTORS
	public SidewaysLabel() {
		super();
	}
	
	public SidewaysLabel(String s) {
		super(s);
		}
	
	//METHODS
	//Paint Component for the sideway labels on the grid
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D)g.create();
        g2D.rotate(Math.toRadians(-90), (double)getWidth() / 2, (double)getHeight() / 2);
        super.paintComponent(g2D);
        g2D.dispose();
	}
}
