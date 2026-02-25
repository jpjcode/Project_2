//Andrew Larrazabal
//package project2.Project_2.src;

public class GridCell {
    //ATTRIBUTES
    boolean state;

    public GridCell() {
        this(false);
    }

    public GridCell(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return state;
    } 

    public void setState(boolean state) {
        this.state = state;
    }
    
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
