import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Interface implements ActionListener {

	// For Holding the status of each button
	
	public static boolean isNBA = false;
	public static boolean isWNBA = false;
	public static boolean isNCAAM = false;
	public static boolean isNCAAW = false;
	public static boolean isINT = false;
	
	public static double totalPoints = 0;
	public static double minutesLeft = 0;
	public static double predictedFinal = 0;
	public static double periodMinsLeft = 0;
	public static double currentPeriod = 0;
	public static double PPM = 0;
	
	public static void main(String[] args){

		JFrame frame = new JFrame("BetBuddy");
		Container pane  = frame.getContentPane();
		pane.setLayout(new GridLayout(15,0));
		
		// Defining the different buttons 
		
		JTextField totalHome = new JTextField ("", SwingConstants.CENTER);
		JLabel totalHomeLabel = new JLabel("Home Current Points:", SwingConstants.CENTER);

		JTextField totalAway = new JTextField ("", SwingConstants.CENTER);
		JLabel totalAwayLabel = new JLabel("Away Current Points:", SwingConstants.CENTER);
		
		JTextField periodField = new JTextField ("", SwingConstants.CENTER);
		JLabel periodFieldLabel = new JLabel("Current Period:", SwingConstants.CENTER);

		JTextField minsLeftField = new JTextField ("", SwingConstants.CENTER);
		JLabel minsLeftFieldLabel = new JLabel("Time Left in Period (M):", SwingConstants.CENTER);
		
		JButton b1 = new JButton("NBA");
		JButton b2 = new JButton("WNBA");
		JButton b3 = new JButton("NCAA Men's");
		JButton b4 = new JButton("NCAA Women's");
		JButton b5 = new JButton("International (FIBA)");
		JButton submitButton = new JButton("SUBMIT");
		
		JLabel PPMLabel = new JLabel("", SwingConstants.CENTER);
		PPMLabel.setForeground(Color.white);
		PPMLabel.setBackground(Color.BLUE);
		PPMLabel.setOpaque(true);
		
		b1.setFont(new Font("Serif", Font.PLAIN, 14));
		b2.setFont(new Font("Serif", Font.PLAIN, 14));
		b3.setFont(new Font("Serif", Font.PLAIN, 14));
		b4.setFont(new Font("Serif", Font.PLAIN, 14));
		b5.setFont(new Font("Serif", Font.PLAIN, 14));
		
		submitButton.setFont(new Font("Impact", Font.PLAIN, 14));
		
		
		// ------------------ ACTIONLISTENERS -------------------
		
		b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b1.setBackground(Color.GREEN);
                b1.setOpaque(true);
                b1.setBorderPainted(false);
        		b1.setFont(new Font("Impact", Font.PLAIN, 14));
                isNBA = true;
            }
        });
		
		b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b2.setBackground(Color.GREEN);
                b2.setOpaque(true);
                b2.setBorderPainted(false);
        		b2.setFont(new Font("Impact", Font.PLAIN, 14));
                isWNBA = true;
            }
        });
		
		b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b3.setBackground(Color.GREEN);
                b3.setOpaque(true);
                b3.setBorderPainted(false);
        		b3.setFont(new Font("Impact", Font.PLAIN, 14));
                isNCAAM = true;
            }
        });
		
		b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b4.setBackground(Color.GREEN);
                b4.setOpaque(true);
                b4.setBorderPainted(false);
        		b4.setFont(new Font("Impact", Font.PLAIN, 14));
                isNCAAW = true;
            }
        });
		
		b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b5.setBackground(Color.GREEN);
                b5.setOpaque(true);
                b5.setBorderPainted(false);
        		b5.setFont(new Font("Impact", Font.PLAIN, 14));
                isINT = true;
            }
        });
		
		// Submits, determines the outcome based on all field values and selections
		
		submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            		submitButton.setForeground(Color.white);
            		submitButton.setBackground(Color.BLUE);
            		submitButton.setOpaque(true);
            		submitButton.setBorderPainted(false);
            		
            		// TextField Values to Doubles so they can be used for math
            		
            		totalPoints = Double.parseDouble(totalHome.getText())
            				+ Double.parseDouble(totalAway.getText());

            		currentPeriod = Double.parseDouble(periodField.getText());
            		
            		periodMinsLeft = Double.parseDouble(minsLeftField.getText());
            		
            		/* Determines what kind of game it is, sets minutesLeft accordingly,
            		 * then calculates how many minutes have already passed, based on Periods
            		 */
            		
            		currentPeriod--;
            		
            		if (isNBA == true) {PPM = (totalPoints / ((currentPeriod * 12) + (12 - periodMinsLeft)));
            		predictedFinal = (48 * PPM);}

            		else if (isWNBA == true) {PPM = (totalPoints / ((currentPeriod * 10) + (10 - periodMinsLeft)));
            		predictedFinal = (40 * PPM);}
            		           		
            		else if (isNCAAM == true) {PPM = (totalPoints / ((currentPeriod * 20) + (20 - periodMinsLeft)));
            		predictedFinal = (40 * PPM);}
            		
            		else if (isNCAAW == true) {PPM = (totalPoints / ((currentPeriod  * 10) + (10 - periodMinsLeft)));
            		predictedFinal = (40 * PPM);}
            		           		
            		else {PPM = (totalPoints / ((currentPeriod * 10) - (10 - periodMinsLeft)));
            		predictedFinal = (40 * PPM);}
            		
            		pane.add(PPMLabel);
            		
            		submitButton.setText("Final Score: " + predictedFinal);
            		PPMLabel.setText("PPM: " + PPM);
            		
            }
        });

		// ------------------------------------------------------
		
		pane.add(totalHomeLabel);
		pane.add(totalHome);
		
		pane.add(totalAwayLabel);
		pane.add(totalAway);
		
		pane.add(periodFieldLabel);
		pane.add(periodField);
		
		pane.add(minsLeftFieldLabel);
		pane.add(minsLeftField);
		
		pane.add(b1);
		pane.add(b2);
		pane.add(b3);
		pane.add(b4);
		pane.add(b5);
		pane.add(submitButton);
		
		b1.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				// Nothing, just had to implement 
			 }
	    });
		
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		// Close on Exit
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/* 
		 * Since every ActionEvent is handled independently, 
		 * I don't need to use this, only define it. 
		 */
	}
}
