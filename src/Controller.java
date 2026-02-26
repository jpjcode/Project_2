//Jonathan Joseph
//Edited by Lior Sapir

/*
 * This class is responsible for all functionality and interactivity in the program. It 
 * detects user input using JButtons and GridListeners and makes the corresponding changes
 * to both the view and model of the program. It implements actionlistener so that it can
 * listen to its buttons.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Controller extends JPanel implements ActionListener {

	//store the puzzle grid and the table from the tab menu
    private PuzzleUI puzzleUI;
    private JTable table;
    
    //store the correct answer and the current state of the puzzle grid
    private Answer correctAnswer;
    private Answer userAnswer;
    
    //store the grid listeners and the action history tracker
    private GridListener[] gridListeners;
    private ActionTracker actionTracker;

    public Controller() {
    	//does nothing without parameters
    }
    
    public Controller(PuzzleUI puzzleUI, TabMenu tabMenu, PuzzleInfo info) {
    	setBackground(Color.WHITE);
    	
    	//initialize reference variables with new objects using the correct information from PuzzleInfo
        this.puzzleUI = puzzleUI;
        this.table = tabMenu.getAnswerTable();
        
        this.correctAnswer = info.getAnswer();
        this.userAnswer = new Answer(info.getCandidates()[0].length);
        
        this.gridListeners = new GridListener[correctAnswer.getGrids().length];
        this.actionTracker = new ActionTracker();
        
        //initialize the gridlisteners, providing them with the correct GridLabelGroups, Grids, and JTable
        GridLabelGroup[][] labelPairs = puzzleUI.getGridLabelGroupPairs();
        
        for (int i = 0; i < table.getColumnCount() - 1; ++i) {
        	gridListeners[i] = new GridListener(labelPairs[i][0], labelPairs[i][1], userAnswer.getGrids()[i], actionTracker, table, i + 1);
        	puzzleUI.getGridPanels()[i].addGridListener(gridListeners[i]);
        }
        for (int i = table.getColumnCount() - 1; i < labelPairs.length; ++i) {
        	gridListeners[i] = new GridListener(labelPairs[i][0], labelPairs[i][1], userAnswer.getGrids()[i], actionTracker);
        	puzzleUI.getGridPanels()[i].addGridListener(gridListeners[i]);
        }

        //create jbutton objects for all the button functions
        JButton undo = new JButton("Undo");
        JButton hint = new JButton("Hint");
        JButton clearErrors = new JButton("Clear Errors");
        JButton startOver = new JButton("Start Over");
        JButton submit = new JButton("Submit");
     
        //set their action commands so that the Controller can differentiate between each button
        undo.setActionCommand("undo");
        hint.setActionCommand("hint");
        clearErrors.setActionCommand("clear_errors");
        startOver.setActionCommand("start_over");
        submit.setActionCommand("submit");
        
        //add the controller as an action listener to the buttons
        undo.addActionListener(this);
        hint.addActionListener(this);
        clearErrors.addActionListener(this);
        startOver.addActionListener(this);
        submit.addActionListener(this);
   
        //add the buttons to the panel
        add(undo);
        add(hint);
        add(clearErrors);
        add(startOver);
        add(submit);
    }

    //perform a certain action to the game depending on what button is pressed
	@Override
	public void actionPerformed(ActionEvent e) {
		//undo the most recent action
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
        //find first unmarked correct answer and highlight it
        else if (e.getActionCommand().equals("hint")) {
        	
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
        	
        }
        //clear any errors on the grid by using CompareTo with the user answer and correct answer
        else if (e.getActionCommand().equals("clear_errors")) {

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
        	
        	//clear action history and control panel background
        	setBackground(Color.WHITE);
        	actionTracker.clear();
        	
        }
        //reset the game
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
        //submit the puzzle and recieve feedback on whether your puzzle grid is correct or not
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
