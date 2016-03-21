package edu.ucsc.shopping.model;

/**
 * 
 * This class represents a administrator. Administrator is a user who can
 * add/remove books from the system.
 * 
 * @author pallavidas
 *
 */
public class Administrator implements User {
	private String adminFirstName;
	private String adminLastName;
	private String adminPassword;

	public Administrator(String fName, String lName, String password) {
		this.adminFirstName = fName;
		this.adminLastName = lName;
		this.adminPassword = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ucsc.shopping.model.User#getFirstName()
	 */
	public String getFirstName() {
		return adminFirstName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ucsc.shopping.model.User#setFirstName(java.lang.String)
	 */
	public void setFirstName(String firstName) {
		this.adminFirstName = firstName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ucsc.shopping.model.User#getLastName()
	 */
	public String getLastName() {
		return adminLastName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ucsc.shopping.model.User#setLastName(java.lang.String)
	 */
	public void setLastName(String lastName) {
		this.adminLastName = lastName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ucsc.shopping.model.User#getPassword()
	 */
	public String getPassword() {
		return adminPassword;
	}

	@Override
	public void setPassword(String password) {
		this.adminPassword = password;
	}
}
