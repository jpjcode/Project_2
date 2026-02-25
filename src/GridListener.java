//Lior Sapir
//edited by Andrew Larrazabal

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

public class GridListener extends MouseAdapter {
	
	private GridLabelGroup sLabelGroup;
	private GridLabelGroup tLabelGroup;
	private Grid grid;
	private ActionTracker actionTracker;
	private JTable table;
	private int tableColumn;
	
	public GridListener() {
		this(null, null, null, null);
	}
	
	public GridListener(GridLabelGroup s, GridLabelGroup t, Grid grid, ActionTracker h) {
		this(s, t, grid, h, null, 0);
	}
	
	public GridListener(GridLabelGroup s, GridLabelGroup t, Grid grid, ActionTracker h, JTable table, int tableColumn) {
		sLabelGroup = s;
		tLabelGroup = t;
		this.grid = grid;
		actionTracker = h;
		this.table = table;
		this.tableColumn = tableColumn;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		GridCellPanel cell = (GridCellPanel)e.getComponent();
		
		//this if statement just prevents the state change if the user clicked on the component but released the mouse outside the component
		if (cell.isHovering()) {
			actionTracker.addAction(this, cell, cell.getState());
			cell.cycleState();
		
			if (grid != null) {
				int x = cell.getGridX();
				int y = cell.getGridY();
				
				if (cell.getState() == CellState.CORRECT) {
					
					grid.setGridCell(x, y, true);
					
					GridCellPanel[][] panels = ((GridPanel)cell.getParent()).getCellPanels();
					
					for (int i = 0; i < panels.length; ++i) {
						
						for (int j = 0; j < panels[i].length; ++j) {
							//if only the x coordinate or only the y coordinate match
							if ((!((j == x) && (i == y))) && ((j == x) || (i == y))) {
								if (table != null && grid.getGridCell(j, i).getState() == true) {
									table.setValueAt("", i, tableColumn);
								}
								
								panels[i][j].setState(CellState.INCORRECT);
								grid.setGridCell(j, i, false);
							}
						}
					}
					
					if (table != null) {
						table.setValueAt(tLabelGroup.getLabels()[x].getText(), y, tableColumn);
					}
					
				}
				else if (cell.getState() == CellState.EMPTY) {
					grid.setGridCell(x, y, false);
					
					if (table != null) {
						table.setValueAt("", y, tableColumn);
					}
				}
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
	
	public GridLabelGroup getSLabelGroup() {
		return sLabelGroup;
	}
	
	public GridLabelGroup getTLabelGroup() {
		return tLabelGroup;
	}
	
	public Grid getGrid() {
		return grid;
	}
	
	public boolean editsTable() {
		return !(table == null);
	}
	public int getTableColumn() {
		return tableColumn;
	}
	
}
