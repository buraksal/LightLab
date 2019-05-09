import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class mainMenuPanel extends JPanel{
	
	JFrame gameFrame;
	JFrame currentFrame;
	
	JLabel title;
	JLabel mainFrameImage;
	JLabel bgImage;
	
	JButton playGame;
	JButton credits;
	JButton exit;
	
	Image backGroundImage;
	
	mainMenuButtonListener buttonListener;
	
	final int HEIGHT = 1080;
	final int WIDTH = 1920;
	final int BUTTON_WIDTH = 300;
	final int BUTTON_HEIGHT = 75;
	final int DISTANCE_BETWEEN_BUTTONS = 125;
	final int FONT_SIZE = 65;
	
	public mainMenuPanel(JFrame currentFrame) {
		currentFrame.setContentPane(this);
		initialize(currentFrame);
		
	}
	
	//Default Constructor
	public mainMenuPanel() {
		
	}
	private void initialize(JFrame currentFrame) {
		this.setLayout(null);
		buttonListener = new mainMenuButtonListener();
		currentFrame.getContentPane().setBounds(0,0,WIDTH,HEIGHT);
		currentFrame.getContentPane().setBackground(Color.CYAN);
		
		title = new JLabel("LightLab");
		title.setFont(new Font("Delta Ray", Font.PLAIN, FONT_SIZE));
		title.setBounds(WIDTH / 2 - BUTTON_WIDTH / 2, 0, 300, 200);
		this.add(title);

		mainFrameImage = new JLabel(new ImageIcon(getClass().getResource("/images/250-250-logo.png")));
		mainFrameImage.setBounds((WIDTH-BUTTON_WIDTH) / 2 - 105 , BUTTON_HEIGHT , 2 * BUTTON_WIDTH - 100, 2 * BUTTON_WIDTH - 100);
		this.add(mainFrameImage);
		
		playGame = new JButton("Play Game");
		playGame.setBounds((WIDTH-BUTTON_WIDTH) / 2,(HEIGHT-BUTTON_HEIGHT) / 2, BUTTON_WIDTH, BUTTON_HEIGHT);
		playGame.addActionListener(buttonListener);
		playGame.setBackground(Color.RED);
		this.add(playGame);
		
		credits = new JButton("Credits");
		credits.setBounds((WIDTH-BUTTON_WIDTH) / 2, (HEIGHT-BUTTON_HEIGHT) / 2 + DISTANCE_BETWEEN_BUTTONS, BUTTON_WIDTH, BUTTON_HEIGHT);
		credits.addActionListener(buttonListener);
		credits.setBackground(Color.RED);
		this.add(credits);
		
		exit = new JButton("Exit");
		exit.setBounds((WIDTH-BUTTON_WIDTH) / 2,(HEIGHT-BUTTON_HEIGHT) / 2 + DISTANCE_BETWEEN_BUTTONS * 2, BUTTON_WIDTH, BUTTON_HEIGHT);
		exit.addActionListener(buttonListener);
		exit.setBackground(Color.RED);
		this.add(exit);

		bgImage = new JLabel(new ImageIcon(getClass().getResource("/images/background.jpg")));	
		bgImage.setBounds(0, 0, WIDTH, HEIGHT);
		this.add(bgImage);
		
		repaint();

	}
	
	class mainMenuButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Component component = (Component) e.getSource();
			currentFrame = (JFrame) SwingUtilities.getRoot(component);
			if (e.getSource() == playGame){
				new playGamePanel(currentFrame);
			} else if(e.getSource() == credits) {
				new creditsPanel(currentFrame);
			} else if(e.getSource() == exit)
				currentFrame.dispose();
		}
		
	}
	

}
