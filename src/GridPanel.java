//Lior Sapir

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridPanel extends JPanel {

	//FIXME: we might not end up needing this array or this custom class at all depending on how GridListener is implemented
	GridCellPanel[] panels;
	
	public GridPanel(int numCandidates, int gridSize) {	
		int cellSize = gridSize / numCandidates;
		
		setLayout(new GridLayout(numCandidates, numCandidates));		
		panels = new GridCellPanel[numCandidates * numCandidates];
		for (int i = 0; i < numCandidates; ++i) {
			for (int j = 0; j < numCandidates; ++j) {
				
				panels[i * 4 + j] = new GridCellPanel(j, i, cellSize);
				add(panels[i * 4 + j]);
			}
		}
	}
	
	@Override
	public void addMouseListener(MouseListener l) {
		for (int i = 0; i < panels.length; ++i) {
				panels[i].addMouseListener(l);
		}
	}
}
