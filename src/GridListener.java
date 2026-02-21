//Lior Sapir

import java.awt.event.*;

public class GridListener extends MouseAdapter {
	
	GridLabel[] sLabels;
	GridLabel[] tLabels;
	private CellState state;
	private Grid grid;
	
	public GridListener() {
		sLabels = null;
		tLabels = null;
	}
	
	public GridListener(GridLabelGroup s, GridLabelGroup t, Grid grid) {
		sLabels = (s != null) ? s.getLabels() : null;
		tLabels = (t != null) ? t.getLabels() : null;
		this.grid = grid;

		//FIXME: how to construct current cell state to pass into grid class
		// state = CellState.EMPTY
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		GridCellPanel cell = (GridCellPanel)e.getComponent();
		
		//this if statement just prevents the state change if the user clicked on the component but released the mouse outside the component
		if (cell.isHovering()) {
			cell.cycleState();
			
			//FIXME: the gridListener should also have an internal Grid object that it can talk to and change its state
			grid.setGridCell(cell.getGridX(), cell.getGridY(), state);
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
