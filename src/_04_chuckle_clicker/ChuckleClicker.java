package _04_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	public static void main(String[] args) {
		new ChuckleClicker().makeButtons();
	}
	JButton joke;
	JButton punchline;
	 void makeButtons() {
		 JFrame frame = new JFrame();
			frame.setVisible(true);
			JPanel panel = new JPanel();
			frame.add(panel);
			joke = new JButton("Joke");
			punchline = new JButton("Punchline");
			panel.add(joke);
			panel.add(punchline);
			frame.pack();
		
		joke.addActionListener(this);
		punchline.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == joke) {
			
			JOptionPane.showMessageDialog(null, "What do you get if you put an elephant in a fridge?");
		} else {
			JOptionPane.showMessageDialog(null, "Seven years in fedral prison");
		}
		
	}
}
