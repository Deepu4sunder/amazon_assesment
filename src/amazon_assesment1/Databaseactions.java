package amazon_assesment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.openqa.selenium.WebElement;

public class Databaseactions {
		private static final String db = "jdbc:mysql://localhost:3306/amazon";
		private static final String dbserver = "jdbc:mysql://localhost:3306";
		private static final String user = "root";
		private static final String pwd = "root";
		private static Connection con;
		private static Statement stmt;
		private static ResultSet rs;
		private static PreparedStatement pstmt;
public void insertRecord(String categories)  {
	
	String query2 = "Insert into amazon.mobile_computer_categories (category_names) values ('"+categories+"')";
	
	try {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		con=DriverManager.getConnection(db, user, pwd);
		
		pstmt = con.prepareStatement(query2);
		
		
		int ret = pstmt.executeUpdate();
		if (ret == 1) {
			System.out.println("Successfully added a new record");
		}
		else {
			System.out.println("Unable to add a new record");
		}
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	finally {
		try {
		con.close();
		pstmt.close();
		}
		catch (Exception e2) {
			e2.printStackTrace();
		}
}
	}
public void retrieveData() {
	String query1 = "select * from mobile_computer_categories";
	try {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		con=DriverManager.getConnection(db, user, pwd);
		
		stmt = con.createStatement();
		rs = stmt.executeQuery(query1);
		while (rs.next()) {
			System.out.println("");
			System.out.printf("Categories: %s", rs.getString("category_names"));
		}
		
		
		}
	catch (SQLException e1) {
		e1.printStackTrace();
	}
	finally {
		try {
		con.close();
		stmt.close();
		rs.close();
		}
		catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}

}
}

