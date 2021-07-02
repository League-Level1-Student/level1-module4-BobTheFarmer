package _11_whack_a_mole;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
	JPanel panel;
	JButton moleButton;
	Date start;
	Random rando;
	int timesMoled = 0;
	JFrame frame;
	void run() {
		//Start Game Thing
			start = new Date();
			
		//Make UI + Classes
			
			
			rando = new Random();
			
			//Make Starter Buttons
				drawButtons(rando.nextInt(24));
				
	}
	
	void drawButtons(int random) {
		panel = new JPanel();
		frame = new JFrame();
		frame.setVisible(true);
		frame.add(panel);
		frame.setSize(300, 325);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		System.out.println("Random: " + random);
		for(int buttonNum = 0; buttonNum<24; buttonNum++) {
			System.out.println(buttonNum);
			//Make button + check if mole
				if(buttonNum == random) {
					moleButton = new JButton("Mole!");
					panel.add(moleButton);
					moleButton.addActionListener(this);
					
				} else {
					JButton button = new JButton();
					panel.add(button);
					button.addActionListener(this);
					
				}	
		} 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Check if mole hit and update stuff
			if(e.getSource() == moleButton) {
				speak("You hit the mole!");
				timesMoled++;
				
				//Reset
					frame.dispose();
					drawButtons(rando.nextInt(24));
				//Play Sound
				//playSound("/Level1-Module4/src/_11_whack_a_mole/536104__eminyildirim__sword-hit-heavy.wav");
				//Check if the game is over
					if(timesMoled>=5) {
						endGame(start, 5);
					}
				
				
			
			} else {
				speak("You missed the mole!");
			}
			
		
		
	}

	
	
	static void speak(String words) {
        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
                    + words + "');\"";
            try {
                Runtime.getRuntime().exec( cmd ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        } else {
            try {
                Runtime.getRuntime().exec( "say " + words ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
    }
    
    
    private void endGame(Date timeAtStart, int molesWhacked) { 
        Date timeAtEnd = new Date();
        JOptionPane.showMessageDialog(null, "Your whack rate is "
                + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
                      + " moles per second.");
    }
    
    
    private void playSound(String fileName) { 
        AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
        sound.play();
    }
}
