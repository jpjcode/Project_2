//Lior Sapir

import javax.swing.*;
import java.awt.*;

public class GridCellPanel extends JPanel {
	
	//static variables for colors
	public static final Color X_RED = new Color(140, 31, 17);
	public static final Color CIRCLE_GREEN = new Color(123, 192, 109);
	public static final Color HOVER_YELLOW = new Color(252, 250, 167);
	
	private CellState state;
	private boolean isHovering;
	
	private GridLabel sLabel;
	private GridLabel tLabel;
	
	private int gridX;
	private int gridY;
	
	public GridCellPanel(int x, int y, GridLabel s, GridLabel t) {
		gridX = x;
		gridY = y;
		
		sLabel = s;
		tLabel = t;
		
		state = CellState.EMPTY;
		isHovering = false;
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(PuzzleUI.CELL_SIZE, PuzzleUI.CELL_SIZE));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//could set the border instead of doing this
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth(), getHeight());
		
		if (state == CellState.CORRECT) {
			g.setColor(CIRCLE_GREEN);
			int margin = (getWidth() / 10);
			g.fillOval(margin, margin, getWidth() - margin * 2, getHeight() - margin * 2);
		}
		else if (state == CellState.INCORRECT) {
			g.setColor(X_RED);
			Graphics2D g2D = (Graphics2D)(g.create());
			g2D.setStroke(new BasicStroke(2));
			int margin = (getWidth() / 6);
			g2D.drawLine(margin, margin, getWidth() - margin, getHeight() - margin);
			g2D.drawLine(margin, getHeight() - margin, getWidth() - margin, margin);
			g2D.dispose();
		}
	}
	
	public void setState(CellState newState) {
		state = newState;
		repaint();
	}
	
	public void cycleState() {
		if (state == CellState.EMPTY) {
			state = CellState.INCORRECT;
		}
		else if (state == CellState.INCORRECT) {
			state = CellState.CORRECT;
		}
		else {
			state = CellState.EMPTY;
		}
		repaint();
	}
	
	public void setHovering(boolean hovering) {
		if (hovering) {
			isHovering = true;
			setBackground(HOVER_YELLOW);
			
			sLabel.setHighlighted(true);
			tLabel.setHighlighted(true);
		}
		else {
			isHovering = false;
			setBackground(Color.WHITE);
			
			sLabel.setHighlighted(false);
			tLabel.setHighlighted(false);
		}
	}
	
	public boolean isHovering() {
		return isHovering;
	}
	
	public int getGridX() {
		return gridX;
	}
	
	public int getGridY() {
		return gridY;
	}
}
