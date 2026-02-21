//Andrew Larrazabal
//package project2.Project_2.src;
//package project2;

//Grid class to set up the logic puzzle
public class Grid {
    private GridCell[][] grid;
    private int width;
    private int height;

    public Grid() {
        this(4, 4);
    }

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new GridCell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = new GridCell();
            }
        }
    }

    public GridCell getGridCell(int w, int h) {
        return grid[w][h];
    }

    public void setGridCell(int w, int h, boolean state) {
        grid[w][h].setState(state);
    }

    public boolean equals(Grid other) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                GridCell otherCell = other.getGridCell(i, j);
                GridCell currentCell = grid[i][j];
                if (!currentCell.equals(otherCell)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String string = "";

        string += "Width: " + width + "\n" +
                  "Height: " + height + "\n";

        return string;
    }
}

/*UML CHANGES: 
- Only 1 Grid is needed, delete rest of other grids.
- 
*/



