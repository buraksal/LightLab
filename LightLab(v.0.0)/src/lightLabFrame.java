import java.awt.Color;

import javax.swing.JFrame;


public class lightLabFrame extends JFrame{

	final static int HEIGHT = 1080;
	final static int WIDTH = 1920;
	
	public static void main(String[] args) {
		
		JFrame gameFrame = new JFrame("LightLab - v0.0");
		
		// setting the size of the frame
		gameFrame.setBounds(0,0, WIDTH, HEIGHT);
		// Setting the layout of the frame
		gameFrame.setLayout( null );
		gameFrame.getContentPane().setBackground(Color.DARK_GRAY);
		
		// adding default close operation to the frame and making it visible
		gameFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		gameFrame.setResizable(false);
		gameFrame.setVisible( true );
		
		mainMenuPanel menuPanel = new mainMenuPanel(gameFrame);

		
	}

}
