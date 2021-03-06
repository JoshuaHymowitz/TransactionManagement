/**

@author Max Bartlik, Josh Hymowitz
*/

public class MoneyMarket extends Account {
	private int withdrawals;
	
	public MoneyMarket(Profile holder, double balance, Date dateOpen, int withdrawals) {
		super(holder, balance, dateOpen);
		this.withdrawals = withdrawals;
	}
	
	public boolean equals(Account otherAccount) {
		if( !(otherAccount instanceof MoneyMarket)) {
			return false;
		}else if(!(super.equals(otherAccount))){
			return false;
		}else if(this.withdrawals != ((MoneyMarket) otherAccount).getWithdrawals()) {
			return false;
		}else {
			return true;
		}
	}
	
	public int getWithdrawals() {
		return this.withdrawals;
	}
	
	public double monthlyFee() {
		if(this.getBalance() < 2500) {
			return 12;
		}else if(withdrawals > 6){
			return 12;
		}else {
			return 0;
		}
	}
	
	public double monthlyInterest() {
		return 0.65 * this.getBalance();
		
	}
	
	public String toString() {
		String str1 = super.toString();
		String str2 = "*Savings*";
		String output = str1 + str2;
		
		output += withdrawals;
		
		return output;
	}
}