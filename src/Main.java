//Jonathan Joseph
//Edited by Andrew Larrazabal and Lior Sapir

import java.awt.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
		File infoFile = new File("C:\\Users\\Larra\\Desktop\\CS225\\Project_2\\src\\puzzle1.csv");
		PuzzleInfo info = new PuzzleInfo(infoFile);
		Grid testGrid = new Grid(4, 4, "3 2 1 0");

		for (int i = 0; i < testGrid.getGridHeight(); i++) {
			for (int j=0; j < testGrid.getGridWidth(); j++) {
				System.out.print(testGrid.getGridCell(j, i).getState());
			}
			System.out.println();
		}

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		
		PuzzleUI p = new PuzzleUI(4);
		TabMenu t = new TabMenu();
		frame.add(p);
		frame.add(t);		
		frame.pack();
		frame.setVisible(true);	


    }
}