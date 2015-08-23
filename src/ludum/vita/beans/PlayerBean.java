package ludum.vita.beans;

public class PlayerBean {
	
	private String LSUID = "";
	
	private String firstName = "";
	
	private String lastName = "";
	
	private String userName = "";
	
	private String password = "";
	
	private String email = "";
	
	/**
	 * @param firstName
	 * @param userName
	 * @param password
	 */
	public PlayerBean(String firstName, String userName, String password){
		this.setFirstName(firstName);
		this.setUserName(userName);
		this.setPassword(password);
	}
	
	/**
	 * @param LSUID
	 * @param firstName
	 * @param userName
	 * @param password
	 */
	public PlayerBean(String LSUID, String firstName, String userName, String password){
		this(firstName, userName, password);
		this.setLSUID(LSUID);
	}

	public String getLSUID() {
		return LSUID;
	}

	public void setLSUID(String lSUID) {
		LSUID = lSUID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
