package ludum.vita.dbtools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseTool {
	
	public static long getLastInsert(Connection conn) throws SQLException {
		ResultSet rs = conn.createStatement().executeQuery("SELECT LAST_INSERT_ID()");
		rs.next();
		long result = rs.getLong(1);
		rs.close();
		return result;
	}

	public static void closeConnection(Connection conn, PreparedStatement ps){
		try {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.err.println("Error closing connections");
			
		}
	}
}
