//Lior Sapir

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

public class SidewaysLabel extends JLabel {
	//ATTRIBUTES (None)
	
	//CONSTRUCTORS
	public SidewaysLabel() {
		super();
	}
	
	public SidewaysLabel(String s) {
		super(s);
	}
	
	//METHODS

	//Paint Component to set up the sideway labels of the Grids
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D)g.create();
        g2D.rotate(Math.toRadians(-90), (double)getWidth() / 2, (double)getHeight() / 2);
        super.paintComponent(g2D);
        g2D.dispose();
	}
}
