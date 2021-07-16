package _12_slot_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Slots implements ActionListener {
	Random rando;
	Icon icon;
	JLabel label1 = new JLabel(); 
	JLabel label2 = new JLabel(); 
	JLabel label3 = new JLabel(); 
	String image1;
	String image2;
	String image3;
	void run() {
		//Make UI+Classes
			JPanel panel = new JPanel();
			JFrame frame = new JFrame();
			frame.add(panel);
			frame.setVisible(true);
			frame.setSize(700, 300);
			rando = new Random();
			JButton spin = new JButton("Spin");
			spin.addActionListener(this);
			panel.add(label1);
			panel.add(label2);
			panel.add(label3);
			panel.add(spin);
			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			
			//Run
				spin();
	}
	
	
	
	
	
	
	
	
	private Icon createLabelIcon(String fileName) {
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return null;
	}
	icon = new ImageIcon(imageURL);
	return icon;
}








	@Override
	public void actionPerformed(ActionEvent e) {
		spin();
	}
	
	void spin() {
		//Change varibles
			image1 = rando.nextInt(3) + ".jpg";
			image2 = rando.nextInt(3) + ".jpg";
			image3 = rando.nextInt(3) + ".jpg";
			
		//Set Icons
			
			icon = createLabelIcon(image1);
			label1.setIcon(icon);
			icon = createLabelIcon(image2);
			label2.setIcon(icon);
			icon = createLabelIcon(image3);
			label3.setIcon(icon);
			
		//Check if won
			if(image1.equals(image2) && image1.equals(image3)) {
				JOptionPane.showMessageDialog(null, "You Won! Take nothing as a reward");
			}
	}
}
