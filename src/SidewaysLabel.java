//Lior Sapir

import java.awt.*;
import javax.swing.*;

public class SidewaysLabel extends JLabel {
	
	public SidewaysLabel() {
		super();
	}
	
	public SidewaysLabel(String s) {
		super(s);
		}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D)g.create();
        g2D.rotate(Math.toRadians(-90), (double)getWidth() / 2, (double)getHeight() / 2);
        super.paintComponent(g2D);
        g2D.dispose();
	}
}
