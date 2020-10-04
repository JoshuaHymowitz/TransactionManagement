/**
Abstract class that defines the features common to all account types
@author Max Bartlik, Josh Hymowitz
*/

public abstract class Account {
	private Profile holder;
	private double balance;
	private Date dateOpen;
	
	
	
	/**
	 * Method to decrease the amount of money in the account by the specified value,
	 * Should only be run if the withdraw method is successful, check for insufficient funds will be there
	 * @param amount of money to be removed
	 */
	public void debit(double amount) {
		this.balance -= amount;
	} 
	
	/**
	 * Method to increase the amount of money in the account by the specified value
	 * 
	 * @param amount of money to be added
	 */
	public void credit(double amount) {
		this.balance += amount;
	} 
	
	/**
	 * Method override of toString()
	 * @return a string containing the profile information, balance, and date opened
	 */
	public String toString() {
		String output = "";
		output += this.holder.getName();
		output += "* $";
		output += this.balance;
		output + "*";
		output += this.dateOpen.toString();
		
		
	}
	public abstract double monthlyInterest { }
	public abstract double monthlyFee() { }
	
	
	public boolean equals() {
		
	}
}