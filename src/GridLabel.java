//Lior Sapir

import javax.swing.*;
import java.awt.*;

public class GridLabel extends JPanel {
	
	public static final Color HIGHLIGHT_BLUE = new Color(228, 233, 250);
	
	private JLabel text;
	
	public GridLabel() {
		this("");
	}
	
	public GridLabel(String label) {
		this(label, 33, 132);
	}
	
	public GridLabel(String label, int width, int length) {
		this(label, width, length, false);
	}
	
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
