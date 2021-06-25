package _08_calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
	


public class Calculator implements ActionListener {
	JButton add; 
	JButton sub; 
	JButton mul; 
	JButton div; 
	JTextField num1;
	JTextField num2;
	JLabel label;
	void run() {
		//Make UI
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.add(panel);
		frame.setVisible(true);
		num1 = new JTextField(12);
		num2 = new JTextField(12);
		add = new JButton("add");
		sub = new JButton("sub");
		mul = new JButton("mul");
		div = new JButton("div");
		panel.add(num1);
		panel.add(num2);
		panel.add(add);
		panel.add(sub);
		panel.add(mul);
		panel.add(div);
		label = new JLabel("Do Math");
		panel.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 150);
		
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		
	}
	
	
	
	
	double add(double num1,double num2) {
		return(num1+num2);
	}
	double sub(double num1,double num2) {
		return(num1-num2);
	}
	double mul(double num1,double num2) {
		return(num1*num2);
	}
	double div(double num1,double num2) {
		return(num1/num2);
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(num1.getText() == null || num2.getText() == null) {
			label.setText("ERROR");
		} else if(e.getSource() == add) {
			label.setText("Answer: " + String.valueOf(add(Double.parseDouble(num1.getText()), Double.parseDouble(num2.getText()))));
		} else if(e.getSource() == sub) {
			label.setText("Answer: " + String.valueOf(sub(Double.parseDouble(num1.getText()), Double.parseDouble(num2.getText()))));
		} else if(e.getSource() == mul) {
			label.setText("Answer: " + String.valueOf(mul(Double.parseDouble(num1.getText()), Double.parseDouble(num2.getText()))));
		} else {
			label.setText("Answer: " + div(Double.parseDouble(num1.getText()), Double.parseDouble(num2.getText())));
		}
		
	}
}
