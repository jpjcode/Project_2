//Lior Sapir

import java.awt.*;
import javax.swing.*;
/**
 * GridLabelGroup stores a multiple labels.
 */
public class GridLabelGroup extends JPanel {
	/**
	 * Array of GridLabel objects.
	 */
	private GridLabel[] labels;
	
	/**
	 * Default constructor that leaves an empty text.
	 */
	public GridLabelGroup() {
		this(new String[] {"", "", "", ""});
	}
	
	public GridLabelGroup(String[] text) {
		this(text, 132);
	}
	
	public GridLabelGroup(String[] text, int groupSize) {
		this(text, groupSize, false);
	}
	
	/**
	 * Constructor recieves text, integer value of the size of the group, and a boolean that tells reather it is sideway.
	 * @param text
	 * @param groupSize
	 * @param sideways
	 */
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
