import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LightsOut implements ActionListener{
	JPanel panel;
	void start() {
		System.out.println("Ran");
		//Make UI
			JFrame frame = new JFrame("Lights Out");
			panel = new JPanel();
			frame.setVisible(true);
			frame.add(panel);
			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		//Create Buttons
			for(int buttonNum = 0; buttonNum<25; buttonNum++) {
				//Create button in panel
					JButton button = new JButton(String.valueOf(buttonNum));
					panel.add(button);
					button.addActionListener(this);
					button.setOpaque(true);
					button.setBackground(Color.BLACK);
					button.setSize(250, 250);
			}
			
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
			JButton clicked = (JButton)e.getSource();
			int buttonPressed = Integer.parseInt(clicked.getText());
			toggle((JButton)panel.getComponent(buttonPressed));
			toggle((JButton)panel.getComponent(buttonPressed-5));
			if(buttonPressed+1%5==0) {
				toggle((JButton)panel.getComponent(buttonPressed+1));
			}
			toggle((JButton)panel.getComponent(buttonPressed-1));
			toggle((JButton)panel.getComponent(buttonPressed+5));
			

		
		
		
	}
	
	void toggle(JButton button) {
		if(button.getBackground() == Color.BLACK) {
			button.setBackground(Color.BLUE);
		} else {
			button.setBackground(Color.BLACK);
		}
	}
	
}
