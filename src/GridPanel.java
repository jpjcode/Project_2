//Lior Sapir

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridPanel extends JPanel {

	private GridCellPanel[][] panels;
	
	public GridPanel() {
		this(4);
	}
	
	public GridPanel(int numCandidates) {
		this(numCandidates, 132);
	}
	
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
	
	public void addGridListener(GridListener l) {
		for (int i = 0; i < panels.length; ++i) {
			for (int j = 0; j < panels[i].length; ++j) {
				panels[i][j].addMouseListener(l);
			}
		}
	}
	
	public GridCellPanel[][] getCellPanels() {
		return panels;
	}
}
