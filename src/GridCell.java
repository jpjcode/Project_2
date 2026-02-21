//Andrew Larrazabl
//package project2.Project_2.src;

public class GridCell {
    //ATTRIBUTES
    boolean isTrue;

    public GridCell() {
        this(false);
    }

    public GridCell(boolean state) {
        isTrue = state;
    }

    public boolean getState() {
        return isTrue;
    } 

    public void setState(boolean state) {
        isTrue = state;
    }
    
    public boolean equals(GridCell other) {
        return isTrue == other.getState();
    }

    @Override
    public String toString() {
        String s = "";

        return s;
    }
}
