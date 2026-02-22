//Lior Sapir
//edited by Andrew Larrazabal

import java.awt.event.*;

public class GridListener extends MouseAdapter {
	
	private GridLabelGroup sLabelGroup;
	private GridLabelGroup tLabelGroup;
	private Grid grid;
	
	public GridListener() {
		this(null, null);
	}
	
	public GridListener(GridLabelGroup s, GridLabelGroup t) {
		this(s, t, null);
	}
	
	public GridListener(GridLabelGroup s, GridLabelGroup t, Grid grid) {
		sLabelGroup = s;
		tLabelGroup = t;
		this.grid = grid;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		GridCellPanel cell = (GridCellPanel)e.getComponent();
		
		//this if statement just prevents the state change if the user clicked on the component but released the mouse outside the component
		if (cell.isHovering()) {
			cell.cycleState();
		
			if (grid != null) {
				grid.cycleGridCell(cell.getGridX(), cell.getGridY());
			}
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		GridCellPanel cell = (GridCellPanel)e.getComponent();
		cell.setHovering(true);
		
		if (sLabelGroup != null) {
			sLabelGroup.getLabels()[cell.getGridY()].setHighlighted(true);
		}
		if (tLabelGroup != null) {
			tLabelGroup.getLabels()[cell.getGridX()].setHighlighted(true);
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		GridCellPanel cell = (GridCellPanel)e.getComponent();
		cell.setHovering(false);
		
		if (sLabelGroup != null) {
			sLabelGroup.getLabels()[cell.getGridY()].setHighlighted(false);
		}
		if (tLabelGroup != null) {
			tLabelGroup.getLabels()[cell.getGridX()].setHighlighted(false);
		}
	}
}
