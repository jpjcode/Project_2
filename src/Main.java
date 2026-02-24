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
		Grid testGrid = new Grid(info.getCandidates()[0].length, info.getCandidates()[0].length, "3 2 1 0");
		Answer testAnswer = new Answer("4\n0 1 2 3\n0 1 2 3\n 0 1 2 3");

		for (int i = 0; i < testGrid.getGridHeight(); i++) {
			for (int j=0; j < testGrid.getGridWidth(); j++) {
				System.out.print(testGrid.getGridCell(j, i).getState());
			}
			System.out.println();
		}

				System.out.println("Test Grid:\n");
		for (int i = 0; i < testGrid.getGridHeight(); i++) {
			for (int j=0; j < testGrid.getGridWidth(); j++) {
				System.out.print(testGrid.getGridCell(j, i).getState());
			}
			System.out.println();
		}

		System.out.println();

		System.out.println("Test Answer Grid 1:\n");
		for (int i = 0; i < testAnswer.getGrid().getGridHeight(); i++) {
            for (int j=0; j < testGrid.getGridWidth(); j++) {
                System.out.print(testAnswer.getGrid().getGridCell(j, i).getState());
            }
            System.out.println();
        }

		System.out.println();

		System.out.println("Test Answer Grid 2:\n");
		for (int i = 0; i < testAnswer.getGrid2().getGridHeight(); i++) {
            for (int j=0; j < testGrid.getGridWidth(); j++) {
                System.out.print(testAnswer.getGrid2().getGridCell(j, i).getState());
            }
            System.out.println();
        }

		System.out.println();

		System.out.println("Test Answer Grid 3:\n");
		for (int i = 0; i < testAnswer.getGrid3().getGridHeight(); i++) {
            for (int j=0; j < testGrid.getGridWidth(); j++) {
                System.out.print(testAnswer.getGrid3().getGridCell(j, i).getState());
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