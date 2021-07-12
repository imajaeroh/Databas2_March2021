package page;

import java.sql.*;

public class DatabasePage {
	public static String getData(String columnName) throws ClassNotFoundException, SQLException {
//		Setting properties for mysql
		Class.forName("com.mysql.cj.jdbc.Driver");// how to define the properties of my sql drivers
		
		String sqlUrl = "jdbc:mysql://localhost:3306/march2021";
		String sqlUsername ="root";
		String sqlPassword ="root";
		String query ="select * from users";
//		Creating a connection to your local database
		Connection con = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
//		empowering the con reference variable to execute queries
		Statement smt = con.createStatement();
//		delivering the sql query
		
		ResultSet rs = smt.executeQuery(query);
		while(rs.next()) {
		return rs.getString(columnName);	
		}
		return columnName;
		}

}
