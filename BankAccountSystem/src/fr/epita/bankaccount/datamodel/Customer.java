/**
 * 
 */
package fr.epita.bankaccount.datamodel;

import java.util.List;

/**
 * @author tbrou
 *
 */
//public: every class can "see" this class
public class Customer { 

	//private : no access outside of the class
	private String name;
	private String address;

	//accounts is a property which is declared as "package protected" 
	//only classes of the same package can have access to this value
	List<Account> accounts;

	/**
	 * @param name
	 * @param address
	 */
	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the accounts
	 */
	public List<Account> getAccounts() {
		return accounts;
	}

	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	

}
