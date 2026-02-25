//Lior Sapir

/*
 * This is a class that stores details about the state of a cell right before it was clicked. 
 * This class is used to remember actions and undo them.
 */

public class Action {
	
	//the gridListener that performed the action
	private GridListener gridListener;
	
	//the cell that recieved the action
	private GridCellPanel cell;
	
	//the state right before the action occured
	private CellState state;
	
	public Action() {
		this(null, null, CellState.EMPTY);
	}
	
	public Action(GridListener l, GridCellPanel cell, CellState state) {
		this.gridListener = l;
		this.cell = cell;
		this.state = state;
	}
	
	//getters and setters for grid
	public GridListener getGridListener() {
		return gridListener;
	}
	
	public void setGrid(GridListener l) {
		this.gridListener = l;
	}
	
	//getters and setters for cell
	public GridCellPanel getCell() {
		return cell;
	}
	
	public void setCell(GridCellPanel cell) {
		this.cell = cell;
	}
	
	//getters and setters for state
	public CellState getState() {
		return state;
	}
	
	public void setState(CellState state) {
		this.state = state;
	}
}
