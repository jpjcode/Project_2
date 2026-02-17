//package cs225project2;

import javax.swing.*;
import java.awt.*;

public class GridCellPanel extends JPanel {
	
	private CellState state;
	private boolean isMouseHovering;
	
	private int gridX;
	private int gridY;
	
	public GridCellPanel() {
		state = CellState.EMPTY;
		setBackground(Color.WHITE);
	}
	
	public GridCellPanel(int gridX, int gridY) {
		state = CellState.EMPTY;
		setBackground(Color.WHITE);
		this.gridX = gridX;
		this.gridY = gridY;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth(), getHeight());
		
		if (state == CellState.CORRECT) {
			g.setColor(Color.GREEN);
			g.fillOval(0, 0, getWidth(), getHeight());
		}
		else if (state == CellState.INCORRECT) {
			g.setColor(Color.RED);
			g.drawLine(0, 0, getWidth(), getHeight());
			g.drawLine(0, getHeight(), getWidth(), 0);
		}
		
	}
	
	public void setState(CellState newState) {
		state = newState;
		repaint();
	}
	
	public void setHovering(boolean hovering) {
		if (hovering) {
			setBackground(Color.BLUE);
		}
		else {
			setBackground(Color.WHITE);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(4, 4));
		
		GridCellPanel cell = new GridCellPanel();
		frame.add(cell);
		for (int i = 0; i < 15; ++i) {
			frame.add(new GridCellPanel());
		}
		frame.setVisible(true);
		
		Thread.sleep(1000);
		cell.setState(CellState.CORRECT);
		cell.setHovering(true);
		Thread.sleep(1000);
		cell.setState(CellState.INCORRECT);
		Thread.sleep(1000);
		cell.setHovering(false);
	}

}
