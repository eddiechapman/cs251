import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//*************************************************************

public class LightsOut extends JFrame {
	
	GameBoard gameBoard;
	ControlPanel controlPanel;
	
	//*************************************************************

	public LightsOut() {
		
		super();
		setTitle("LightsOut");
		setSize(800, 750);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		createContents();
		setVisible(true);
	
	}
	
	//*************************************************************
	
	public void createContents() {
		
		gameBoard = new GameBoard();
		controlPanel = new ControlPanel();
		add(gameBoard, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.EAST);
		
	}
	
	//*************************************************************
	
	public static void displayWinner() {
			
		JOptionPane.showMessageDialog(new JFrame(), "You Win!");
		
	}
	
	//*************************************************************
	
	public static void main(String[] args) {
		
		new LightsOut();
		
	}
	
}
