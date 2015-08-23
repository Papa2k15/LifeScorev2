package ludum.vita.beans;

public class DemographicsBean {
	
	private String LSUID;
	
	private String ethnicity;

	private String dateOfBirth;
	
	private String gender;
	
	public DemographicsBean(String gender, String dateOfBirth){
		this.setGender(gender);
		this.setDateOfBirth(dateOfBirth);
	}
	
	public DemographicsBean(String LSUID, String gender, String dateOfBirth){
		this(gender,dateOfBirth);
		this.setLSUID(LSUID);
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

	/**
	 * @return the ethnicity
	 */
	public String getEthnicity() {
		return ethnicity;
	}

	/**
	 * @param ethnicity the ethnicity to set
	 */
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
