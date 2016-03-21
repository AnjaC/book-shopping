package edu.ucsc.shopping.model;

/**
 * This is an interface that represents an user and their properties.
 * 
 * @author pallavidas
 *
 */
public interface User {
	/**
	 * This method returns first name of an user
	 * 
	 * @return - first name
	 */
	public String getFirstName();

	/**
	 * This method returns last name of an user
	 * 
	 * @return - last name
	 */
	public String getLastName();

	/**
	 * This method sets new first name of an user
	 * 
	 * @param fName
	 *            - first name
	 */
	public void setFirstName(String fName);

	/**
	 * This method sets new last name of an user
	 * 
	 * @param lNAme
	 *            - last name
	 */
	public void setLastName(String lNAme);

	/**
	 * This method returns password.
	 * 
	 * @return - password
	 */
	public String getPassword();

	/**
	 * This method sets new password.
	 * 
	 * @param password
	 *            - sets new password
	 */
	public void setPassword(String password);
}
