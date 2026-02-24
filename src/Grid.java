//Andrew Larrazabal
//edited by Lior Sapir
//package project2.Project_2.src;
//package project2;

//Grid class to set up the logic puzzle

public class Grid {
    private GridCell[][] grid;

    public Grid() {
        this(4, 4, new String[] {});
    }
    public Grid(int width, int height, String[] s) {

    	grid = new GridCell[height][width];

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
    	}
    	else {
    		for (int i = 0; i < height; i++) {
    			for (int j = 0; j < width; j++) {
    				grid[i][j] = new GridCell();
    			}
    		}
    	}
    }

    public Grid compareTo(Grid other) {
        Grid grid = new Grid();

        for (int w = 0; w < grid.getGridWidth(); w++) {
            for(int h = 0; h < grid.getGridHeight(); h++) {
                other.getGridCell(w, h);
                if(other.getGridCell(w, h).equals(getGridCell(w, h))) {
                    grid.setGridCell(w, h, true);
                }
                else {
                    grid.setGridCell(w, h, false);
                }
            }
            
        }
        return grid;
    }

    public GridCell getGridCell(int w, int h) {
        return grid[h][w];
    }

    public void setGridCell(int w, int h, boolean state) {
        grid[h][w].setState(state);
    }

    public int getGridHeight() {
        return grid.length;
    }

    public int getGridWidth() {
        return grid[0].length;
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

/*UML CHANGES: 
- Only 1 Grid is needed, delete rest of other grids.
- 
*/



