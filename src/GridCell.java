//Andrew Larrazabl
//package project2.Project_2.src;

public class GridCell {
    //ATTRIBUTES
    CellState state;

    public GridCell() {
        this(CellState.EMPTY);
    }

    public GridCell(CellState state) {
        this.state = state;
    }

    public CellState getState() {
        return state;
    } 

    public void setState(CellState state) {
        this.state = state;
    }
    
    public boolean equals(GridCell other) {
        return state == other.getState();
    }

    @Override
    public String toString() {
        String s = "";
        //FIXME: Might need to change CellState to include a toString method as well
        /*
        String s = state.toString();
        return s;
        */
       return s;
    }
}
