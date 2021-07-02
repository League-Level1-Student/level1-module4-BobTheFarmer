package _12_slot_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Slots implements ActionListener {
	Random rando;
	
	int image1;
	int image2;
	int image3;
	void run() {
		//Make UI+Classes
			JPanel panel = new JPanel();
			JFrame frame = new JFrame();
			frame.setVisible(true);
			rando = new Random();
			JButton spin = new JButton("Spin");
			spin.addActionListener(this);
			
	}
	
	
	
	
	
	
	
	
	private Icon createLabelIcon(String fileName) {
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return null;
	}
	Icon icon = new ImageIcon(imageURL);
	return icon;
}








	@Override
	public void actionPerformed(ActionEvent e) {
		//Change varibles
		
		
	}
	
	void UpdateImages() {
		
		
	}
}
