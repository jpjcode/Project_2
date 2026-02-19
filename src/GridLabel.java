package cs225project2;

//Lior Sapir

import javax.swing.*;
import java.awt.*;

public class GridLabel extends JPanel {
	
	public static final Color HIGHLIGHT_BLUE = new Color(228, 233, 250);
	
	JLabel text;
	
	public GridLabel(String label, boolean sideways) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		if (sideways) {
			setPreferredSize(new Dimension(PuzzleUI.CELL_SIZE, PuzzleUI.CELL_SIZE * PuzzleUI.NUM_CANDIDATES));
			
			text = new SidewaysLabel(label);
		}
		else {
			setPreferredSize(new Dimension(PuzzleUI.CELL_SIZE * PuzzleUI.NUM_CANDIDATES, PuzzleUI.CELL_SIZE));
			
			text = new JLabel(label);
			text.setPreferredSize(new Dimension(PuzzleUI.CELL_SIZE * PuzzleUI.NUM_CANDIDATES, PuzzleUI.CELL_SIZE));
			text.setHorizontalAlignment(JLabel.TRAILING);
			text.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 8));
		}
		
		setBackground(Color.WHITE);
		add(text);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth(), getHeight());
	}
	
	public void setHighlighted(boolean highlighted) {
		if (highlighted) {
			setBackground(HIGHLIGHT_BLUE);
		}
		else {
			setBackground(Color.WHITE);
		}
	}
}
