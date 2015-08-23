/**
 * 
 */
package ludum.vita.beans;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import ludum.vita.enums.Priority;

/**
 * A mission is simply a goal that a player plans to complete via
 * the objectives they set forth. 
 * @author Gregory Daniels
 * @version 1.0
 */
public class MissionBean {

	private String LSMID = "";
	
	private String LSUID = "";
	
	private String title = "";
		
	private String description = "";
	
	private int trackerValue = 0;
	
	private int trackerGoal = 0;
	
	private String units = "";
	
	private String startDate = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
	
	private String endDate = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
	
	private boolean missionComplete = false;

	private Priority priority = Priority.LOW;
	
	private boolean pointsEarned = false;
	
	/**
	 * @param LSUID
	 * @param title
	 * @param objectives
	 */
	public MissionBean(String LSUID, String title, int trackerGoal, String units){
		this.setLSUID(LSUID);
		this.setTitle(title);
		this.setTrackerGoal(trackerGoal);
		this.setUnits(units);
	}

	/**
	 * @param LSMID
	 * @param LSUID
	 * @param title
	 * @param objectives
	 */
	public MissionBean(String LSMID, String LSUID, String title, int trackerGoal, String units){
		this(LSUID,title,trackerGoal,units);
		this.setLSMID(LSMID);
	}

	/**
	 * @return the lSUID
	 */
	public String getLSUID() {
		return LSUID;
	}

	/**
	 * @param lSUID the lSUID to set
	 */
	public void setLSUID(String lSUID) {
		LSUID = lSUID;
	}

	public String getLSMID() {
		return LSMID;
	}

	public void setLSMID(String lSMID) {
		LSMID = lSMID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the trackerValue
	 */
	public int getTrackerValue() {
		return trackerValue;
	}

	/**
	 * @param trackerValue the trackerValue to set
	 */
	public void setTrackerValue(int trackerValue) {
		this.trackerValue = trackerValue;
	}

	/**
	 * @return the trackerType
	 */
	public int getTrackerGoal() {
		return trackerGoal;
	}

	/**
	 * @param trackerType the trackerType to set
	 */
	public void setTrackerGoal(int trackerGoal) {
		this.trackerGoal = trackerGoal;
	}

	/**
	 * @return the units
	 */
	public String getUnits() {
		return units;
	}

	/**
	 * @param units the units to set
	 */
	public void setUnits(String units) {
		this.units = units;
	}

	/**
	 * @return the missionComplete
	 */
	public boolean isMissionComplete() {
		return missionComplete;
	}

	/**
	 * @param missionComplete the missionComplete to set
	 */
	public void setMissionComplete(boolean missionComplete) {
		this.missionComplete = missionComplete;
	}

	public String getStartDateString() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public Date getStartDate() throws ParseException {
		Date d = new SimpleDateFormat("MM/dd/yyyy").parse(startDate);
		return d;
	}
	
	public Date getEndDate() throws ParseException {
		Date d = new SimpleDateFormat("MM/dd/yyyy").parse(endDate);
		return d;
	}


	public String getEndDateString() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Priority getPriority() {
		return priority;
	}
	
	public void setPriority(Priority priority){
		this.priority = priority;
	}

	/**
	 * @return the pointsEarned
	 */
	public boolean isPointsEarned() {
		return pointsEarned;
	}

	/**
	 * @param pointsEarned the pointsEarned to set
	 */
	public void setPointsEarned(boolean pointsEarned) {
		this.pointsEarned = pointsEarned;
	}
	
}
