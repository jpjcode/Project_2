package cs225project2;

import javax.swing.*;
import java.awt.*;

public class GridCellPane extends JPanel {
	
	public CellState state;
	
	public GridCellPane() {
//		setPreferredSize(new Dimension(50, 50));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(0, 0, 50, 50);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(4, 4));
		
		for (int i = 0; i < 16; ++i) {
			frame.add(new GridCellPane());
		}
		frame.setVisible(true);	
	}

}
