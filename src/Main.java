//Jonathan Joseph
//Edited by Andrew Larrazabal and Lior Sapir

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Main class runs the whole program.
 */
class Main {
    public static void main(String[] args) throws FileNotFoundException {
		File infoFile = new File("src\\puzzle1.csv");
		PuzzleInfo info = new PuzzleInfo(infoFile);

		JFrame frame = new JFrame("Logic Puzzle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(4, 0));
		JPanel leftPanel =  new JPanel(new BorderLayout());
		
		PuzzleUI puzzle = new PuzzleUI(info);
		TabMenu tabs = new TabMenu(info);
		Controller controller = new Controller(puzzle, tabs, info);
		
		leftPanel.add(puzzle, BorderLayout.CENTER);
		leftPanel.add(controller, BorderLayout.SOUTH);
		
		frame.add(tabs, BorderLayout.EAST);
		frame.add(leftPanel, (BorderLayout.WEST));
		frame.pack();
		frame.setVisible(true);
    }
}