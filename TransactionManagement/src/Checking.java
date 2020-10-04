/**

@author Max Bartlik, Josh Hymowitz
*/

public class Checking extends Account {
	private boolean directDeposit;
	
	public Checking(Profile holder, double balance, Date dateOpen, boolean directDeposit) {
		super(holder, balance, dateOpen);
		this.directDeposit = directDeposit;
	}
	
	public boolean equals(Account otherAccount) {
		if( !(otherAccount instanceof Checking)) {
			return false;
		}else if(!(super.equals(otherAccount))){
			return false;
		}else if(this.directDeposit != ((Checking) otherAccount).getDirectDeposit()) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean getDirectDeposit() {
		return this.directDeposit;
	}
	
	public double monthlyFee() {
		if(directDeposit) {
			return 0;
		}
		if(this.getBalance() < 1500) {
			return 25;
		}else {
			return 0;
		}
	}
	
	public double monthlyInterest() {
		return 0.05 * this.getBalance();
		
	}
	public String toString() {
		String str1 = super.toString();
		String str2 = " *Checking ";
		String output = str1 + str2;
		if(directDeposit) {
			output += "*direct deposit account";
		}
		return output;
	}
	
}