//Lior Sapir

import javax.swing.*;
import java.awt.*;

public class TabMenu extends JTabbedPane {
	
	public static final Color NOTES_GREY = new Color(240, 240, 240);
	
	public static final String STORY_TIP = "Remember, as with all grid-based logic puzzles, "
			+ "no option in any category will ever be used more than once. If you get "
			+ "stuck or run into problems, try the \"Clear Errors\" button to remove any "
			+ "mistakes that might be present on the grid, or the \"Hint\" button to see "
			+ "the next logical step in the puzzle.";
	
	public static final String NOTES_TIP = "hi";
	
	public static final String ANSWERS_TIP = "hi";
	
	public TabMenu() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(226, 420));
		setTabLayoutPolicy(SCROLL_TAB_LAYOUT);
		
		//clues tab
		JPanel clues = new JPanel();
		setupPanel(clues);
		
		JTextArea cluesTextArea = new JTextArea("Clues\n\n1. Clue 1\n\n2. Clue 2\n\n3.");
		setupTextArea(cluesTextArea);
		
		clues.add(cluesTextArea);
		
		//story tab
		JPanel story = new JPanel();
		setupPanel(story);
		
		JTextArea storyTextArea = new JTextArea("Backstory and Goal\n\nstory blablabla\n");
		setupTextArea(storyTextArea);
		storyTextArea.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(200, 200, 200)));
		
		JTextArea storyTipTextArea = new JTextArea("\n" + STORY_TIP);
		setupTextArea(storyTipTextArea);
		
		story.add(storyTextArea, BorderLayout.NORTH);
		story.add(storyTipTextArea, BorderLayout.CENTER);
		
		//notes tab
		JPanel notes = new JPanel();
		setupPanel(notes);
		
		JTextArea notesTipTextArea = new JTextArea("Notes\n\n" + NOTES_TIP);
		setupTextArea(notesTipTextArea);
				
		JTextArea notesTextArea = new JTextArea();
		notesTextArea.setBackground(NOTES_GREY);
		notesTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		notesTextArea.setLineWrap(true);
		notesTextArea.setWrapStyleWord(true);
		
		notes.add(notesTipTextArea, BorderLayout.NORTH);
		notes.add(notesTextArea, BorderLayout.CENTER);
		
		//answers tab
		JPanel answers = new JPanel();
		setupPanel(answers);
		
		JTextArea answersTextArea = new JTextArea("Answers\n\n" + ANSWERS_TIP);
		setupTextArea(answersTextArea);
		
		answers.add(answersTextArea);
		
		addTab("clues", clues);
		addTab("story", story);
		addTab("notes", notes);
		addTab("answers", answers);
	}
	
	private void setupPanel(JPanel p) {
		p.setBackground(getBackground());
		p.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		p.setLayout(new BorderLayout());
	}
	
	private void setupTextArea(JTextArea a) {
		a.setBackground(getBackground());
		a.setLineWrap(true);
		a.setWrapStyleWord(true);
		a.setCaretColor(new Color(0, 0, 0, 0));
		a.setEditable(false);
	}
}
