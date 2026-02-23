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
    
    public boolean equals(GridCell other) {
        return state == other.getState();
    }

    @Override
    public String toString() {
        String s = "";
        
       return s;
    }
}
