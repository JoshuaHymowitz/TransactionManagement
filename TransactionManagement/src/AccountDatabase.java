/**

@author Max Bartlik, Josh Hymowitz
*/

public class AccountDatabase {
	private Account[] accounts;
	private int size;
	
	public AccountDatabase() {
		this.size = 5;
		this.accounts = new Account[5];
		
	}
	
	private int find(Account account) {
		for(int i = 0; i < size; i++) {
			if(accounts[i].equals(account)) {
				return i;
			}
		}
		return -1;
		
	}
	private void grow() { }
	public boolean add(Account account) { } //return false if account exists
	public boolean remove(Account account) { } //return false if account doesn’t exist
	public boolean deposit(Account account, double amount) { }
	//return 0: withdrawal successful, 1: insufficient funds, -1 account doesn’t exist
	public int withdrawal(Account account, double amount) { }
	private void sortByDateOpen() { } //sort in ascending order
	private void sortByLastName() { } //sort in ascending order
	public void printByDateOpen() { }
	public void printByLastName() { }
	public void printAccounts() { }
}