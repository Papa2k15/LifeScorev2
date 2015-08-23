/**
 * 
 */
package ludum.vita.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import ludum.vita.beans.PointsBean;

/**
 * @author Owner
 *
 */
public class PointsLoader implements BeanLoader<PointsBean> {

	@Override
	public PointsBean loadSingle(ResultSet rs) throws SQLException {
		PointsBean pointsBean = new PointsBean(rs.getString("LSUID"));
		pointsBean.settotal(rs.getLong("total"));
		pointsBean.setDaily(rs.getLong("daily"));
		pointsBean.setWeekly(rs.getLong("weekly"));
		pointsBean.setMonthly(rs.getLong("monthly"));
		pointsBean.setYearly(rs.getLong("yearly"));
		pointsBean.setdReset(rs.getBoolean("dReset"));
		pointsBean.setwReset(rs.getBoolean("wReset"));
		pointsBean.setmReset(rs.getBoolean("mReset"));
		pointsBean.setyReset(rs.getBoolean("yReset"));
		return pointsBean;
	}

	@Override
	public List<PointsBean> loadList(ResultSet rs) throws SQLException {
		List<PointsBean> points = new LinkedList<PointsBean>();
		while (rs.next()) {
			points.add(loadSingle(rs));
		}
		return points;
	}
	

	@Override
	public PreparedStatement loadParameters(PreparedStatement ps,
			PointsBean bean) {
		// TODO Auto-generated method stub
		return null;
	}
}
