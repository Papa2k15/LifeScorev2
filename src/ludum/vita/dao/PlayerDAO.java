package ludum.vita.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import ludum.vita.beans.PlayerBean;
import ludum.vita.beans.loaders.PlayerLoader;
import ludum.vita.dbtools.DatabaseTool;
import ludum.vita.security.PasswordManager;

//TODO 
/**
 * The sole purpose of the PlayerDAO is to serve as a single access point
 * for all players that have successfully registered within the Life Score system.
 * 
 * @author Gregory Daniels
 * @version 1.0
 *
 */
public class PlayerDAO {
		
		private DatabaseFactory factory;
		private PasswordManager p;
		private PlayerLoader playerloader = new PlayerLoader();

		public PlayerDAO(DatabaseFactory factory) throws Exception {
			this.factory = factory;
			try {
				p = PasswordManager.getPasswordConfiguration();
			} catch (NoSuchAlgorithmException e) {
				throw new Exception("Password manager issue!");
			}
		}
		
		public long addPlayer(PlayerBean pbean) throws Exception {
			if(!checkPlayerName(pbean.getUserName())){
			String LSUIDGen = getLSUID(pbean);
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = factory.getConnection();
				ps = conn.prepareStatement("INSERT INTO players (LSUID, firstName, lastName, userName, password) VALUES (?,?,?,?,?)");
				ps.setString(1, LSUIDGen);
				ps.setString(2, pbean.getFirstName());
				ps.setString(3, pbean.getLastName());
				ps.setString(4, pbean.getUserName());
				ps.setString(5, p.securePasswordV2(pbean.getPassword()));
				ps.executeUpdate();
				ps.close();
				return DatabaseTool.getLastInsert(conn);
			} catch (SQLException e) {
				throw new Exception("Error connecting to database.");
			} finally {
				DatabaseTool.closeConnection(conn, ps);
			}
			} else {
				throw new Exception("Player already exists in database");
			}
		}
		
		private String getLSUID(PlayerBean ubean) throws NoSuchAlgorithmException {
			 MessageDigest mDigest = MessageDigest.getInstance("SHA1");
			  String input = ubean.getFirstName() + ubean.getUserName() + ubean.getPassword() + new Random().nextInt();
		      byte[] result = mDigest.digest(input.getBytes());
		      StringBuffer sb = new StringBuffer();
		      for (int i = 0; i < result.length; i++) {
		          sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		      }
		      return sb.toString();
		}

		public void updatePlayer(PlayerBean Playerbean) throws Exception {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = factory.getConnection();
				ps = conn.prepareStatement("UPDATE players SET firstName = ?, lastName = ?, "
						+ " password = ? WHERE userName = ?");
				ps.setString(1, Playerbean.getFirstName());
				ps.setString(2, Playerbean.getLastName());
				ps.setString(3, p.securePasswordV2(Playerbean.getPassword()));
				ps.setString(4, Playerbean.getUserName());
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				throw new Exception("Error connecting to database.");
			} finally {
				DatabaseTool.closeConnection(conn, ps);
			}
		}
		
		public PlayerBean getPlayerWithLSUID(String LSUID) throws Exception {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = factory.getConnection();
				ps = conn.prepareStatement("SELECT * FROM players WHERE LSUID = ?");
				ps.setString(1, LSUID);
				ResultSet rs = ps.executeQuery();
				if (rs.next()){
					PlayerBean result = playerloader.loadSingle(rs); 
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

		public PlayerBean getPlayer(String PlayerName) throws Exception {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = factory.getConnection();
				ps = conn.prepareStatement("SELECT * FROM players WHERE userName = ?");
				ps.setString(1, PlayerName);
				ResultSet rs = ps.executeQuery();
				if (rs.next()){
					PlayerBean result = playerloader.loadSingle(rs); 
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

		public boolean checkPlayerName(String PlayerName) throws Exception {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = factory.getConnection();
				ps = conn.prepareStatement("SELECT * FROM players WHERE userName=?");
				ps.setString(1, PlayerName);
				ResultSet rs = ps.executeQuery();
				boolean check = rs.next();
				rs.close();
				ps.close();
				return check;
			} catch (SQLException e) {
				throw new Exception("Error connecting to database.");
			} finally {
				DatabaseTool.closeConnection(conn, ps);
			}
		}

		public List<PlayerBean> getAllPlayers() throws Exception {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = factory.getConnection();
				ps = conn
						.prepareStatement("SELECT * FROM Players");
				ResultSet rs = ps.executeQuery();
				List<PlayerBean> loadlist = playerloader.loadList(rs);
				rs.close();
				ps.close();
				return loadlist;
			} catch (SQLException e) {
				throw new Exception("Error connecting to database.");
			} finally {
				DatabaseTool.closeConnection(conn, ps);
			}
		}
		
		public void removePlayer(PlayerBean uBean) throws Exception  {
			if(!checkPlayerName(uBean.getUserName())){
				throw new Exception("Player doesn't exist.");
			}
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = factory.getConnection();
				ps = conn.prepareStatement("DELETE FROM players WHERE userName = ?");
				ps.setString(1, uBean.getUserName());
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
		public void clearPlayerTable() throws Exception{
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = factory.getConnection();
				ps = conn.prepareStatement("DELETE FROM players");
				ps.executeUpdate();
				ps = conn.prepareStatement("ALTER TABLE players AUTO_INCREMENT = 0");
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				throw new Exception("Error connecting to database.");
			} finally {
				DatabaseTool.closeConnection(conn, ps);
			}
		}

}
