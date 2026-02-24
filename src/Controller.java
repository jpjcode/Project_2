import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
public class Controller implements ActionListener {

    private PuzzleUI puzzleUI;

    private JButton submit;
    private JButton clearErrors;

    public Controller(PuzzleUI puzzleUI, JFrame frame) {
        super();

        this.puzzleUI = puzzleUI;

        submit = new JButton();
        clearErrors = new JButton();

        submit.setActionCommand("submit");
        clearErrors.setActionCommand("clear_errors");

        submit.addActionListener(this);
        clearErrors.addActionListener(this);
        
        frame.add(puzzleUI);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("submit")) {

        }
        if(e.getActionCommand().equals("clear_errors")) {

        }
	}
}
