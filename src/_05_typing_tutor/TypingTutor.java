package _05_typing_tutor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	char currentLetter;

	void setup(){
		currentLetter = generateRandomLetter();
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		frame.addKeyListener(this);
		panel.add(label);
		
		label.setText(String.valueOf(currentLetter));
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		
		frame.pack();
	}
	
	char generateRandomLetter() {
	    Random r = new Random();
	    return (char) (r.nextInt(26) + 'a');
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//Useless
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("You Typed: " + e.getKeyChar());
		if(e.getKeyChar() == currentLetter) {
			System.out.println("Correct!");
			panel.setBackground(Color.green);
		} else {
			System.out.println("Incorrect :(");
			panel.setBackground(Color.red);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		currentLetter = generateRandomLetter();
		label.setText(String.valueOf(currentLetter));
	}
}
