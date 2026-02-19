//Lior Sapir

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridPanel extends JPanel {
	
	private int cellSize;
	
	//FIXME: we might not end up needing this array or this custom class at all depending on how GridListener is implemented
	GridCellPanel[][] panels;
	
	public GridPanel(GridLabelGroup s, GridLabelGroup t) {	
		GridLabel[] sLabels = s.getLabels();
		GridLabel[] tLabels = t.getLabels();
		
		setLayout(new GridLayout(PuzzleUI.NUM_CANDIDATES, PuzzleUI.NUM_CANDIDATES));		
		panels = new GridCellPanel[PuzzleUI.NUM_CANDIDATES][PuzzleUI.NUM_CANDIDATES];
		for (int i = 0; i < panels.length; ++i) {
			for (int j = 0; j < panels.length; ++j) {
				
				panels[i][j] = new GridCellPanel(j, i, sLabels[i], tLabels[j]);
				add(panels[i][j]);
			}
		}
	}
	
	@Override
	public void addMouseListener(MouseListener l) {
		for (int i = 0; i < panels.length; ++i) {
			for (int j = 0; j < panels.length; ++j) {
				panels[i][j].addMouseListener(l);
			}
		}
	}
	
	public int getCellSize() {
		return cellSize;
	}
}
