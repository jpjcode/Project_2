//Lior Sapir

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GridCellPanel extends JPanel {
	
	//static variables for various colors
	public static final Color X_RED = new Color(140, 31, 17);
	public static final Color CIRCLE_GREEN = new Color(123, 192, 109);
	public static final Color HOVER_YELLOW = new Color(252, 250, 167);
	public static final Color HINT_YELLOW = new Color(252, 253, 86);
	public static final Color ERROR_RED = new Color(241, 195, 203);
	
	//store the panel state and whether the panel is being hovered on
	private CellState state;
	private boolean isHovering;
	
	//store the cells's position in the grid panel
	private int gridX;
	private int gridY;
	
	public GridCellPanel() {
		this(33);
	}
	
	public GridCellPanel(int cellSize) {
		this(cellSize, -1, 1);
	}
	
	public GridCellPanel(int cellSize, int x, int y) {
		gridX = x;
		gridY = y;
		
		state = CellState.EMPTY;
		isHovering = false;
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(cellSize, cellSize));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//draw a border
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth(), getHeight());
		
		// draw a green circle if the state is correct
		if (state == CellState.CORRECT) {
			g.setColor(CIRCLE_GREEN);
			int margin = (getWidth() / 10);
			g.fillOval(margin, margin, getWidth() - margin * 2, getHeight() - margin * 2);
		}
		//draw a red x if the state is incorrect
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
	
	//getters and setters for state
	public CellState getState() {
		return state;
	}
	
	public void setState(CellState newState) {
		state = newState;
		repaint();
	}
	
	//cycle between the 3 possible states
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
	
	//set whether the mouse is hovering on this panel
	public void setHovering(boolean hovering) {
		if (hovering) {
			isHovering = true;
			setBackground(HOVER_YELLOW);
		}
		else {
			isHovering = false;
			setBackground(Color.WHITE);
		}
	}
	
	//return whether the mouse is hovering on this panel
	public boolean isHovering() {
		return isHovering;
	}
	
	//get grid coordinates
	public int getGridX() {
		return gridX;
	}
	
	public int getGridY() {
		return gridY;
	}
}
