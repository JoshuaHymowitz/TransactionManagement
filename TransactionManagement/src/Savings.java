/**

@author Max Bartlik, Josh Hymowitz
*/

public class Savings extends Account {
	private boolean isLoyal;
	
	public Savings(Profile holder, double balance, Date dateOpen, boolean isLoyal) {
		super(holder, balance, dateOpen);
		this.isLoyal = isLoyal;
	}
	
	public boolean equals(Account otherAccount) {
		if( !(otherAccount instanceof Savings)) { //verify the account being compared is a Savings account
			return false;
		}else if(!(super.equals(otherAccount))){ //invoke the super equals method that already compares date, holder, and balance
			return false;
		}else if(this.isLoyal != ((Savings) otherAccount).getLoyal()) { //compare isLoyal
			return false;
		}else {
			return true;
		}
	}
	
	public boolean getLoyal() {
		return this.isLoyal;
	}
	
	public double monthlyFee() {
		if(this.getBalance() < 300) {
			return 5;
		}else {
			return 0;
		}
	}
	
	public double monthlyInterest() {
		if(isLoyal) {
			return 0.35 * this.getBalance();
		}else {
			return 0.25 * this.getBalance();
		}
		
	}
	
	public String toString() {
		String str1 = super.toString();
		String str2 = "*Savings*";
		String output = str1 + str2;
		if(isLoyal) {
			output += "*special savings account";
		}
		return output;
	}
}