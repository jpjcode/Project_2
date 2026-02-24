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

    public Controller(PuzzleUI puzzleUI, TabMenu tabMenu, PuzzleInfo info) {
    	setBackground(Color.WHITE);
    	
        this.puzzleUI = puzzleUI;
        this.table = tabMenu.getAnswerTable();
        this.correctAnswer = info.getAnswer();
        
        this.userAnswer = new Answer();
        this.gridListeners = new GridListener[correctAnswer.getGrids().length];
        
        GridLabelGroup[][] labelPairs = puzzleUI.getGridLabelGroupPairs();
        
        for (int i = 0; i < table.getColumnCount() - 1; ++i) {
        	gridListeners[i] = new GridListener(labelPairs[i][0], labelPairs[i][1], userAnswer.getGrids()[i], table, i + 1);
        	puzzleUI.getGridPanels()[i].addGridListener(gridListeners[i]);
        }
        for (int i = table.getColumnCount() - 1; i < labelPairs.length; ++i) {
        	gridListeners[i] = new GridListener(labelPairs[i][0], labelPairs[i][1], userAnswer.getGrids()[i]);
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
            System.out.println(e);
        	
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
        }
        else if (e.getActionCommand().equals("hint")) {
        	System.out.println(e);
        }
        else if (e.getActionCommand().equals("clear_errors")) {
        	System.out.println(e);
        }
        else if (e.getActionCommand().equals("start_over")) {
        	System.out.println(e);
        }
        else if (e.getActionCommand().equals("submit")) {
        	System.out.println(e);
        }
	}
}
