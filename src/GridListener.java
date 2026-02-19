//Lior Sapir

import java.awt.event.*;

public class GridListener extends MouseAdapter {
	
	GridLabel[] sLabels;
	GridLabel[] tLabels;
	
	public GridListener() {
		sLabels = null;
		tLabels = null;
	}
	
	public GridListener(GridLabelGroup s, GridLabelGroup t) {
		sLabels = (s != null) ? s.getLabels() : null;
		tLabels = (t != null) ? t.getLabels() : null;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		GridCellPanel cell = (GridCellPanel)e.getComponent();
		if (cell.isHovering()) {
			cell.cycleState();
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		GridCellPanel cell = (GridCellPanel)e.getComponent();
		cell.setHovering(true);
		
		if (sLabels != null) {
			sLabels[cell.getGridY()].setHighlighted(true);
		}
		if (tLabels != null) {
			tLabels[cell.getGridX()].setHighlighted(true);
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		GridCellPanel cell = (GridCellPanel)e.getComponent();
		cell.setHovering(false);
		
		if (sLabels != null) {
			sLabels[cell.getGridY()].setHighlighted(false);
		}
		if (tLabels != null) {
			tLabels[cell.getGridX()].setHighlighted(false);
		}
	}
}
