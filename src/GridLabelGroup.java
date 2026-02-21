package cs225project2;

//Lior Sapir

import javax.swing.*;
import java.awt.*;

public class GridLabelGroup extends JPanel {
	
	private GridLabel[] labels;
	
	public GridLabelGroup() {
		this(4);
	}
	
	public GridLabelGroup(int numCandidates) {
		this(numCandidates, 132);
	}
	
	public GridLabelGroup(int numCandidates, int groupSize) {
		this(numCandidates, groupSize, false);
	}
	
	public GridLabelGroup(int numCandidates, int groupSize, boolean sideways) {
		int labelWidth = groupSize / numCandidates;
		
		labels = new GridLabel[numCandidates];
		
		if (sideways) {
			setLayout(new GridLayout(1, numCandidates));
		}
		else {
			setLayout(new GridLayout(numCandidates, 1));
		}
		
		for (int i = 0; i < numCandidates; ++i) {
			labels[i] = new GridLabel("label", labelWidth, groupSize, sideways);
			add(labels[i]);
		}
	}
	
	public GridLabel[] getLabels() {
		return labels;
	}
}
