//Jonathan Joseph
//edited by Andrew Larrazabal and Lior Sapir

import java.util.Scanner;

class Answer {

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
    public Answer(String s) {
    	grids = new Grid[3];
    	Scanner scnr = new Scanner(s);
    	int gridSize = Integer.parseInt(scnr.nextLine().replaceAll(",", ""));

    	for (int i = 0; i < grids.length; ++i) {
    		grids[i] = new Grid(gridSize, gridSize, scnr.nextLine().split(","));
    	}

    	scnr.close();
    }

    public Answer compareTo(Answer other) {
        Grid[] newGrid = new Grid[3];
        
        for(int i = 0; i < grids.length; ++i) {
        	newGrid[i] = grids[i].compareTo(other.grids[i]);
        }
        return new Answer(newGrid);
    }
    
    public void setGrid(int i, Grid grid) {
        grids[i] = grid;
    }

    public Grid[] getGrids() {
        return grids;
    }

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