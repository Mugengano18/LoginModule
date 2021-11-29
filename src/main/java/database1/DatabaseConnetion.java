package database1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import Models.LoginClass;

public class DatabaseConnetion {
private String connectionString = "jdbc:mysql://localhost:3306/university";
private String dbUser = "root";
private String dbPass = "";
private String dbDriver = "com.mysql.cj.jdbc.Driver";

private void loadDriver(String dbDriver) {
	try {
		Class.forName(dbDriver);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public Connection getConnection() {
	Connection connection = null;
	try {
		connection = DriverManager.getConnection(connectionString,dbUser,dbPass);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connection;
	
}

public String insert(LoginClass login) {
	loadDriver(dbDriver);
	Connection connection = getConnection();
	String querString="INSERT INTO loginuser VALUES (?,?)";
	String messageString = "Records Successfully Registered";
	PreparedStatement preparedStatement = null;
	try {
		preparedStatement = connection.prepareStatement(querString);
		preparedStatement.setString(1, login.getUsernameString());
		preparedStatement.setString(2, login.getPasswrdString());
		
		preparedStatement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		messageString = "Record not acceptedd!!";
		e.printStackTrace();
		
	}
	
	return messageString;
	
}

public boolean CheckCredentials(String uname,String paswd) {
	loadDriver(dbDriver);
	Connection connection = getConnection();
	String quString ="SELECT * FROM loginuser WHERE username=? AND password=?";
	PreparedStatement pStatement = null;
	try {
		pStatement=connection.prepareStatement(quString);
		
		pStatement.setString(1, uname);
		pStatement.setString(2, paswd);
		
		ResultSet resultSet = pStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
	
}


}
