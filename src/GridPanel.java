//Lior Sapir

import java.awt.*;
import javax.swing.*;
/**
 * GridPanel acts as the grid that stores the GridCells. It has a 2d array of GriCellPanel objects.
 */
public class GridPanel extends JPanel {
	/**
	 * Panels are the 2d array of GridCellPanel objects.
	 */
	private GridCellPanel[][] panels;
	
	/**
	 * Default constructor that passes int 4 as the number of canidates.
	 */
	public GridPanel() {
		this(4);
	}
	
	public GridPanel(int numCandidates) {
		this(numCandidates, 132);
	}
	/**
	 * Constructor recieves a number of canidates and the side of the grid.
	 * @param numCandidates
	 * @param gridSize
	 */
	public GridPanel(int numCandidates, int gridSize) {	
		int cellSize = gridSize / numCandidates;
		
		setLayout(new GridLayout(numCandidates, numCandidates));		
		panels = new GridCellPanel[numCandidates][numCandidates];
		for (int i = 0; i < numCandidates; ++i) {
			for (int j = 0; j < numCandidates; ++j) {
				
				panels[i][j] = new GridCellPanel(cellSize, j, i);
				add(panels[i][j]);
			}
		}
	}
	/**
	 * Method adds a GridListener object to each of the panels.
	 * @param l
	 */
	public void addGridListener(GridListener l) {
		for (int i = 0; i < panels.length; ++i) {
			for (int j = 0; j < panels[i].length; ++j) {
				panels[i][j].addMouseListener(l);
			}
		}
	}
	/**
	 * Get method for GridCellPannels.
	 * @return
	 */
	public GridCellPanel[][] getCellPanels() {
		return panels;
	}
}
