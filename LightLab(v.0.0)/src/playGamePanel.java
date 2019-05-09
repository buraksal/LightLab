
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import blackBoxGame.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class playGamePanel extends JPanel{
	
	JFrame currentFrame;
	
	JLabel menuTitle;
	JLabel blackBoxLabel;
	JLabel opticSteeringLabel;
	JLabel beamBallLabel;
	JLabel levelEditorLabel;
	
	JLabel blackBoxImage;
	JLabel opticSteeringImage;
	JLabel beamBallImage;
	JLabel levelEditorImage;
	
	JButton blackBoxButton;
	JButton opticSteeringButton;
	JButton beamBallButton;
	JButton levelEditorButton;
	JButton singlePlayerButton;
	JButton multiPlayerButton;
	JButton backButton;


	final int HEIGHT = 1080;
	final int WIDTH = 1920;
	final int BUTTON_WIDTH = 300;
	final int BUTTON_HEIGHT = 75;
	final int DISTANCE_BETWEEN_BUTTONS = 125;
	final int FONT_SIZE = 65;
	final int SIZE_ADJUSTMENT_RATE = 5;
	final int FONT_SIZE_ADJUSTMENT = 2;
	
	final int BLACK_BOX_Y = 150;
	final int BLACK_BOX_X = 600;
	
	public playGamePanel(JFrame currentFrame) {
		currentFrame.setContentPane(this);
		initialize(currentFrame);

	}

	private void initialize(JFrame currentFrame) {
		this.removeAll();
		this.setBounds(0, 0, WIDTH, HEIGHT);
		currentFrame.getContentPane().setBackground(Color.MAGENTA);
		
		//Adding Black Box option and labels
		blackBoxLabel = new JLabel("Try to guess what's inside?");
		blackBoxLabel.setFont(new Font("Delta Ray", Font.PLAIN, FONT_SIZE / SIZE_ADJUSTMENT_RATE));
		blackBoxLabel.setBounds(WIDTH - BLACK_BOX_X, BLACK_BOX_Y, FONT_SIZE * SIZE_ADJUSTMENT_RATE, FONT_SIZE * SIZE_ADJUSTMENT_RATE);

		this.add(blackBoxLabel);
		
		blackBoxButton = new JButton("Black Box");
		blackBoxButton.setBounds( BLACK_BOX_X - BLACK_BOX_Y, BLACK_BOX_Y + (BLACK_BOX_Y + BUTTON_HEIGHT) / 2, BUTTON_WIDTH, BUTTON_HEIGHT);
		blackBoxButton.setBackground(Color.GRAY);
		blackBoxButton.addActionListener(new playGameButtonListener());

		this.add(blackBoxButton);
		
		blackBoxImage = new JLabel(new ImageIcon(getClass().getResource("/images/Left Arrow.png")));
		blackBoxImage.setBounds(BLACK_BOX_X + 2 * BLACK_BOX_Y,BLACK_BOX_Y,BUTTON_WIDTH,BUTTON_WIDTH);

		this.add(blackBoxImage);
		
		//Adding Optic Steering option and labels
		opticSteeringLabel = new JLabel("Direct the light to the target!");
		opticSteeringLabel.setFont(new Font("Delta Ray", Font.PLAIN, FONT_SIZE / SIZE_ADJUSTMENT_RATE));
		opticSteeringLabel.setBounds(BLACK_BOX_X - BLACK_BOX_Y, 2 * BLACK_BOX_Y, FONT_SIZE * SIZE_ADJUSTMENT_RATE, FONT_SIZE * SIZE_ADJUSTMENT_RATE);

		this.add(opticSteeringLabel);
		
		opticSteeringImage = new JLabel(new ImageIcon(getClass().getResource("/images/Right Arrow.png")));
		opticSteeringImage.setBounds(BLACK_BOX_X + 2 * BLACK_BOX_Y,2 * BLACK_BOX_Y, BUTTON_WIDTH, BUTTON_WIDTH);

		this.add(opticSteeringImage);
		
		opticSteeringButton = new JButton("Optic Steering");
		opticSteeringButton.setBounds(WIDTH - BLACK_BOX_X, 3 * BLACK_BOX_Y - 50, BUTTON_WIDTH, BUTTON_HEIGHT);
		opticSteeringButton.setBackground(Color.PINK);
		opticSteeringButton.addMouseListener(new dropDownListener());
		opticSteeringButton.addActionListener(new playGameButtonListener());

		this.add(opticSteeringButton);
		
		//Adding BeamBall option and labels
		beamBallLabel = new JLabel("Football with Lights!");
		beamBallLabel.setFont(new Font("Delta Ray", Font.PLAIN, FONT_SIZE / SIZE_ADJUSTMENT_RATE));
		beamBallLabel.setBounds(WIDTH - BLACK_BOX_X, 3 * BLACK_BOX_Y, FONT_SIZE * SIZE_ADJUSTMENT_RATE, FONT_SIZE * SIZE_ADJUSTMENT_RATE);
		this.add(beamBallLabel);
		
		beamBallImage = new JLabel(new ImageIcon(getClass().getResource("/images/Left Arrow.png")));
		beamBallImage.setBounds(BLACK_BOX_X + 2 * BLACK_BOX_Y, 3 * BLACK_BOX_Y, BUTTON_WIDTH, BUTTON_WIDTH);
		this.add(beamBallImage);
		
		beamBallButton = new JButton("BeamBall");
		beamBallButton.setBounds(BLACK_BOX_X - BLACK_BOX_Y, 4 * BLACK_BOX_Y - 50, BUTTON_WIDTH, BUTTON_HEIGHT);
		beamBallButton.setBackground(Color.GRAY);
		beamBallButton.addActionListener(new playGameButtonListener());

		this.add(beamBallButton);
		
		//Adding Level Editor option and labels
		levelEditorLabel = new JLabel("Create your own experiment!");
		levelEditorLabel.setFont(new Font("Delta Ray", Font.PLAIN, FONT_SIZE / SIZE_ADJUSTMENT_RATE));
		levelEditorLabel.setBounds(BLACK_BOX_X - BLACK_BOX_Y, 4 * BLACK_BOX_Y, FONT_SIZE * SIZE_ADJUSTMENT_RATE, FONT_SIZE * SIZE_ADJUSTMENT_RATE);
		this.add(levelEditorLabel);
		
		levelEditorImage = new JLabel(new ImageIcon(getClass().getResource("/images/Right Arrow.png")));
		levelEditorImage.setBounds(BLACK_BOX_X + 2 * BLACK_BOX_Y,4 * BLACK_BOX_Y, BUTTON_WIDTH, BUTTON_WIDTH );
		this.add(levelEditorImage);
		
		levelEditorButton = new JButton("Level Editor");
		levelEditorButton.setBounds(WIDTH - BLACK_BOX_X, 5 * BLACK_BOX_Y - 50, BUTTON_WIDTH, BUTTON_HEIGHT);
		levelEditorButton.setBackground(Color.CYAN);
		levelEditorButton.addActionListener(new playGameButtonListener());
		this.add(levelEditorButton);
		
		//Adding the frame info on top for user
		menuTitle = new JLabel ("Play Game");
		menuTitle.setFont(new Font("Delta Ray", Font.PLAIN, FONT_SIZE / SIZE_ADJUSTMENT_RATE));
		menuTitle.setBounds(DISTANCE_BETWEEN_BUTTONS/ SIZE_ADJUSTMENT_RATE, DISTANCE_BETWEEN_BUTTONS/ SIZE_ADJUSTMENT_RATE - 50, 
				FONT_SIZE * FONT_SIZE_ADJUSTMENT, FONT_SIZE* FONT_SIZE_ADJUSTMENT);		
		this.add(menuTitle);
		
		backButton = new JButton(" < Back");
		backButton.setBounds(WIDTH - 150, 50, 100, 50);
		backButton.setBackground(Color.WHITE);
		backButton.addActionListener(new backButtonListener());
		this.add(backButton);
		
		
		singlePlayerButton = new JButton("Single Player");
		singlePlayerButton.setBounds(opticSteeringButton.getX(), opticSteeringButton.getY() + BUTTON_HEIGHT, BUTTON_WIDTH / 2, BUTTON_HEIGHT);
		singlePlayerButton.setBackground(Color.ORANGE);
		singlePlayerButton.addMouseListener(new dropDownListener());
		
		multiPlayerButton = new JButton("MultiPlayer");
		multiPlayerButton.setBounds(opticSteeringButton.getX() + BUTTON_WIDTH / 2, opticSteeringButton.getY() + BUTTON_HEIGHT, BUTTON_WIDTH / 2, BUTTON_HEIGHT);
		multiPlayerButton.setBackground(Color.ORANGE);
		multiPlayerButton.addMouseListener(new dropDownListener());
	}
	
	
	class dropDownListener extends MouseAdapter {
		
		
		@Override
		public void mouseEntered(MouseEvent e) {
			
			Component component = (Component) e.getSource();
	        JFrame frame = (JFrame) SwingUtilities.getRoot(component);
	        frame.add(singlePlayerButton);        
			frame.add(multiPlayerButton);
	        repaint();
		}
		@Override
		public void mouseExited(MouseEvent e) {
			Component component = (Component) e.getSource();
	        JFrame frame = (JFrame) SwingUtilities.getRoot(component);
	        if ((MouseInfo.getPointerInfo().getLocation().getX() < 1330 ||
					MouseInfo.getPointerInfo().getLocation().getX() > 1620) ||
					(MouseInfo.getPointerInfo().getLocation().getY() > 575 ||
					MouseInfo.getPointerInfo().getLocation().getY() < 435)) {
				frame.remove(multiPlayerButton);
				frame.remove(singlePlayerButton);
				repaint();
			} 
		}

	}
   
	class playGameButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Component component = (Component) e.getSource();
			currentFrame = (JFrame) SwingUtilities.getRoot(component);
			if (e.getSource() == blackBoxButton){
				new blackBoxGamePanel(currentFrame);
			}
			
		}
		
	}
	
	class backButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Component component = (Component) e.getSource();
			currentFrame = (JFrame) SwingUtilities.getRoot(component);
			if (e.getSource() == backButton){
				new mainMenuPanel(currentFrame);
			}
		}
		
	}

}

