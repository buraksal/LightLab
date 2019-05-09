package blackBoxGame;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class blackBoxGamePanel extends JPanel{
	
	JFrame currentFrame;
	
	public blackBoxGamePanel (JFrame currentFrame) {
		currentFrame.setContentPane(this);
		initialize(currentFrame);
		
	}

	private void initialize(JFrame currentFrame) {
		
		
	}
}
