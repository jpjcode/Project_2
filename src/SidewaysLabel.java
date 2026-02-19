package cs225project2;

//Lior Sapir

import java.awt.*;
import javax.swing.*;

public class SidewaysLabel extends JLabel {
	
	public SidewaysLabel(String s) {
		super(s);
		setPreferredSize(new Dimension(PuzzleUI.CELL_SIZE * PuzzleUI.NUM_CANDIDATES, PuzzleUI.CELL_SIZE * PuzzleUI.NUM_CANDIDATES));
		setHorizontalAlignment(JLabel.LEADING);
		setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 0));
		}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D)g.create();
        g2D.rotate(Math.toRadians(-90), (double)getWidth() / 2, (double)getHeight() / 2);
        super.paintComponent(g2D);
        g2D.dispose();
	}
}