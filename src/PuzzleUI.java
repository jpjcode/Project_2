package cs225project2;

//Lior Sapir

import java.awt.*;
import javax.swing.*;

public class PuzzleUI {
	public static final int NUM_CANDIDATES = 4;
	public static final int MIN_GRID_SIZE = 132;
	public static final int MIN_CELL_SIZE = 23;
	public static final int CELL_SIZE = (MIN_GRID_SIZE / NUM_CANDIDATES < MIN_CELL_SIZE) ? MIN_CELL_SIZE : MIN_GRID_SIZE / NUM_CANDIDATES;
	public static final int GRID_SIZE = CELL_SIZE * NUM_CANDIDATES;

	public static void main(String[] args) {
		//Yes I know this code is silly and shouldnt be in a main method this is just a draft
				JFrame frame = new JFrame();
				frame.setSize(600, 700);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new FlowLayout());
				
				//Main panel
				JPanel p = new JPanel();
				p.setPreferredSize(new Dimension(GRID_SIZE * 3 + 4 * 3, frame.getHeight()));
				p.setLayout(new FlowLayout(FlowLayout.LEFT, 4, 4));
				
				//empty panel to fill space
				JPanel pEmpty = new JPanel();
				pEmpty.setPreferredSize(new Dimension(GRID_SIZE, GRID_SIZE));
				
				//grid labels
				GridLabelGroup lt1 = new GridLabelGroup(true);
				GridLabelGroup ls1 = new GridLabelGroup(false);
				
				GridLabelGroup lt2 = new GridLabelGroup(true);
				GridLabelGroup ls2 = new GridLabelGroup(false);
				
				//grids
				GridPanel grid = new GridPanel(ls1, lt1);
				GridPanel grid2 = new GridPanel(ls1, lt2);
				GridPanel grid3 = new GridPanel(ls2, lt1);
				grid.addMouseListener(new GridListener());
				grid2.addMouseListener(new GridListener());
				grid3.addMouseListener(new GridListener());
				
				//add components into main panel
				p.add(pEmpty);
				p.add(lt1);
				p.add(lt2);
				p.add(ls1);
				p.add(grid);
				p.add(grid2);
				p.add(ls2);	
				p.add(grid3);

				//add main panel to frame
				frame.add(p);
				
				frame.setVisible(true);	
	}
}
