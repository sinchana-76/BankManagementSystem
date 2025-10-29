package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FastCash extends JFrame implements ActionListener{

	JLabel l1,l2;
	JButton b1,b2,b3,b4,b5,b6,b7;
	JTextField tf1;
	String pin;
	public FastCash(String pin) {
		this.pin=pin;
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l3=new JLabel(i3);
		l3.setBounds(0,0,960,1080);
		add(l3);
		
		l1=new JLabel("Select WITHDRAWL AMOUNT");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("System",Font.BOLD,18));
		
		b1=new JButton("Rs. 100");
		b2=new JButton("Rs. 500");
		b3=new JButton("Rs. 1000");
		b4=new JButton("Rs. 2000");
		b5=new JButton("Rs. 5000");
		b6=new JButton("Rs. 10000");
		b7=new JButton("BACK");
		setLayout(null);
		l1.setBounds(235,400,700,35);
		l3.add(l1);
		
		
		b1.setBounds(170,499,150,35);
		l3.add(b1);
		
		b2.setBounds(390,499,150,35);
		l3.add(b2);
		
		
		b3.setBounds(170,543,150,35);
		l3.add(b3);
		
		
		b4.setBounds(390,543,150,35);
		l3.add(b4);
		
		
		b5.setBounds(170,588,150,35);
		l3.add(b5);
		
		
		b6.setBounds(390,588,150,35);
		l3.add(b6);
		
		b7.setBounds(390,633,150,35);
		l3.add(b7);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
	
		
		
		
		
		
		
		setSize(960,1080);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new FastCash("").setVisible(true);


	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		try {
			String amount=((JButton)ae.getSource()).getText().substring(4).trim();//Rs. 100
			ConnectionFactory cf=new ConnectionFactory();
			ResultSet rs=cf.stmt.executeQuery("select * from bank where pin='"+pin+"'");
			int balance=0;
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance+=Integer.parseInt(rs.getString("amount"));
					
				}
				else {
					balance-=Integer.parseInt(rs.getString("amount"));
					
				}
			}
			if(ae.getSource() !=b7 && balance < Integer.parseInt(amount)) {
				JOptionPane.showMessageDialog(null,"Insufficient Balance");
				return;
			}
			if(ae.getSource()==b7) {
				this.setVisible(false);
				new Transactions(pin).setVisible(true);
			}
			else {
				Date date = new Date();
				cf.stmt.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawl','"+amount+"')");
				JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
				setVisible(false);
				new Transactions(pin).setVisible(true);
				
			}

			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
