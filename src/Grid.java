//Andrew Larrazabal

//edited by Lior Sapir and Jonathan Joseph
//package project2.Project_2.src;
//package project2;

/*
 * This class represents the state of one of the square grids of the puzzle game.
 */

public class Grid {
	//2D array of grid cells
    private GridCell[][] grid;

    public Grid() {
        this(4, 4, new String[] {});
    }
    
    //constructor that uses strings to initialize a grid state. Used when reading from the csv file
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
    	//make a blank grid if an empty String array is received
    	else {
    		for (int i = 0; i < height; i++) {
    			for (int j = 0; j < width; j++) {
    				grid[i][j] = new GridCell();
    			}
    		}
    	}
    }

    //compare this Grid object to another, and return a new Grid object whose cells mark
    //whether or not there is a difference in that cell between the two compared Grids
    public Grid compareTo(Grid other) {
        Grid grid = new Grid();

        for (int w = 0; w < grid.getGridWidth(); w++) {
            for(int h = 0; h < grid.getGridHeight(); h++) {
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

    //get one of the GridCell objects
    public GridCell getGridCell(int w, int h) {
        return grid[h][w];
    }

    //set the state of one of the GridCell objects
    public void setGridCell(int w, int h, boolean state) {
        grid[h][w].setState(state);
    }

    //get the grid height
    public int getGridHeight() {
        return grid.length;
    }

    //get the grid width
    public int getGridWidth() {
        return grid[0].length;
    }

    //check if all the cells in two Grid objects have the same state
    @Override
    public boolean equals(Object obj) {
    	if (!(obj instanceof Grid)) {
    		return false;
    	}
    	
    	Grid other = (Grid)obj;
    	
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                GridCell otherCell = other.getGridCell(i, j);
                GridCell currentCell = grid[j][i];
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