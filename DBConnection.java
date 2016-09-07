package DB;

import java.sql.*;

import birdNestLanka.Bird;
public class DBConnection {



public Connection creatConn(){
	Connection con=null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		
		System.out.println(e);
	}
	try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bnl","root","");
	} catch (SQLException e) {
		System.out.println(e);
	}
	return con;
	}
 
public String getItem(){
	Connection conn=creatConn(); 
	int num=0;
	try {
		Statement stm=conn.createStatement();
		ResultSet rs=stm.executeQuery("SELECT * FROM birdspecies ");
		rs.next();
		 num=rs.getInt("Family_ID");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}
	return Integer.toString(num);
  }
}
