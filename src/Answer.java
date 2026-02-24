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
    
    public Answer(String s) {
    	grids = new Grid[3];
    	Scanner scnr = new Scanner(s);
    	int gridSize = Integer.parseInt(scnr.nextLine().replaceAll(",", ""));

    	for (int i = 0; i < grids.length; ++i) {
    		grids[i] = new Grid(gridSize, gridSize, scnr.nextLine().split(","));
    	}

    	scnr.close();
    }

//    public boolean compareCell(Answer other, int i, int j) {
//    	
    //FIXME: change this method to compare individual cells, not the same cell on
    //all grids. A more useful method would be CompareAnswer which would somehow
    //return information on what cells are wrong rather than just true or false
//    	
//        return grid.getGridCell(i, j).equals(other.getGrid().getGridCell(i, j)) &&
//               grid2.getGridCell(i, j).equals(other.getGrid2().getGridCell(i, j)) &&
//               grid3.getGridCell(i, j).equals(other.getGrid3().getGridCell(i, j));
//    }

    public void setGrid(int i, Grid grid) {
        grids[i] = grid;
    }

    public Grid[] getGrids() {
        return grids;
    }

    
    //FIXME: add equals method
    //FIXME: add compareAnswer method which will be used to check answer correctness
    
    public String toString() {
        String string = "";
        for (int i = 0; i < grids.length; ++i) {
            string += "Grid " + i + ":\n" + grids[i].toString() + "\n";
        }
        return string;
    }
}