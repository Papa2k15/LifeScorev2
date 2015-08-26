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

/**
 * @author Owner
 *
 */
public class PlayerLoader implements BeanLoader<PlayerBean> {

	/* (non-Javadoc)
	 * @see ludum.vita.beans.loaders.BeanLoader#loadSingle(java.sql.ResultSet)
	 */
	@Override
	public PlayerBean loadSingle(ResultSet rs) throws SQLException {
		PlayerBean uBean = null;
		uBean = new PlayerBean(rs.getString("LSUID"), 
				rs.getString("firstName"), 
				rs.getString("userName"), 
				rs.getString("password"));
		uBean.setLastName(rs.getString("lastName"));
		return uBean;
	}

	/* (non-Javadoc)
	 * @see ludum.vita.beans.loaders.BeanLoader#loadList(java.sql.ResultSet)
	 */
	@Override
	public List<PlayerBean> loadList(ResultSet rs) throws SQLException {
		List<PlayerBean> users = new LinkedList<PlayerBean>();
		while (rs.next()) {
			users.add(loadSingle(rs));
		}
		return users;
	}

	/* (non-Javadoc)
	 * @see ludum.vita.beans.loaders.BeanLoader#loadParameters(java.sql.PreparedStatement, java.lang.Object)
	 */
	@Override
	public PreparedStatement loadParameters(PreparedStatement ps, PlayerBean bean) {
		return null;
	}

}
