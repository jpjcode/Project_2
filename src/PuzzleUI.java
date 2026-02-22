package cs225project2;

//Lior Sapir

import java.awt.*;
import javax.swing.*;

public class PuzzleUI extends JPanel {
	public static final int MIN_GRID_SIZE = 132;
	public static final int MIN_CELL_SIZE = 23;
	
	private int cellSize;
	private int gridSize;
	
	public PuzzleUI() {
		this(4);
	}
	
	public PuzzleUI(int numCandidates) {	
		cellSize = (MIN_GRID_SIZE / numCandidates < MIN_CELL_SIZE) ? MIN_CELL_SIZE : MIN_GRID_SIZE / numCandidates;
		gridSize = cellSize * numCandidates;
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(gridSize * 3 + 4 * 6, gridSize * 3 + 4 * 6));
		setLayout(new FlowLayout(FlowLayout.CENTER, 4, 4));
		setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
		
		//empty panels to fill space
		JPanel pEmpty = new JPanel();
		JPanel pEmpty2 = new JPanel();
		pEmpty.setBackground(getBackground());
		pEmpty2.setBackground(getBackground());
		pEmpty.setPreferredSize(new Dimension(gridSize, gridSize));
		pEmpty2.setPreferredSize(new Dimension(gridSize, gridSize));
		
		//FIXME:placeholder
		String[] text = {"label1", "label2", "label3", "label4"}; 
		
		//grid labels
		GridLabelGroup lt1 = new GridLabelGroup(text, gridSize, true);
		GridLabelGroup ls1 = new GridLabelGroup(text, gridSize, false);
		
		GridLabelGroup lt2 = new GridLabelGroup(text, gridSize, true);
		GridLabelGroup ls2 = new GridLabelGroup(text, gridSize, false);
		
		//grids
		GridPanel grid = new GridPanel(numCandidates, gridSize);
		GridPanel grid2 = new GridPanel(numCandidates, gridSize);
		GridPanel grid3 = new GridPanel(numCandidates, gridSize);
		
		grid.addGridListener(new GridListener(ls1, lt1));
		grid2.addGridListener(new GridListener(ls1, lt2));
		grid3.addGridListener(new GridListener(ls2, lt1));
		
		//add components into panel
		//row 1
		add(pEmpty);
		add(lt1);
		add(lt2);
		
		//row 2
		add(ls1);
		add(grid);
		add(grid2);
		
		//row 3
		add(ls2);	
		add(grid3);
		add(pEmpty2);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		Graphics2D g2D = (Graphics2D)(g.create());
		g2D.setStroke(new BasicStroke(8));
		
		//paint a border around each component except the invisible panels
		for (Component c : getComponents()) {
			if ((c instanceof GridPanel) || (c instanceof GridLabelGroup)) {
				g2D.draw(c.getBounds());
			}
		}
		
		g2D.dispose();
	}

	public void startGame() {
				JFrame frame = new JFrame();
				frame.setSize(800, 700);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new FlowLayout());
				
				PuzzleUI p = new PuzzleUI(4);
				frame.add(p);
				frame.setVisible(true);	
	}
}
