package bank;
import java.sql.*;
public class ConnectionFactory {
	//Instance variable
Connection con;
Statement stmt;

public ConnectionFactory() {
	try {
		//Loading the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		//connecting jabc with my sql
		//Establish connection with  database
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagement","root","Anu@123");
stmt=con.createStatement();
		


	}
	catch(Exception e){
		e.printStackTrace();
	}
}

}
