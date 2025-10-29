// DD sing Youtube Tutorial - shortcut "cont shift o"  and add uniplemented method

package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
// which ever module begins with J it belogs to swing only
public class Login extends JFrame implements ActionListener {
	
	// Instance variable
	JLabel lblWelcome,lblCardNumber,lblPinNUmber;
	JTextField tfCardNumber;
	JPasswordField pfPinNumber;
	JButton b1,b2,b3;
	
	JButton btnLogin,btnClear,btnSignup;
	//non param constructor
	
	public Login() {
		setTitle("Bank Management System");
		//to disable default layout
		setLayout(null);
	lblWelcome=new JLabel("Welcom to Bank System");
	lblWelcome.setFont(new Font("Arial",Font.BOLD,35));
	lblWelcome.setBounds(200,40,530,40);
		add(lblWelcome);
		
		lblCardNumber=new JLabel("Enter card no:");
		lblCardNumber.setFont(new Font("Tahoma",Font.BOLD,25));
		lblCardNumber.setBounds(120,150,400,30);
			add(lblCardNumber);
		
		tfCardNumber=new JTextField(20);
		tfCardNumber.setBounds(350,150,230,30);
		tfCardNumber.setFont(new Font("Tahoma",Font.BOLD,15));
		add(tfCardNumber);
		
		lblPinNUmber=new JLabel("Enter pin number:");
		lblPinNUmber.setFont(new Font("Tahoma",Font.BOLD,25));
		lblPinNUmber.setBounds(120,250,400,30);
			add(lblPinNUmber);
			
			pfPinNumber=new JPasswordField(20);
			pfPinNumber.setBounds(350,250,230,30);
			pfPinNumber.setFont(new Font("Tahoma",Font.BOLD,15));
			add(pfPinNumber);
			
			btnLogin=new JButton("Login .");
			btnLogin.setBackground(Color.black);
			btnLogin.setForeground(Color.white);
			
			btnClear=new JButton("Clear.");
			btnClear.setBackground(Color.black);
			btnClear.setForeground(Color.white);

			btnSignup=new JButton("Sign Up.");
			btnSignup.setBackground(Color.black);
			btnSignup.setForeground(Color.white);
			
			
			btnLogin.setFont(new Font("Tahoma",Font.BOLD,15));
			btnLogin.setBounds(300,300,100,40);
			add(btnLogin);
			
			btnClear.setFont(new Font("Tahoma",Font.BOLD,15));
			btnClear.setBounds(400,300,100,40);
			add(btnClear);
			
			btnSignup.setFont(new Font("Tahoma",Font.BOLD,15));
			btnSignup.setBounds(500,300,100,40);
			add(btnSignup);
			
			
			//attaching the listener
			btnLogin.addActionListener(this);
			btnClear.addActionListener(this);
			btnSignup.addActionListener(this);
			
			
		//changing background color
		getContentPane().setBackground(Color.pink);
setVisible(true);
setSize(800,500);
setLocation(400,200);


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// creating login class object
		Login obj=new Login();
	}
	
	
	//methods automatically calls when we press button
	public void actionPerformed(ActionEvent ae) {
		try {
			if(ae.getSource()==btnLogin) {
				
				ConnectionFactory cf=new ConnectionFactory();
				String cardNum=tfCardNumber.getText();
				String pin=pfPinNumber.getText();
				String query="Select * from Login where cardnumber='"+cardNum+"' and pin='"+pin+"'";
				ResultSet rs=cf.stmt.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transactions(pin).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Either cardnumber or Pin number is wrong");
				}
				
				
				
				
				//login
			}
			else if(ae.getSource()==btnClear) {
				tfCardNumber.setText("");
				pfPinNumber.setText("");
			}
			else if(ae.getSource()==btnSignup) {
				this.setVisible(false);
				new Signup();
				//sign up
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
