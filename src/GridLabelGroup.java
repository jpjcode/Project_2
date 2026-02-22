//Lior Sapir

import javax.swing.*;
import java.awt.*;

public class GridLabelGroup extends JPanel {
	
	private GridLabel[] labels;
	
	public GridLabelGroup() {
		this(new String[] {"", "", "", ""});
	}
	
	public GridLabelGroup(String[] text) {
		this(text, 132);
	}
	
	public GridLabelGroup(String[] text, int groupSize) {
		this(text, groupSize, false);
	}
	
	public GridLabelGroup(String[] text, int groupSize, boolean sideways) {
		int labelWidth = groupSize / text.length;
		
		labels = new GridLabel[text.length];
		
		if (sideways) {
			setLayout(new GridLayout(1, text.length));
		}
		else {
			setLayout(new GridLayout(text.length, 1));
		}
		
		for (int i = 0; i < text.length; ++i) {
			labels[i] = new GridLabel(text[i], labelWidth, groupSize, sideways);
			add(labels[i]);
		}
	}
	
	public GridLabel[] getLabels() {
		return labels;
	}
}
