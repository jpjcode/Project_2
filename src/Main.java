//Jonathan Joseph
//Edited by Andrew Larrazabal and Lior Sapir

import java.awt.FlowLayout;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
		File infoFile = new File("src\\puzzle1.csv");
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
		
		PuzzleUI p = new PuzzleUI(info);
		TabMenu t = new TabMenu();

		/* 
		frame.add(p);
		frame.add(t);		
		frame.pack();
		frame.setVisible(true);
		*/

		Controller controller = new Controller(p, t, frame);

		


    }
}