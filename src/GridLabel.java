//Lior Sapir

import java.awt.*;
import javax.swing.*;
/*
 * GridLabel class represents the labels. It holds a JLabel object as an attribute.
 * 
 * @author Lior Sapir
 * @verison 1.0.0
 */
public class GridLabel extends JPanel {
	/**
	 * HIGHLIGHT_Blue color
	 */
	public static final Color HIGHLIGHT_BLUE = new Color(228, 233, 250);
	/**
	 * This is the JLabel object attribute.
	 */
	private JLabel text;
	/**
	 * Default contructor.
	 */
	public GridLabel() {
		this("");
	}
	/**
	 * 
	 * @param label
	 */
	public GridLabel(String label) {
		this(label, 33, 132);
	}
	/**
	 * 
	 * @param label
	 * @param width
	 * @param length
	 */
	public GridLabel(String label, int width, int length) {
		this(label, width, length, false);
	}
	/**
	 * Constructors setst he layout with width, length and rather it is sideways.
	 * @param label
	 * @param width
	 * @param length
	 * @param sideways
	 */
	public GridLabel(String label, int width, int length, boolean sideways) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		if (sideways) {
			setPreferredSize(new Dimension(width, length));
			
			text = new SidewaysLabel(label);
			//sideways label needs a square size in order to work properly, otherwise it cuts off text with ellipses
			text.setPreferredSize(new Dimension(length, length));
			text.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
		}
		else {
			setPreferredSize(new Dimension(length, width));
			
			text = new JLabel(label);
			text.setPreferredSize(new Dimension(length, width));
			text.setHorizontalAlignment(JLabel.TRAILING);
			text.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
		}
		
		setBackground(Color.WHITE);
		add(text);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth(), getHeight());
	}
	
	public String getText() {
		return text.getText();
	}
	
	public void setHighlighted(boolean highlighted) {
		if (highlighted) {
			setBackground(HIGHLIGHT_BLUE);
		}
		else {
			setBackground(Color.WHITE);
		}
	}
}
