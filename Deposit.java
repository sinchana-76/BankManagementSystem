package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener{
	JTextField tf1,tf2;
	JButton b1,b2,b3;
	JLabel l1,l2,l3;
	
	String pin;
	
	//parameterized constructor
	public Deposit(String pin) {
		this.pin=pin;
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
	Image i2=i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i2);
	
	l3=new JLabel(i3);
	l3.setBounds(0,0,960,1080);
	add(l3);
	
	
	l1=new JLabel("Enter amount you want to deposite");
	l1.setForeground(Color.WHITE);
	l1.setFont(new Font("System",Font.BOLD,16)); //cont shift o
	l1.setBounds(190,350,400,35);
	l3.add(l1);
	
	
	tf1=new JTextField();
	tf1.setFont(new Font("Raleway",Font.BOLD,22));
	tf1.setBounds(190,420,320,25);
	l3.add(tf1);
	
	b1=new JButton("Deposite");
	b2=new JButton("Back");
	
	b1.setBounds(390,588,150,35);
	add(b1);
	b2.setBounds(390,633,150,35);
	add(b2);
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	
	
		
	}
public static void main(String[] args) {
new Deposit("");	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	try {
		String amount =tf1.getText();
		Date  date=new Date();
		if(e.getSource()==b1) {
			if(tf1.getText().equals("")) {
				JOptionPane.showConfirmDialog(null,"Please Enter some amount");
				}
			else {
				ConnectionFactory cf=new ConnectionFactory();
				cf.stmt.executeUpdate("insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')");
				JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposited Successfully");
				setVisible(false);
				new Transactions(pin).setVisible(true);
				
			}
		}
		else if(e.getSource()==b2) {
			setVisible(false);
			new Transactions(pin).setVisible(true);
		}
	}
	catch(Exception ae) {
		ae.printStackTrace();
	}
	
}
}
