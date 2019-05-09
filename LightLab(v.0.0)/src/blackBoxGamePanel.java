import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class blackBoxGamePanel extends JPanel{
	
	JFrame currentFrame;
	
	JButton answerA;
	JButton answerB;
	JButton answerC;
	JButton answerD;
	
	JButton backButton;
	JButton hintImage;
	
	JLabel blackBoxImage;
	
	JLabel menuTitle;
	
	JLabel answerALabel;
	JLabel answerBLabel;
	JLabel answerCLabel;
	JLabel answerDLabel;
	JLabel movesRemaining;
	JLabel hintMessage;
	
	JLabel lightSourceImage;
	
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
	
	int moves;
	
	public blackBoxGamePanel (JFrame currentFrame) {
		currentFrame.setContentPane(this);
		initialize(currentFrame);	
	}

	private void initialize(JFrame currentFrame) {
		this.removeAll();
		this.setBounds(0, 0, WIDTH, HEIGHT);
		this.setLayout(null);
		currentFrame.getContentPane().setBackground(Color.YELLOW);
		
		//Adding the frame info on top for user
		menuTitle = new JLabel ("Black Box Game");
		menuTitle.setFont(new Font("Delta Ray", Font.PLAIN, FONT_SIZE / SIZE_ADJUSTMENT_RATE));
		menuTitle.setBounds(DISTANCE_BETWEEN_BUTTONS/ SIZE_ADJUSTMENT_RATE, DISTANCE_BETWEEN_BUTTONS/ SIZE_ADJUSTMENT_RATE - 50, 
				FONT_SIZE * FONT_SIZE_ADJUSTMENT, FONT_SIZE* FONT_SIZE_ADJUSTMENT);		
		this.add(menuTitle);
		
		backButton = new JButton(" < Back");
		backButton.setBounds(WIDTH - 150, 50, 100, 50);
		backButton.setBackground(Color.WHITE);
		backButton.addActionListener(new backButtonListener());
		this.add(backButton);
		
		moves = 3;
		movesRemaining = new JLabel("You have "+moves+" remaining moves!");
		movesRemaining.setBounds(875, 550, 300, 100);
		this.add(movesRemaining);
		
		lightSourceImage = new JLabel(new ImageIcon(getClass().getResource("/images/lightSourceImage.png")));
		lightSourceImage.setBounds(211, 236, 128, 128);
		this.add(lightSourceImage);
		
		blackBoxImage = new JLabel(new ImageIcon(getClass().getResource("/images/blackBoxImage.jpg")));
		blackBoxImage.setBounds(810, 100, 300, 400);
		this.add(blackBoxImage);
		
		answerA = new JButton();
		answerA.setBounds(200, 700, 150, 200);
		this.add(answerA);
		
		answerALabel = new JLabel("A");
		answerALabel.setBounds(270, 650, 25, 25);
		this.add(answerALabel);
		
		answerB = new JButton();
		answerB.setBounds(650, 700, 150, 200);
		this.add(answerB);
		
		answerBLabel = new JLabel("B");
		answerBLabel.setBounds(720, 650, 25, 25);
		this.add(answerBLabel);
		
		answerC = new JButton();
		answerC.setBounds(1100, 700, 150, 200);
		this.add(answerC);
		
		answerCLabel = new JLabel("C");
		answerCLabel.setBounds(1170, 650, 25, 25);
		this.add(answerCLabel);
		
		answerD = new JButton();
		answerD.setBounds(1550, 700, 150, 200);
		this.add(answerD);
		
		answerDLabel = new JLabel("D");
		answerDLabel.setBounds(1620, 650, 25, 25);
		this.add(answerDLabel);
		
		hintImage = new JButton(new ImageIcon(getClass().getResource("/images/hint.png")));
		hintImage.setBounds(10, 1000, 32, 32);
		hintImage.setOpaque(false);
		hintImage.setContentAreaFilled(false);
		hintImage.setBorderPainted(false);
		hintImage.addMouseListener(new hintButtonListener());
		this.add(hintImage);
		
		hintMessage = new JLabel("There can be anything in the Box xD");
		hintMessage.setBounds(50, 980, 200, 20);
		
		this.addMouseListener(new panelMouseAdapter());
		repaint();
	}
	
	class panelMouseAdapter extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			Ellipse2D.Double ellips = new Ellipse2D.Double(275, 50, 1350, 500);
			if (moves > 0) {
				Point p = calculatePoint(MouseInfo.getPointerInfo().getLocation(), ellips);
				lightSourceImage.setLocation(p);
				moves--;
				movesRemaining.setText("You have "+moves+" remaining moves!");
			} else {
				movesRemaining.setLocation(900, 550);
				movesRemaining.setText("Try Using Hint!");
			}
				
		}

		private Point calculatePoint(Point location, Ellipse2D.Double ellips) {
			Point2D.Double point = new Point2D.Double();
			point.x = location.getX();
			point.y = location.getY();

			//Quarter 1 , 2
			if ((location.getX() < 1625 && location.getX() > 275) && location.getY() > 300) {
				
				while (!ellips.contains(point)) {
					point.y--;
				}
				location.x = (int) point.x - 60;
				location.y = (int) point.y - 50;
				
			} //Quarter 3, 4
			else if ((location.getX() < 1625 && location.getX() > 275) && location.getY() <= 300) {
				
				while (!ellips.contains(point)) {
					point.y++;	
				}
				location.x = (int) point.x - 60;
				location.y = (int) point.y - 75;
			} //Outside of Ellipse Borders Left
			else if (location.getX() < 275 && (location.getY() > 50 && location.getY() < 550)) {

				while (!ellips.contains(point)) {
					point.x = point.x + 1;
					location.x = (int) point.x;
					location.y = (int) point.y;
				}
				location.x = location.x - 60;
				location.y = location.y - 75;
			} //Outside of Ellipse Borders Right
			else if (location.getX() > 1625 && (location.getY() > 50 && location.getY() < 550) ) {

				while (!ellips.contains(point)) {
					point.x--;	
				}
				location.x = (int) point.x - 60;
				location.y = (int) point.y - 75;
			} //Bottom Left Absurdness
			else if (location.getX() < 275 && location.getY() > 550) {
				
				while (!ellips.contains(point)) {
					point.x++;
					point.y--;
				}
				location.x = (int) point.x - 60;
				location.y = (int) point.y - 75;
			} //Top Left Absurdness
			else if (location.getX() < 275 && location.getY() < 50) {
				
				while (!ellips.contains(point)) {
					point.x++;
					point.y++;
				}
				location.x = (int) point.x - 60;
				location.y = (int) point.y - 75;
			} // Top Right Absurdness
			else if (location.getX() > 1625 && location.getY() < 50) {
				
				while (!ellips.contains(point)) {
					point.x--;
					point.y++;
				}
				location.x = (int) point.x - 60;
				location.y = (int) point.y - 75;
			} //Bottom Right Absurdness
			else if (location.getX() > 1625 && location.getY() > 550) {
				
				while (!ellips.contains(point)) {
					point.x--;
					point.y--;
				}
				location.x = (int) point.x - 60;
				location.y = (int) point.y - 75;
			}

			return location;
	
		}

	}
	
	class backButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Component component = (Component) e.getSource();
			currentFrame = (JFrame) SwingUtilities.getRoot(component);
			if (e.getSource() == backButton){
				new playGamePanel(currentFrame);
			}
		}
		
	}
	
	class hintButtonListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			Component component = (Component) e.getSource();
	        JFrame frame = (JFrame) SwingUtilities.getRoot(component);
	        frame.add(hintMessage);
	        repaint();
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			Component component = (Component) e.getSource();
	        JFrame frame = (JFrame) SwingUtilities.getRoot(component);
			frame.remove(hintMessage);
			repaint();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(275, 50, 1350, 500);
		g.drawRect(175, 625, 200, 300);
		g.drawRect(625, 625, 200, 300);
		g.drawRect(1075, 625, 200, 300);
		g.drawRect(1525, 625, 200, 300);
	}
}
