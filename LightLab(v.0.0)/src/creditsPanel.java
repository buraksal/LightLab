import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class creditsPanel extends JPanel{
	
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
	
	JFrame currentFrame;
	
	JLabel team;
	JLabel kaan_Name;
	JLabel melih_Name;
	JLabel arnisa_Name;
	JLabel aleyna_Name;
	JLabel burak_Name;
	JLabel berk_Name;
	JLabel mehmet_Name;
	
	JButton backButton;
	
	
	public creditsPanel(JFrame currentFrame) {
		currentFrame.setContentPane(this);
		initialize(currentFrame);
	}

	private void initialize(JFrame currentFrame) {
		this.removeAll();
		this.setBounds(0, 0, WIDTH, HEIGHT);
		currentFrame.getContentPane().setBackground(Color.GRAY);
		
		backButton = new JButton(" < Back");
		backButton.setBounds(WIDTH - 150, 50, 100, 50);
		backButton.setBackground(Color.WHITE);
		backButton.addActionListener(new backButtonListener());
		this.add(backButton);
		
		team = new JLabel("Team");
		team.setFont(new Font("Delta Ray", Font.PLAIN, FONT_SIZE));
		team.setBounds(860, 150, 200, 200);
		this.add(team);
		
		kaan_Name = new JLabel();
		melih_Name = new JLabel();
		arnisa_Name = new JLabel();
		aleyna_Name = new JLabel();
		burak_Name = new JLabel();
		berk_Name = new JLabel();
		mehmet_Name = new JLabel();
		
		kaan_Name.setText("Kaan Atakan ARAY");
		melih_Name.setText("Ramazan Melih DIKSU");
		arnisa_Name.setText("Arnisa FAZLA");
		aleyna_Name.setText("Aleyna SUTBAS");
		burak_Name.setText("Burak SAL");
		berk_Name.setText("Berk TAKIT");
		mehmet_Name.setText("Mehmet YAYLACI");
		
		kaan_Name.setFont(new Font("Delta Ray", Font.PLAIN, FONT_SIZE - 8 * SIZE_ADJUSTMENT_RATE));
		melih_Name.setFont(new Font("Delta Ray", Font.PLAIN, FONT_SIZE - 8 * SIZE_ADJUSTMENT_RATE));
		arnisa_Name.setFont(new Font("Delta Ray", Font.PLAIN, FONT_SIZE - 8 * SIZE_ADJUSTMENT_RATE));
		aleyna_Name.setFont(new Font("Delta Ray", Font.PLAIN, FONT_SIZE - 8 * SIZE_ADJUSTMENT_RATE));
		burak_Name.setFont(new Font("Delta Ray", Font.PLAIN, FONT_SIZE - 8 * SIZE_ADJUSTMENT_RATE));
		berk_Name.setFont(new Font("Delta Ray", Font.PLAIN, FONT_SIZE - 8 * SIZE_ADJUSTMENT_RATE));
		mehmet_Name.setFont(new Font("Delta Ray", Font.PLAIN, FONT_SIZE - 8 * SIZE_ADJUSTMENT_RATE));
		
		kaan_Name.setBounds(WIDTH / 2 - 140, 300, 350, 80);
		melih_Name.setBounds(WIDTH / 2  - 150, 380, 350, 80);
		arnisa_Name.setBounds(WIDTH / 2  - 100, 460, 350, 80);
		aleyna_Name.setBounds(WIDTH / 2  - 105, 540, 350, 80);
		burak_Name.setBounds(WIDTH / 2  - 90, 620, 350, 80);
		berk_Name.setBounds(WIDTH / 2  - 100, 700, 350, 80);
		mehmet_Name.setBounds(WIDTH / 2  - 115, 780, 350, 80);
		
		this.add(kaan_Name);
		this.add(melih_Name);
		this.add(arnisa_Name);
		this.add(aleyna_Name);
		this.add(burak_Name);
		this.add(berk_Name);
		this.add(mehmet_Name);
		
		repaint();

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
