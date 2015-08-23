/**
 * 
 */
package ludum.vita.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import ludum.vita.beans.MissionBean;
import ludum.vita.enums.Priority;

/**
 * @author Owner
 *
 */
public class MissionLoader implements BeanLoader<MissionBean> {

	@Override
	public List<MissionBean> loadList(ResultSet rs) throws SQLException {
		List<MissionBean> missions = new LinkedList<MissionBean>();
		while (rs.next()) {
			missions.add(loadSingle(rs));
		}
		return missions;
	}

	@Override
	public MissionBean loadSingle(ResultSet rs) throws SQLException {		
		MissionBean mBean = new MissionBean(rs.getString("LSMID"), rs.getString("LSUID"), rs.getString("title"), rs.getInt("trackerGoal"), rs.getString("unit"));
		mBean.setDescription(rs.getString("description"));
		mBean.setTrackerValue(rs.getInt("trackerVal"));
		mBean.setStartDate(new SimpleDateFormat("MM/dd/yyyy").format(new Date(rs.getDate("startDate").getTime())));
		mBean.setEndDate(new SimpleDateFormat("MM/dd/yyyy").format(new Date(rs.getDate("endDate").getTime())));
		mBean.setMissionComplete(rs.getBoolean("complete"));
		try {
			mBean.setPriority(Priority.parse(rs.getString("priority")));
		} catch (Exception e) {
			System.out.println("HSD");
			throw new SQLException(e.getMessage());
		}
		mBean.setPointsEarned(rs.getBoolean("pointsEarned"));
		return mBean;
	}

	@Override
	public PreparedStatement loadParameters(PreparedStatement ps,
			MissionBean bean) {
		// TODO Auto-generated method stub
		return null;
	}
}
