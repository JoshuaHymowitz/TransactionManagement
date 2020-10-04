/**

@author Max Bartlik, Josh Hymowitz
*/

public class Savings extends Account {
	private boolean isLoyal;
	
	public Savings(Profile holder, double balance, Date dateOpen, boolean isLoyal) {
		super(holder, balance, dateOpen);
		this.isLoyal = isLoyal;
	}
	
	public boolean equals(Savings otherAccount) {
		if( !(otherAccount instanceof Savings)) {
			return false;
		}else if(!(super.equals(otherAccount))){
			return false;
		}else if(this.isLoyal != otherAccount.getLoyal()) {
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
		return 0.25 * this.getBalance();
		
	}
}