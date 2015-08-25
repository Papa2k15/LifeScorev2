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
 * @version 2.0
 */
public class MissionBean {

	/**
	 * String representation of this mission's unique identification number.
	 */
	private String LSMID = "";
	
	/**
	 * String representation of this mission's owner's unique identification number.
	 */
	private String LSUID = "";
	
	/**
	 * String representation for the title of this mission.
	 */
	private String title = "";
		
	/**
	 * String representation for a short description for this mission.
	 */
	private String description = "";
	
	/**
	 * Integer that represents the current progression amount towards this mission's
	 * goal.
	 */
	private int trackerValue = 0;
	
	/**
	 * Integer that represents the goal for this mission.
	 */
	private int trackerGoal = 0;
	
	/**
	 * String that represents the units for this mission's goal. 
	 */
	private String units = "";
	
	/**
	 * The date for which this mission was created initially.
	 */
	private String startDate = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
	
	/**
	 * The date for which this mission's goal has been reached.
	 */
	private String endDate = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
	
	/**
	 * Boolean variable that checks to see if this mission has been completed.
	 */
	private boolean missionComplete = false;

	/**
	 * Priority determining to what extreme that this mission needs to be complete.
	 */
	private Priority priority = Priority.LOW;
	
	/**
	 * Boolean variable that checks to see if this mission's points have already been earned.
	 */
	private boolean pointsEarned = false;
	
	/**
	 * Constructor that is used for adding new missions to the database from a 
	 * player. Player must be logged in before they can add.
	 * @param LSUID Unique ID for this mission's user.
	 * @param title String that represents this mission's title.
	 * @param trackerGoal An integer representation for the overall goal of this mission.
	 * @param units A string that determines the term of measurement for this mission.
	 */
	public MissionBean(String LSUID, String title, int trackerGoal, String units){
		this.setLSUID(LSUID);
		this.setTitle(title);
		this.setTrackerGoal(trackerGoal);
		this.setUnits(units);
	}

	/**
	 * Constructor that is used by MissionDAO to load missions. Should never be called 
	 * via a player.
	 * @param LSMID Unique ID for this mission.
	 * @param LSUID Unique ID for this mission's user.
	 * @param title String that represents this mission's title.
	 * @param trackerGoal An integer representation for the overall goal of this mission.
	 * @param units A string that determines the term of measurement for this mission.
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
