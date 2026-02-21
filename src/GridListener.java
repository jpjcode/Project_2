//Lior Sapir
//edited by Andrew Larrazabl

import java.awt.event.*;

public class GridListener extends MouseAdapter {
	
	GridLabel[] sLabels;
	GridLabel[] tLabels;
	private Grid grid;
	
	public GridListener() {
		sLabels = null;
		tLabels = null;
	}
	
	public GridListener(GridLabelGroup s, GridLabelGroup t) {
		this(s, t, new Grid());
	}
	
	public GridListener(GridLabelGroup s, GridLabelGroup t, Grid grid) {
		sLabels = (s != null) ? s.getLabels() : null;
		tLabels = (t != null) ? t.getLabels() : null;
		this.grid = grid;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		GridCellPanel cell = (GridCellPanel)e.getComponent();
		
		//this if statement just prevents the state change if the user clicked on the component but released the mouse outside the component
		if (cell.isHovering()) {
			cell.cycleState();
			
			grid.cycleGridCell(cell.getGridX(), cell.getGridY());
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
