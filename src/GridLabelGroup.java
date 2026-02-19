package cs225project2;

//Lior Sapir

import javax.swing.*;
import java.awt.*;

public class GridLabelGroup extends JPanel {
	
	GridLabel[] labels;
	
	public GridLabelGroup(boolean sideways) {
		labels = new GridLabel[PuzzleUI.NUM_CANDIDATES];
		
		if (sideways) {
			setLayout(new GridLayout(1, PuzzleUI.NUM_CANDIDATES));
		}
		else {
			setLayout(new GridLayout(PuzzleUI.NUM_CANDIDATES, 1));
		}
		
		for (int i = 0; i < PuzzleUI.NUM_CANDIDATES; ++i) {
			labels[i] = new GridLabel("label", sideways);
			add(labels[i]);
		}
	}
	
	public GridLabel[] getLabels() {
		return labels;
	}
}

