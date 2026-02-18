// package cs225project2;

//Lior Sapir

import java.awt.event.*;

public class GridListener extends MouseAdapter {
	
	@Override
	public void mouseReleased(MouseEvent e) {
		GridCellPanel cell = (GridCellPanel)e.getComponent();
		if (cell.isHovering()) {
			cell.cycleState();
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		((GridCellPanel)e.getComponent()).setHovering(true);
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		((GridCellPanel)e.getComponent()).setHovering(false);
	}
}
