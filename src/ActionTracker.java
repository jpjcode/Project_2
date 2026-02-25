//Lior Sapir

/*
 * This class stores a set of Actions in an ArrayList. used to keep track of the user's clicks on the grid to undo them.
 */

import java.util.ArrayList;

public class ActionTracker {
	private ArrayList<Action> actionHistory = new ArrayList<Action>();
	
	public ActionTracker() {
		actionHistory = new ArrayList<Action>();
	}
	
	public ActionTracker(ArrayList<Action> actions) {
		actionHistory = actions;
	}
	
	//add an action to the ArrayList
	public void addAction(GridListener l, GridCellPanel cell, CellState state) {
		actionHistory.add(new Action(l, cell, state));
		
		if (actionHistory.size() > 15) {
			actionHistory.removeFirst();
		}
	}
	
	public void addAction(Action a) {
		actionHistory.add(a);
		
		if (actionHistory.size() > 15) {
			actionHistory.removeFirst();
		}
	}
	
	//get the most recent action
	public Action getLastAction() {
		return actionHistory.getLast();
	}
	
	//remove the most recent action
	public void removeLastAction() {
		actionHistory.removeLast();
	}
	
	//clear the ArrayList
	public void clear() {
		actionHistory = new ArrayList<Action>();
	}
	
	//return whether any Actions are stored
	public boolean isEmpty() {
		return actionHistory.size() == 0;
	}
}
