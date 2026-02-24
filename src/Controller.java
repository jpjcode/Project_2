//Jonathan Joseph
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
public class Controller implements ActionListener {

    private PuzzleUI puzzleUI;

    private TabMenu tabMenu;

    private Answer answer;

    private JButton submit;
    private JButton clearErrors;

    public Controller(PuzzleUI puzzleUI, TabMenu tabMenu, JFrame frame) {
        super();

        this.puzzleUI = puzzleUI;
        this.tabMenu = tabMenu;

        submit = new JButton("Submit");
        clearErrors = new JButton("Clear Errors");

        submit.setActionCommand("submit");
        clearErrors.setActionCommand("clear_errors");

        submit.addActionListener(this);
        clearErrors.addActionListener(this);
        
        frame.add(puzzleUI);
        frame.add(tabMenu);
        frame.add(submit);
        frame.add(clearErrors);
        frame.pack();
        frame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("submit")) {

            System.out.print(e);

        }
        if(e.getActionCommand().equals("clear_errors")) {

        }
	}
}
