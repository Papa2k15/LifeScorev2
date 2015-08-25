/**
 * 
 */
package ludum.vita.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import ludum.vita.beans.PlayerBean;
import ludum.vita.security.PasswordManager;

/**
 * @author Owner
 *
 */
public class PlayerLoader implements BeanLoader<PlayerBean> {

	private PasswordManager p = PasswordManager.getPasswordConfiguration();
	
	@Override
	public PlayerBean loadSingle(ResultSet rs) throws SQLException {
		PlayerBean uBean = 
				new PlayerBean(rs.getString("LSUID"), 
						rs.getString("firstName"), 
						rs.getString("userName"), 
						p.restorePassword(rs.getString("password")));
		uBean.setLastName(rs.getString("lastName"));
		return uBean;
	}

	@Override
	public List<PlayerBean> loadList(ResultSet rs) throws SQLException {
		List<PlayerBean> users = new LinkedList<PlayerBean>();
		while (rs.next()) {
			users.add(loadSingle(rs));
		}
		return users;
	}
	
	@Override
	public PreparedStatement loadParameters(PreparedStatement ps, PlayerBean bean) {
		return null;
	}

}
