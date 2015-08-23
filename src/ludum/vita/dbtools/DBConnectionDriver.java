package ludum.vita.dbtools;

import java.sql.DriverManager;
import java.sql.Connection;

public class DBConnectionDriver {

	public java.sql.Connection getConnection() {
		Connection c = null;
		 try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// TODO
			c = DriverManager.getConnection("jdbc:mysql://localhost/lifescore?user=root&password=");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return c;
	}
}