
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JLabel;

//*************************************************************

public class GameBoard extends JPanel {

	// Length of board grid. Constant for use in switch statement.
	private static final int GRIDSIZE = 8;
	
	// Dummy version of game board for circle retrieval. 
	private List<LightsOutCircle> circles;
	
	// Dynamic game state counters
	private static int yellowCount;
	private static int blackCount;
	
	//*************************************************************
	
	public GameBoard() {
		
		circles = new ArrayList<>();
		yellowCount = 0;
		blackCount = 0;
		
		setLayout(new GridLayout(8,8));
		
		for (int row=1; row<=GRIDSIZE; row++) {
			
			for (int col=1; col<=GRIDSIZE; col++) {
				
				LightsOutCircle circle = new LightsOutCircle(row, col);
				circle.addActionListener(new ClickListener());
				circles.add(circle);
				this.add(circle);
				setYellowCount(getYellowCount() + 1);
				
			}
		}
		
	}  // end GameBoard constructor
	
	//*************************************************************
	
	public boolean gameOver() {
		
		return ((yellowCount == 0) && (blackCount == GRIDSIZE * GRIDSIZE));
	
	}
	
	//*************************************************************
	
	public static int getYellowCount() {
		return yellowCount;
	}
	
	public void setYellowCount(int i) {
		yellowCount = i;
	}
	
	public static int getBlackCount() {
		return blackCount;
	}
	
	public void setBlackCount(int i) {
		blackCount = i;
	}
	
	//*************************************************************
	
	public class ClickListener implements ActionListener {
		
		//*************************************************************
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			List<Integer> neighbors = findNeighbors(e);
			
			for (Integer index: neighbors) {
				swapColors(circles.get(index));
			}
			
			setLabelScore(e);
			 
			if (gameOver()) {
				LightsOut.displayWinner();
			}
			
		}  // end actionPerformed
		
		//*************************************************************
		
		private void swapColors(LightsOutCircle circle) {
			
			if (circle.isBlack()) {
				circle.setYellow();
				setYellowCount(getYellowCount() + 1);
				setBlackCount(getBlackCount() - 1);
			} 
			else if (circle.isYellow()) {
				circle.setBlack();
				setBlackCount(getBlackCount() + 1);
				setYellowCount(getYellowCount() - 1);	
			}
			
		} // End swapColors
			
		//*************************************************************
		
		private int findIndex(int row, int col) {
			
			return row * GRIDSIZE + col;
			
		}
		
		//*************************************************************
		
		private List<Integer> findNeighbors(ActionEvent e) {
			
			Map<String, Integer> neighbors;
			LightsOutCircle source;
			
			source = (LightsOutCircle) e.getSource();
			
			// Coordinates of origin circle
			Integer x = source.row;	
			Integer y = source.col;
			
			// Find the indexes of neighbors both on the board and beyond.
			neighbors = new HashMap<>();
			neighbors.put("north", findIndex((x - 1), y));
			neighbors.put("south", findIndex((x + 1), y));
			neighbors.put("east", findIndex(x, (y + 1)));
			neighbors.put("west", findIndex(x, (y - 1)));
			
			// Remove neighbors that would fall off the board
			switch (x) {
				case 1: 		neighbors.remove("north");
								break;
				case GRIDSIZE:	neighbors.remove("south");
			}
			switch (y) {
				case 1: 		neighbors.remove("west");
								break;
				case GRIDSIZE:	neighbors.remove("east");
			}
			
			// Return only the index integers
			return new ArrayList<Integer>(neighbors.values());
			
		}  // end findNeighbors
		
		//*************************************************************

		private void setLabelScore(ActionEvent e) {
			
			Component source;
			LightsOut lightsOut;
			ControlPanel controlPanel;
			
			source = (Component) e.getSource();
			
			// Find the root component.
			while (source.getParent() != null) {
				source = source.getParent();
			}
			
			// Access the control panel from the root and update the labels.
			if (source instanceof LightsOut) {
				lightsOut = (LightsOut) source;
				controlPanel = (ControlPanel) lightsOut.controlPanel;
				controlPanel.setBlackLabel(blackCount);
				controlPanel.setYellowLabel(yellowCount);
			}
			
		} // End swapColors
	}  // end class CircleClick
	
	//*************************************************************

}  // end class GameBoard

//*************************************************************
