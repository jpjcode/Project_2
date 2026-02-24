//Lior Sapir
//edited by Andrew Larrazabal
//edited by Jonathan Joseph

import java.awt.*;
import javax.swing.*;

public class PuzzleUI extends JPanel {
	public static final int MIN_GRID_SIZE = 132;
	public static final int MIN_CELL_SIZE = 23;

	private GridLabelGroup lt1;
	private GridLabelGroup lt2;
	
	private GridLabelGroup ls1;
	private GridLabelGroup ls2;
	
	private GridPanel grid1;
	private GridPanel grid2;
	private GridPanel grid3;
	
	public PuzzleUI() {
		this(4);
	}
	
	public PuzzleUI(int numCandidates) {	
		int cellSize = (MIN_GRID_SIZE / numCandidates < MIN_CELL_SIZE) ? MIN_CELL_SIZE : MIN_GRID_SIZE / numCandidates;
		int gridSize = cellSize * numCandidates;
		
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
		
		String[] text = new String[numCandidates];
		
		for (int i = 0; i < numCandidates; ++i) {
			text[i] = "";
		}
		
		//grid labels
		lt1 = new GridLabelGroup(text, gridSize, true);
		lt2 = new GridLabelGroup(text, gridSize, true);
		
		ls1 = new GridLabelGroup(text, gridSize, false);
		ls2 = new GridLabelGroup(text, gridSize, false);
		
		//grids
		grid1 = new GridPanel(numCandidates, gridSize);
		grid2 = new GridPanel(numCandidates, gridSize);
		grid3 = new GridPanel(numCandidates, gridSize);
		
		//add components into panel
		//row 1
		add(pEmpty);
		add(lt1);
		add(lt2);
		
		//row 2
		add(ls1);
		add(grid1);
		add(grid2);
		
		//row 3
		add(ls2);	
		add(grid3);
		add(pEmpty2);
	}

	public PuzzleUI(PuzzleInfo info) {
		int numCandidates = info.getCandidates()[0].length;
		int cellSize = (MIN_GRID_SIZE / numCandidates < MIN_CELL_SIZE) ? MIN_CELL_SIZE : MIN_GRID_SIZE / numCandidates;
		int gridSize = cellSize * numCandidates;
		
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
		
		//grid labels
		lt1 = new GridLabelGroup(info.getCandidates()[1], gridSize, true);
		lt2 = new GridLabelGroup(info.getCandidates()[2], gridSize, true);
		
		ls1 = new GridLabelGroup(info.getCandidates()[0], gridSize, false);
		ls2 = new GridLabelGroup(info.getCandidates()[2], gridSize, false);
		
		//grids
		grid1 = new GridPanel(numCandidates, gridSize);
		grid2 = new GridPanel(numCandidates, gridSize);
		grid3 = new GridPanel(numCandidates, gridSize);
		
		//add components into panel
		//row 1
		add(pEmpty);
		add(lt1);
		add(lt2);
		
		//row 2
		add(ls1);
		add(grid1);
		add(grid2);
		
		//row 3
		add(ls2);	
		add(grid3);
		add(pEmpty2);
	}
	
	public GridLabelGroup[][] getGridLabelGroupPairs() {
		return new GridLabelGroup[][] {{ls1, lt1}, {ls1, lt2}, {ls2, lt1}};
	}
	
	public GridPanel[] getGridPanels() {
		return new GridPanel[] {grid1, grid2, grid3};
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
}
