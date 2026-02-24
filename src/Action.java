//Lior Sapir

public class Action {
	private GridListener gridListener;
	private GridCellPanel cell;
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
