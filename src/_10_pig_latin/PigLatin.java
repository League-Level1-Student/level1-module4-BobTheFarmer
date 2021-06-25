package _10_pig_latin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PigLatin implements ActionListener {
	//Add Translator/other stuff
		PigLatinTranslator pigLatinTranslator = new PigLatinTranslator();
		JTextField english = new JTextField(20);
		JTextField piglatin = new JTextField(20);
	void run() {
		//Make UI
			JFrame frame = new JFrame();
			JPanel panel = new JPanel();
			frame.setVisible(true);
			JButton translate = new JButton("Translate");
			frame.add(panel);
			panel.add(english);
			panel.add(translate);
			panel.add(piglatin);
			frame.pack();
			
		//Add Action Listener
			translate.addActionListener(this);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String piglatinOutput = "If you see this very bad";
		
		//Test if letters
			boolean letters = true;
			for(int i = 0; i<english.getText().length(); i++) {
				letters = PigLatinTranslator.isLetter(english.getText().charAt(i));
				if(letters == false) {
					break;
				}
			}
			
		//Take if letters and translate if they are otherwise error
			if(letters == false) { 
				piglatinOutput = "ERROR: Non-letter in text";
			} else {
				piglatinOutput = pigLatinTranslator.translate(english.getText());
			}
		//Set piglatin box to output
			piglatin.setText(piglatinOutput);
	}
}
