import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OTP extends JFrame implements ActionListener {

	JButton addButton;
	JLabel resultLabel;
	JPanel listHolder, addHolder;
	JTextField siteField;
	GridLayout gLayout;
	ArrayList otpList;
	OTP() {
		
		otpList = new ArrayList();
		listHolder = new JPanel();
		addHolder = new JPanel();
		gLayout = new GridLayout(0,1);
		addButton = new JButton("+");
		resultLabel = new JLabel("Your OTP Code");
		siteField = new JTextField(15);
		
		addButton.addActionListener(this); // do some action on click
		addHolder.setLayout(new FlowLayout());
		listHolder.setLayout(gLayout);
		
		/* UX setup */
		setLayout(new BorderLayout());// many layouts available. We picked border layout.
		
		addHolder.add(siteField);
		addHolder.add(addButton);
		
		add(listHolder,BorderLayout.CENTER); 
		add(addHolder, BorderLayout.SOUTH);
		
		resultLabel.setHorizontalAlignment(JLabel.CENTER); // center justifies the label contents
		
		//add(resultLabel, BorderLayout.CENTER); // organization of components within frame
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
	//	int length = 6;
	//	resultLabel.setText(String.valueOf(OTP.generate(length)));
		if(e.getSource() == addButton) {
			System.out.println(siteField.getText());
			OTPData oData = new OTPData(siteField.getText(),
										String.valueOf(OTP.generate(6)));
			otpList.add(oData);
			//gLayout.add(new JLabel(oData.siteName));

		}
		 
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new OTP();

	}
	

}
