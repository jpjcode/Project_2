//Lior Sapir

import java.util.ArrayList;

public class ActionTracker {
	private ArrayList<Action> actionHistory = new ArrayList<Action>();
	
	public ActionTracker() {
		actionHistory = new ArrayList<Action>();
	}
	
	public ActionTracker(ArrayList<Action> actions) {
		actionHistory = actions;
	}
	
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
	
	public Action getLastAction() {
		return actionHistory.getLast();
	}
	
	public void removeLastAction() {
		actionHistory.removeLast();
	}
	
	public void clear() {
		actionHistory = new ArrayList<Action>();
	}
	
	public boolean isEmpty() {
		return actionHistory.size() == 0;
	}
}
