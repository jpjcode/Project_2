//Andrew Larrazabal
//edited by Lior Sapir
//package project2.Project_2.src;
//package project2;

//Grid class to set up the logic puzzle

public class Grid {
    //ATTRIBUTES
    private GridCell[][] grid;

    public Grid() {
        this(4, 4, new String[] {});
    }

    //CONSTRUCTORS
    public Grid(int width, int height, String[] s) {

    	grid = new GridCell[height][width];

        //Set each Grid Cell in the Grid
    	if (s.length != 0) {
    		for (int i = 0; i < height; i++) {
    			int correctCell = Integer.parseInt(s[i]);

    			for (int j = 0; j < width; j++) {
    				if (correctCell == j) {
    					grid[i][j] = new GridCell(true);
    				} else {
    					grid[i][j] = new GridCell();
    				}
    			}
    		}
    	} else {
    		for (int i = 0; i < height; i++) {
    			for (int j = 0; j < width; j++) {
    				grid[i][j] = new GridCell();
    			}
    		}
    	}
    }
    
    //GETTERS
    public GridCell getGridCell(int w, int h) {
        return grid[h][w];
    }

    public int getGridHeight() {
        return grid.length;
    }

    public int getGridWidth() {
        return grid[0].length;
    }

    //SETTERS
    public void setGridCell(int w, int h, boolean state) {
        grid[h][w].setState(state);
    }

    public boolean equals(Grid other) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
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

        string += "Width: " + grid[0].length + "\n" +
                  "Height: " + grid.length + "\n";

        return string;
    }
}