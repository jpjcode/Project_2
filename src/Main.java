//Jonathan Joseph
//Edited by Andrew Larrazabal and Lior Sapir

import java.awt.FlowLayout;
import javax.swing.JFrame;

class Main {
    public static void main(String[] args) {
    	JFrame frame = new JFrame();
		frame.setSize(800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		PuzzleUI p = new PuzzleUI(4);
		frame.add(p);
		frame.setVisible(true);	
    }
}