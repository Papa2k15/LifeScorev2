/**
 * 
 */
package ludum.vita.beans.loaders;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import ludum.vita.beans.PlayerBean;
import ludum.vita.security.PasswordManager;

/**
 * @author Owner
 *
 */
public class PlayerLoader implements BeanLoader<PlayerBean> {

	private PasswordManager p;
	
	public PlayerLoader() {
		try {
			p = PasswordManager.getPasswordConfiguration();
		} catch (NoSuchAlgorithmException | NoSuchPaddingException
				| NoSuchProviderException e) {
			// TODO
			System.out.println("ERROR WITH PASSWORD MANAGER");
		}	}
	
	@Override
	public PlayerBean loadSingle(ResultSet rs) throws SQLException {
		PlayerBean uBean = null;
		try {
			uBean = new PlayerBean(rs.getString("LSUID"), 
					rs.getString("firstName"), 
					rs.getString("userName"), 
					p.decryptPassword(rs.getString("password")));
			uBean.setLastName(rs.getString("lastName"));
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException e) {
			// TODO
			System.out.println("ERROR WITH PASSWORD MANAGER");
		}
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
