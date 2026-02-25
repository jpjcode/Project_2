//Jonathan Joseph
//Edited by Lior Sapir

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Controller extends JPanel implements ActionListener {

    private PuzzleUI puzzleUI;
    private JTable table;
    
    private Answer correctAnswer;
    private Answer userAnswer;
    
    private GridListener[] gridListeners;
    private ActionTracker actionTracker;

    public Controller(PuzzleUI puzzleUI, TabMenu tabMenu, PuzzleInfo info) {
    	setBackground(Color.WHITE);
    	
        this.puzzleUI = puzzleUI;
        this.table = tabMenu.getAnswerTable();
        
        this.correctAnswer = info.getAnswer();
        this.userAnswer = new Answer(info.getCandidates()[0].length);
        
        this.gridListeners = new GridListener[correctAnswer.getGrids().length];
        this.actionTracker = new ActionTracker();
        
        GridLabelGroup[][] labelPairs = puzzleUI.getGridLabelGroupPairs();
        
        for (int i = 0; i < table.getColumnCount() - 1; ++i) {
        	gridListeners[i] = new GridListener(labelPairs[i][0], labelPairs[i][1], userAnswer.getGrids()[i], actionTracker, table, i + 1);
        	puzzleUI.getGridPanels()[i].addGridListener(gridListeners[i]);
        }
        for (int i = table.getColumnCount() - 1; i < labelPairs.length; ++i) {
        	gridListeners[i] = new GridListener(labelPairs[i][0], labelPairs[i][1], userAnswer.getGrids()[i], actionTracker);
        	puzzleUI.getGridPanels()[i].addGridListener(gridListeners[i]);
        }

        JButton undo = new JButton("Undo");
        JButton hint = new JButton("Hint");
        JButton clearErrors = new JButton("Clear Errors");
        JButton startOver = new JButton("Start Over");
        JButton submit = new JButton("Submit");
     
        undo.setActionCommand("undo");
        hint.setActionCommand("hint");
        clearErrors.setActionCommand("clear_errors");
        startOver.setActionCommand("start_over");
        submit.setActionCommand("submit");
        
        undo.addActionListener(this);
        hint.addActionListener(this);
        clearErrors.addActionListener(this);
        startOver.addActionListener(this);
        submit.addActionListener(this);
   
        add(undo);
        add(hint);
        add(clearErrors);
        add(startOver);
        add(submit);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("undo")) {
        	//use action tracker to undo recent actions
            if (!actionTracker.isEmpty()) {
            	GridListener l = actionTracker.getLastAction().getGridListener();
            	GridCellPanel cell = actionTracker.getLastAction().getCell();
                CellState state = actionTracker.getLastAction().getState();
                
                actionTracker.removeLastAction();
                
                boolean gridState = (state == CellState.CORRECT) ? true : false;
                
                cell.setState(state);
                l.getGrid().setGridCell(cell.getGridX(), cell.getGridY(), gridState);
                
                if (l.editsTable()) {
                	if (state == CellState.CORRECT) {
                    	table.setValueAt(l.getTLabelGroup().getLabels()[cell.getGridX()].getText(), cell.getGridY(), l.getTableColumn());

                	}
                	else {
                    	table.setValueAt("", cell.getGridY(), l.getTableColumn());
                	}
                }
            }
        	
        }
        else if (e.getActionCommand().equals("hint")) {
        	
        	//find first unmarked correct answer and highlight it
        	boolean hintFound = false;
        	for (int i = 0; i < correctAnswer.getGrids().length; ++i) {
        		Grid answerGrid = correctAnswer.getGrids()[i];
        		Grid userGrid = userAnswer.getGrids()[i];
        		
        		for (int j = 0; j < answerGrid.getGridHeight(); ++j) {
        			for (int k = 0; k < answerGrid.getGridWidth(); ++k) {		
        				if (answerGrid.getGridCell(k, j).getState() && !userGrid.getGridCell(k, j).getState()) {
        					puzzleUI.getGridPanels()[i].getCellPanels()[j][k].setBackground(GridCellPanel.HINT_YELLOW);
        					hintFound = true;
        					break;
        				}
        			}
        			
        			if (hintFound) {
        				break;
        			}
        		}
        		if (hintFound) {
					break;
				}	
        	}
        	
        	//FIXME: debugging
        	for (int i = 0; i < correctAnswer.getGrids().length; ++i) {
        		Grid grid = correctAnswer.getGrids()[i];
        		for (int j = 0; j < grid.getGridHeight(); j++) {
        			for (int k=0; k < grid.getGridWidth(); k++) {
        				System.out.print(grid.getGridCell(k, j).getState());
        			}
        			System.out.println();
        		}
        		System.out.println();
        	}
        	
        	System.out.println("user answer");
        	for (int i = 0; i < userAnswer.getGrids().length; ++i) {
        		Grid grid = userAnswer.getGrids()[i];
        		for (int j = 0; j < grid.getGridHeight(); j++) {
        			for (int k=0; k < grid.getGridWidth(); k++) {
        				System.out.print(grid.getGridCell(k, j).getState());
        			}
        			System.out.println();
        		}
        		System.out.println();
        	}
        }
        else if (e.getActionCommand().equals("clear_errors")) {
        	//clear errors on grid
        	Answer cellsToClear = userAnswer.compareTo(correctAnswer);
        	
        	for (int i = 0; i < userAnswer.getGrids().length; ++i) {
        		Grid grid = userAnswer.getGrids()[i];
        		Grid clearGrid = cellsToClear.getGrids()[i];
        		
        		for (int j = 0; j < grid.getGridHeight(); j++) {
        			for (int k=0; k < grid.getGridWidth(); k++) {
        				
        				if (!(clearGrid.getGridCell(k, j).getState()) && (grid.getGridCell(k, j).getState())) {
        					puzzleUI.getGridPanels()[i].getCellPanels()[j][k].setState(CellState.EMPTY);
        					puzzleUI.getGridPanels()[i].getCellPanels()[j][k].setBackground(GridCellPanel.ERROR_RED);
            				grid.setGridCell(k, j, false);
            				
            				if (i < 2) {
            					table.setValueAt("", j, i + 1);
            				}
        				}
        				else if (!(clearGrid.getGridCell(k, j).getState()) && (puzzleUI.getGridPanels()[i].getCellPanels()[j][k].getState() == CellState.INCORRECT)) {
        					puzzleUI.getGridPanels()[i].getCellPanels()[j][k].setState(CellState.EMPTY);
        					puzzleUI.getGridPanels()[i].getCellPanels()[j][k].setBackground(GridCellPanel.ERROR_RED);
        				}
        				
        			}
        		}
        	}
        	
        	actionTracker.clear();
        }
        else if (e.getActionCommand().equals("start_over")) {
        	
        	//clear grids and grid panels
        	for (int i = 0; i < userAnswer.getGrids().length; ++i) {
        		Grid grid = userAnswer.getGrids()[i];
        		
        		for (int j = 0; j < grid.getGridHeight(); j++) {
        			for (int k = 0; k < grid.getGridWidth(); k++) {
        				puzzleUI.getGridPanels()[i].getCellPanels()[j][k].setState(CellState.EMPTY);
        				grid.setGridCell(k, j, false);
        			}
        		}
        	}
        	
        	//clear answer table
        	for (int i = 1; i < table.getColumnCount(); ++i) {
        		for (int j = 0; j < table.getRowCount(); ++j) {
        			table.setValueAt("", j, i);
        		}
        	}
        	
        	actionTracker.clear();
        	
        }
        else if (e.getActionCommand().equals("submit")) {
        	
        	if (!(userAnswer.equals(correctAnswer))) {
        		setBackground(Color.RED);
        	}
        	else {
        		setBackground(Color.GREEN);
        	}
        }
	}
}
