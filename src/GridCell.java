//Andrew Larrazabal
//package project2.Project_2.src;

/*
 * This class stores the state of an individual cell in the Grid objects which represent the state of the puzzle game.
 */

public class GridCell {
    //ATTRIBUTES
    boolean state;

    public GridCell() {
        this(false);
    }

    public GridCell(boolean state) {
        this.state = state;
    }
    
    //getters and setters for state
    public boolean getState() {
        return state;
    } 

    public void setState(boolean state) {
        this.state = state;
    }
    
    //check if two GridCells have the same state
    @Override
    public boolean equals(Object obj) {
    	if (!(obj instanceof GridCell)) {
    		return false;
    	}
    	
    	GridCell other = (GridCell)obj;
        return state == other.getState();
    }

    @Override
    public String toString() {
        String s = "";
        
       return s;
    }
}
