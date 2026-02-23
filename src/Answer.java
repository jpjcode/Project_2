class Answer {

    private Grid grid;
    private Grid grid2;
    private Grid grid3;


    public Answer(Grid grid, Grid grid2, Grid grid3) {
        this.grid = grid;
        this.grid2 = grid2;
        this.grid3 = grid3;
    }
    public boolean compareCell(Answer other, int i, int j) {
        return grid.getGridCell(i, j).equals(other.getGrid().getGridCell(i, j)) &&
               grid2.getGridCell(i, j).equals(other.getGrid2().getGridCell(i, j)) &&
               grid3.getGridCell(i, j).equals(other.getGrid3().getGridCell(i, j));
    }
    public void setGrid(Grid grid) {
        this.grid = grid;
    }
    public void setGrid2(Grid grid2) {
        this.grid2 = grid2;
    }
    public void setGrid3(Grid grid3) {
        this.grid3 = grid3;
    }
    public Grid getGrid() {
        return grid;
    }
    public Grid getGrid2() {
        return grid2;
    }
    public Grid getGrid3() {
        return grid3;
    }
    public String toString() {
        String string = "";
        string += "Grid 1:\n" + grid.toString() + "\n";
        string += "Grid 2:\n" + grid2.toString() + "\n";
        string += "Grid 3:\n" + grid3.toString() + "\n";
        return string;
    }
}