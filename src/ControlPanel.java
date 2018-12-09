import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
	
	private JLabel yellow, black, reset;

	public ControlPanel() {
		
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		yellow = new JLabel();
		black = new JLabel();
		reset = new JLabel();
		
		add(yellow);
		add(black);
		add(reset);
		
	}
	
	public JLabel getYellowLabel() {
		return yellow;
	}
	
	public void setYellowLabel(int i) {
		yellow.setText("Yellow Count: " + Integer.toString(i));
	}
	
	public JLabel getBlackLabel() {
		return black;
	}
	
	public void setBlackLabel(int i) {
		black.setText("Black Count: " + Integer.toString(i));
	}
	
}
