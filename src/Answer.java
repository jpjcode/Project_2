class Answer {

    //FixMe: I might need to change the type of grid instead of boolean[][]
    /* 
    private Grid grid;
    private Grid grid2;
    private Grid grid3;

    public Answer(Grid grid, Grid grid2, Grid grid3) {
        this.grid = grid;
        this.grid2 = grid2;
        this.grid3 = grid3;
    }
    */

    private boolean[][] grid;
    private boolean[][] grid2;
    private boolean[][] grid3;


    public Answer(boolean[][] grid, boolean[][] grid2, boolean[][] grid3) {
        this.grid = grid;
        this.grid2 = grid2;
        this.grid3 = grid3;
    }

    public boolean getCellState(int i, int j) {
        return grid[i][j];
    }
    public void setGrid(boolean[][] grid) {
        this.grid = grid;
    }
    public void setGrid2(boolean[][] grid2) {
        this.grid2 = grid2;
    }
    public void setGrid3(boolean[][] grid3) {
        this.grid3 = grid3;
    }
    public boolean[][] getGrid() {
        return grid;
    }
    public boolean[][] getGrid2() {
        return grid2;
    }
    public boolean[][] getGrid3() {
        return grid3;
    }
}