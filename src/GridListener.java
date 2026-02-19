//Lior Sapir

import java.awt.event.*;

public class GridListener extends MouseAdapter {
	
	@Override
	public void mouseReleased(MouseEvent e) {
		GridCellPanel cell = (GridCellPanel)e.getComponent();
		if (cell.isHovering()) {
			cell.cycleState();
		}
		
		//FIXME: print statement showing how you can get the coordinates of the cell when clicking on it
		System.out.println(cell.getGridX() + ", " + cell.getGridY());
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
