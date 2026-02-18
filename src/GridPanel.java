//Lior Sapir

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridPanel extends JPanel {
	
	//placeholder for amount of candidates per category
	public static final int NUM_CANDIDATES = 4;
	
	public static final int CELL_WIDTH = 33;
	
	//FIXME: we might not end up needing this array or this custom class at all depending on how GridListener is implemented
	GridCellPanel[][] panels;
	
	public GridPanel() {
		setPreferredSize(new Dimension(NUM_CANDIDATES * CELL_WIDTH + 4, NUM_CANDIDATES * CELL_WIDTH + 4));
		setLayout(new GridBagLayout());
		
		//internalPanel exists to prevent child components from blocking the border of the main grid panel
		//but I might figure out a different way of doing this
		JPanel internalPanel = new JPanel();
		internalPanel.setPreferredSize(new Dimension(NUM_CANDIDATES * CELL_WIDTH, NUM_CANDIDATES * CELL_WIDTH));
		internalPanel.setLayout(new GridLayout(NUM_CANDIDATES, NUM_CANDIDATES));
		
		panels = new GridCellPanel[NUM_CANDIDATES][NUM_CANDIDATES];
		for (int i = 0; i < panels.length; ++i) {
			for (int j = 0; j < panels.length; ++j) {
				panels[i][j] = new GridCellPanel(i, j);
				internalPanel.add(panels[i][j]);
			}
		}
		add(internalPanel);
	}
	
	@Override
	public void addMouseListener(MouseListener l) {
		for (int i = 0; i < panels.length; ++i) {
			for (int j = 0; j < panels.length; ++j) {
				panels[i][j].addMouseListener(l);
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2D = (Graphics2D)(g.create());
		g2D.setStroke(new BasicStroke(4));
		g2D.drawRect(2, 2, getWidth() - 4, getHeight() - 4);
		g2D.dispose();
	}
	
	public static void main(String[] args) {
		
		//Yes I know this code is silly i just wanted to test stuff
		JFrame frame = new JFrame();
		frame.setSize(600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		JPanel p = new JPanel();
		p.setPreferredSize(new Dimension(300, 500));
		p.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		GridPanel grid = new GridPanel();
		GridPanel grid2 = new GridPanel();
		GridPanel grid3 = new GridPanel();
		grid.addMouseListener(new GridListener());
		grid2.addMouseListener(new GridListener());
		grid3.addMouseListener(new GridListener());
		
		p.add(grid);
		p.add(grid2);
		p.add(grid3);
		frame.add(p);
		
		frame.setVisible(true);	
	}

}
