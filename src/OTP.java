import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class OTP extends JFrame implements ActionListener {

	JButton new_OTP;
	JLabel resultLabel;
	
	OTP() {
		new_OTP = new JButton("Refresh");
		resultLabel = new JLabel("Your OTP Code");
		new_OTP.addActionListener(this); // do some action on click
	
		/* UX setup */
		setLayout(new BorderLayout()); // many layouts available. We picked border layout.
		resultLabel.setHorizontalAlignment(JLabel.CENTER); // center justifies the label contents
		add(new_OTP, BorderLayout.SOUTH);
		add(resultLabel, BorderLayout.CENTER); // organization of components within frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows close operation
		setLocation(250,100); //controls the position of the window
		setVisible(true); //shows the window
		setSize(600,350); //controls the size of the window

		 
	}
	
	static char[] generate(int len) {
		System.out.println("Generating OTP using random(): ");
		String numbers = "0123456789";
		Random rnd_choose = new Random();
		char[] otp = new char[len];
		//choose a random index in the numbers string and put it in otp char array
		for (int i = 0; i < len; i++ ) {
			otp[i] = numbers.charAt(rnd_choose.nextInt(numbers.length()));
		}
		return otp;
	}
	
	public void actionPerformed(ActionEvent e) {
		int length = 6;
		resultLabel.setText(String.valueOf(OTP.generate(length)));
		 
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new OTP();

	}
	

}
