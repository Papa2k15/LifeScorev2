package ludum.vita.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ludum.vita.beans.PointsBean;
import ludum.vita.beans.loaders.PointsLoader;
import ludum.vita.dbtools.DatabaseTool;

public class PointsDAO {
	
	private DatabaseFactory factory;
	private PointsLoader pointsloader = new PointsLoader();

	public PointsDAO(DatabaseFactory factory) {
		this.factory = factory;
	}

	public long addUserPoints(PointsBean pbean) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			ps = conn.prepareStatement("INSERT INTO points (LSUID, total, daily, weekly, monthly, yearly, dReset, wReset, mReset, yReset) VALUES (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, pbean.getLSUID());
			ps.setLong(2, pbean.gettotal());
			ps.setLong(3, pbean.getDaily());
			ps.setLong(4, pbean.getWeekly());
			ps.setLong(5, pbean.getMonthly());
			ps.setLong(6, pbean.getYearly());
			ps.setBoolean(7, pbean.isdReset());
			ps.setBoolean(8, pbean.iswReset());
			ps.setBoolean(9, pbean.ismReset());
			ps.setBoolean(10, pbean.isyReset());
			ps.executeUpdate();
			ps.close();
			return DatabaseTool.getLastInsert(conn);
		} catch (SQLException e) {
			throw new Exception("Error connecting to database.");
		} finally {
			DatabaseTool.closeConnection(conn, ps);
		}
	}
	
	public void updateUserPoints(PointsBean pointsBean) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			ps = conn.prepareStatement("UPDATE points SET total = ?, daily = ?, weekly = ?, monthly = ?, yearly = ?, "
					+ "dReset = ?, wReset = ?, mReset = ?, yReset = ? WHERE LSUID = ?");
			ps.setLong(1, pointsBean.gettotal());
			ps.setLong(2, pointsBean.getDaily());
			ps.setLong(3, pointsBean.getWeekly());
			ps.setLong(4, pointsBean.getMonthly());
			ps.setLong(5, pointsBean.getYearly());
			ps.setBoolean(6, pointsBean.isdReset());
			ps.setBoolean(7, pointsBean.iswReset());
			ps.setBoolean(8, pointsBean.ismReset());
			ps.setBoolean(9, pointsBean.isyReset());
			ps.setString(10, pointsBean.getLSUID());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new Exception("Error connecting to database.");
		} finally {
			DatabaseTool.closeConnection(conn, ps);
		}
	}

	public PointsBean getUserPoints(String LSUID) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			ps = conn.prepareStatement("SELECT * FROM points WHERE LSUID = ?");
			ps.setString(1, LSUID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				PointsBean result = pointsloader.loadSingle(rs); 
				rs.close();
				ps.close();
				return result;
			}
			else{
				rs.close();
				ps.close();
				return null;
			}
		} catch (SQLException e) {
			throw new Exception("Error connecting to database.");
		} finally {
			DatabaseTool.closeConnection(conn, ps);
		}
	}

	public void removeUserPoints(String LSUID) throws Exception  {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			ps = conn.prepareStatement("DELETE FROM points WHERE LSUID = ?");
			ps.setString(1, LSUID);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new Exception("Error connecting to database.");
		} finally {
			DatabaseTool.closeConnection(conn, ps);
		}
	}

	//FOR TESTING ONLY
	@SuppressWarnings("resource")
	public void clearPointsTable() throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			ps = conn.prepareStatement("DELETE FROM points");
			ps.executeUpdate();
			ps = conn.prepareStatement("ALTER TABLE points AUTO_INCREMENT = 0");
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new Exception("Error connecting to database.");
		} finally {
			DatabaseTool.closeConnection(conn, ps);
		}
	}
}
