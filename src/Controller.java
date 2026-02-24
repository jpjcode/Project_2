//Jonathan Joseph
//Edited by Lior Sapir

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Controller extends JPanel implements ActionListener {

    private PuzzleUI puzzleUI;
    private TabMenu tabMenu;
    private Answer correctAnswer;
    
    private Answer userAnswer;
    private GridListener[] gridListeners;

    public Controller(PuzzleUI puzzleUI, TabMenu tabMenu, PuzzleInfo info) {
    	setBackground(Color.WHITE);
    	
        this.puzzleUI = puzzleUI;
        this.tabMenu = tabMenu;
        this.correctAnswer = info.getAnswer();
        
        this.userAnswer = new Answer();
        this.gridListeners = new GridListener[correctAnswer.getGrids().length];
        
        GridLabelGroup[][] labels = puzzleUI.getGridLabelGroupPairs();
        for (int i = 0; i < labels.length; ++i) {
        	puzzleUI.getGridPanels()[i].addGridListener(new GridListener(labels[i][0], labels[i][1], userAnswer.getGrids()[i]));
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
        }
        else if (e.getActionCommand().equals("hint")) {
        	System.out.println(e);
        	
        	Grid testGrid = userAnswer.getGrids()[0];
        	
        	for (int i = 0; i < testGrid.getGridHeight(); i++) {
    			for (int j=0; j < testGrid.getGridWidth(); j++) {
    				System.out.print(testGrid.getGridCell(j, i).getState());
    			}
    			System.out.println();
    		}
        }
        else if (e.getActionCommand().equals("clear_errors")) {
        	System.out.println(e);
        }
        else if (e.getActionCommand().equals("start_over")) {
        	System.out.println(e);
        	
        	for (int i = 0; i < correctAnswer.getGrids().length; ++i) {
        		Grid testGrid = correctAnswer.getGrids()[i];
        		for (int j = 0; j < testGrid.getGridHeight(); j++) {
        			for (int k=0; k < testGrid.getGridWidth(); k++) {
        				System.out.print(testGrid.getGridCell(k, j).getState());
        			}
        			System.out.println();
        		}
        		System.out.println();
        	}
        }
        else if (e.getActionCommand().equals("submit")) {
        	System.out.println(e);
        }
	}
}
