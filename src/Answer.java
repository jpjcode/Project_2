//Jonathan Joseph
//edited by Andrew Larrazabal and Lior Sapir

/*
 * This class stores the full state of a logic puzzle using a set of Grid objects.
 */
import java.util.Scanner;

class Answer {

	//array of Grids
    private Grid[] grids;

    public Answer() {
    	this(4);
    }
    
    public Answer(int gridSize) {
    	grids = new Grid[3];
    	
    	for (int i = 0; i < grids.length; ++i) {
    		grids[i] = new Grid(gridSize, gridSize, new String[] {});
    	}
    }
    public Answer(Grid[] grids) {
        this.grids = grids;
    }
    
    //Intitialize an answer object using a string. Used to read the correct answer from a csv file
    public Answer(String s) {
    	grids = new Grid[3];
    	Scanner scnr = new Scanner(s);
    	int gridSize = Integer.parseInt(scnr.nextLine().replaceAll(",", ""));

    	for (int i = 0; i < grids.length; ++i) {
    		grids[i] = new Grid(gridSize, gridSize, scnr.nextLine().split(","));
    	}

    	scnr.close();
    }

    //compare this Answer object to another, and return a new Answer object whose cells mark
    //whether or not there is a difference in that cell between the two compared Answers
    public Answer compareTo(Answer other) {
        Grid[] newGrid = new Grid[3];
        
        for(int i = 0; i < grids.length; ++i) {
        	newGrid[i] = grids[i].compareTo(other.grids[i]);
        }
        return new Answer(newGrid);
    }
    
    //set one of the Grid objects
    public void setGrid(int i, Grid grid) {
        grids[i] = grid;
    }

    //get the Grid objects
    public Grid[] getGrids() {
        return grids;
    }

    //check if all the cells in two Answer objects have the same state
    @Override
    public boolean equals(Object obj) {
    	if (!(obj instanceof Answer)) {
    		return false;
    	}
    	
    	Answer other = (Answer)obj;

    	for (int i = 0; i < grids.length; ++i) {
    		if (!(grids[i].equals(other.getGrids()[i]))) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    public String toString() {
        String string = "";
        for (int i = 0; i < grids.length; ++i) {
            string += "Grid " + i + ":\n" + grids[i].toString() + "\n";
        }
        return string;
    }
}