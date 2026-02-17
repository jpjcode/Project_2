//package cs225project2;

import java.awt.*;
import javax.swing.*;


public class GridPanel extends JPanel {
	
	//placeholder for amount of candidates per category
	public static final int NUM_CANDIDATES = 4;
	
	//FIXME: we might not end up needing this array or this custom class at all depending on how GridListener is implemented
	GridCellPanel[][] panels;
	
	public GridPanel() {
		setPreferredSize(new Dimension(300, 300));
		setLayout(new GridLayout(NUM_CANDIDATES, NUM_CANDIDATES));
		panels = new GridCellPanel[NUM_CANDIDATES][NUM_CANDIDATES];
		for (int i = 0; i < panels.length; ++i) {
			for (int j = 0; j < panels.length; ++j) {
				panels[i][j] = new GridCellPanel(i, j);
				add(panels[i][j]);
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public void addXLabels() {
		//TODO
	}
	public void addYLabels() {
		//TODO
	}
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		GridPanel grid = new GridPanel();
		frame.add(grid);
		frame.setVisible(true);	
	}

}
