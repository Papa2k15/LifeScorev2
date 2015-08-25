package ludum.vita.beans;

/**
 * PlayerBean is a basic object that is used for loading and storing player data. This
 * is a role-based bean that serves as the main access for registered players.
 * 
 * @author Gregory L. Daniels
 * @version 1.0
 *
 */
public class PlayerBean {
	
	/**
	 * Unique identifier for this player.
	 */
	private String LSUID = "";
	
	/**
	 * String representation for this player's first name.
	 */
	private String firstName = "";
	
	/**
	 * String representation for this player's last name.
	 */
	private String lastName = "";
	
	/**
	 * String representation for this player's unique username.
	 */
	private String userName = "";
	
	/**
	 * String representation for this player's password.
	 */
	private String password = "";
	
	/**
	 * Constructor for registering a new player to the Life Score player roster.
	 * @param firstName String representing new player's first name.
	 * @param userName String representing new player's username.
	 * @param password String representing new player's password. Password should never
	 * be visible throughout the entire application.
	 */
	public PlayerBean(String firstName, String userName, String password){
		this.setFirstName(firstName);
		this.setUserName(userName);
		this.setPassword(password);
	}
	
	/**
	 * Constructor for loading players from the Life score roster.
	 * @param LSUID String representing player's unique identifier.
	 * @param firstName String representing new player's first name.
	 * @param userName String representing new player's username.
	 * @param password String representing new player's password. Password should never
	 * be visible throughout the entire application.
	 */
	public PlayerBean(String LSUID, String firstName, String userName, String password){
		this(firstName, userName, password);
		this.setLSUID(LSUID);
	}

	/**
	 * Getter for retrieving this player's unique identification number.
	 * @return String representing this player's unique identification number.
	 */
	public String getLSUID() {
		return LSUID;
	}

	/**
	 * Setter for changing this player's unique identification number.
	 * @param lSUID new LSUID to set for this user. SHOULD NEVER BE 
	 * CALLED FROM CLIENTS.
	 */
	protected void setLSUID(String lSUID) {
		LSUID = lSUID;
	}

	/**
	 * Getter for retrieving this player's first name.
	 * @return String representing this player's first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter for changing this player's first name.
	 * @param firstName New string for this player's first name.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter for retrieving this player's last name.
	 * @return String representing this player's last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter for changing this player's last name.
	 * @param lastName New string for this player's last name.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter for retrieving this player's username.
	 * @return String representing this player's username.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Setter for changing this player's username.
	 * @param userName New string for this player's username.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Getter for retrieving this player's password.
	 * @return String representing this player's password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter for changing this player's password.
	 * @param password New string for this player's password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
