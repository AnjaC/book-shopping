package edu.ucsc.shopping.model;

/**
 * 
 * This class represents a customer. Customer is a user who can add books to his
 * book cart.
 * 
 * @author pallavidas
 *
 */
public class Customer implements User {
	private String customerFirstName;
	private String customerLastName;
	private String customerPassword;
	private BookCart cartObj = null;

	public Customer() {
		cartObj = new BookCart();
	}

	public Customer(String fName, String lName, String password) {
		this.customerFirstName = fName;
		this.customerLastName = lName;
		this.customerPassword = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ucsc.shopping.model.User#getFirstName()
	 */
	public String getFirstName() {
		return customerFirstName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ucsc.shopping.model.User#setFirstName(java.lang.String)
	 */
	public void setFirstName(String firstName) {
		this.customerFirstName = firstName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ucsc.shopping.model.User#getLastName()
	 */
	public String getLastName() {
		return customerLastName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ucsc.shopping.model.User#setLastName(java.lang.String)
	 */
	public void setLastName(String lastName) {
		this.customerLastName = lastName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ucsc.shopping.model.User#getPassword()
	 */
	public String getPassword() {
		return customerPassword;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ucsc.shopping.model.User#setPassword(java.lang.String)
	 */
	public void setPassword(String password) {
		this.customerPassword = password;
	}

	/**
	 * method that returns customer cart.
	 * 
	 * @return - BookCart cartObj
	 */
	public BookCart getBookCart() {

		return cartObj;
	}

}
