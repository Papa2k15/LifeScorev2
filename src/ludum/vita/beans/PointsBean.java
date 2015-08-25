package ludum.vita.beans;

/**
 * PointsBean is a vital bean that stores all the points for a user.
 * 
 * @author Gregory L. Daniels
 * @version 1.0
 *
 */
public class PointsBean {
	
	/**
	 * Unique identifier for the user of this PointsBean.
	 */
	private String LSUID = "";
	
	/**
	 * Long representing the total lifetime points for this PointsBean.
	 */
	private long total = 0;
	
	/**
	 * Long representing a daily total of the points earned from a user.
	 * Will RESET to zero each day.
	 */
	private long daily = 0;
	
	/**
	 * Long representing a weekly total of the points earned from a user.
	 * Will RESET to zero each week.
	 */
	private long weekly = 0;
	
	/**
	 * Long representing a monthly total of the points earned from a user.
	 * Will RESET to zero each month.
	 */
	private long monthly = 0;
	
	/**
	 * Long representing a yearly total of the points earned from a user.
	 * Will RESET to zero each year.
	 */
	private long yearly = 0;
	
	/**
	 * Boolean validation to see if the daily total points was reset.
	 */
	private boolean dReset = false;
	
	/**
	 * Boolean validation to see if the weekly total points was reset.
	 */
	private boolean wReset = false;
	
	/**
	 * Boolean validation to see if the monthly total points was reset.
	 */
	private boolean mReset = false;
	
	/**
	 * Boolean validation to see if the yearly total points was reset.
	 */
	private boolean yReset = false;

	/**
	 * Default constructor for creating a new points bean. Should only be used by the
	 * database.
	 * @param LSUID Unique identifier for the corresponding user of this PointsBean.
	 */
	public PointsBean(String LSUID){
		this.setLSUID(LSUID);
	}

	/**
	 * Getter for this PointsBean user's unique ID.
	 * @return String representing user's unique ID.
	 */
	public String getLSUID() {
		return LSUID;
	}

	/**
	 * Setter for the user unique ID of this points bean.
	 * @param lSUID user's unique ID.
	 */
	public void setLSUID(String lSUID) {
		LSUID = lSUID;
	}

	/**
	 * Getter for retrieving the total lifetime number of points accumulated.
	 * @return Long representing the total lifetime points.
	 */
	public long gettotal() {
		return total;
	}

	/**
	 * Setter for the total lifetime number of points accumulated.
	 * @param total lifetime points accumulated.
	 */
	public void settotal(long total) {
		this.total = total;
	}

	/**
	 * Getter for retrieving the daily points accumulated.
	 * @return Long representing the daily points.
	 */
	public long getDaily() {
		return daily;
	}

	/**
	 * Setter for the daily number of points accumulated.
	 * @param daily points accumulated.
	 */
	public void setDaily(long daily) {
		this.daily = daily;
	}

	/**
	 * Getter for retrieving the weekly points accumulated.
	 * @return Long representing the weekly points.
	 */
	public long getWeekly() {
		return weekly;
	}

	/**
	 * Setter for the weekly number of points accumulated.
	 * @param weekly points accumulated.
	 */
	public void setWeekly(long weekly) {
		this.weekly = weekly;
	}

	/**
	 * Getter for retrieving the monthly points accumulated.
	 * @return Long representing the monthly points.
	 */
	public long getMonthly() {
		return monthly;
	}

	/**
	 * Setter for the monthly number of points accumulated.
	 * @param monthly points accumulated.
	 */
	public void setMonthly(long monthly) {
		this.monthly = monthly;
	}

	/**
	 * Getter for retrieving the yearly points accumulated.
	 * @return Long representing the monthly points.
	 */
	public long getYearly() {
		return yearly;
	}

	/**
	 * Setter for the yearly number of points accumulated.
	 * @param yearly points accumulated.
	 */
	public void setYearly(long yearly) {
		this.yearly = yearly;
	}

	/**
	 * Boolean to check is the daily points have been reset.
	 * @return boolean validating if the daily points have been reset to zero.
	 */
	public boolean isdReset() {
		return dReset;
	}

	/**
	 * Set the boolean for reseting the daily points.
	 * @param dReset boolean representing if daily points have been reset.
	 */
	public void setdReset(boolean dReset) {
		this.dReset = dReset;
	}

	/**
	 * Boolean to check is the weekly points have been reset.
	 * @return boolean validating if the weekly points have been reset to zero.
	 */
	public boolean iswReset() {
		return wReset;
	}

	/**
	 * Set the boolean for reseting the weekly points.
	 * @param dReset boolean representing if weekly points have been reset.
	 */
	public void setwReset(boolean wReset) {
		this.wReset = wReset;
	}

	/**
	 * Boolean to check is the monthly points have been reset.
	 * @return boolean validating if the monthly points have been reset to zero.
	 */
	public boolean ismReset() {
		return mReset;
	}

	/**
	 * Set the boolean for reseting the monthly points.
	 * @param dReset boolean representing if monthly points have been reset.
	 */
	public void setmReset(boolean mReset) {
		this.mReset = mReset;
	}

	/**
	 * Boolean to check is the yearly points have been reset.
	 * @return boolean validating if the yearly points have been reset to zero.
	 */
	public boolean isyReset() {
		return yReset;
	}

	/**
	 * Set the boolean for reseting the yearly points.
	 * @param dReset boolean representing if yearly points have been reset.
	 */
	public void setyReset(boolean yReset) {
		this.yReset = yReset;
	}
}
