/**

@author Max Bartlik, Josh Hymowitz
*/

public class AccountDatabase {
	private Account[] accounts;
	private int size;
	
	public AccountDatabase() {
		this.size = 0;
		this.accounts = new Account[5];
		
	}
	
	private int find(Account account) {
		for(int i = 0; i < size; i++) {
			if(this.accounts[i].equals(account)) {
				return i;
			}
		}
		return -1;
		
	}
	private void grow() {
		
		Account[] newDB = new Account[size + 5];
		for(int i = 0; i < size; i++) {
			newDB[i] = this.accounts[i];
		}
		this.accounts = newDB;
	}
	public boolean add(Account account) {
		if(size == this.accounts.length) {
			this.grow();
		}
		if(this.find(account) == -1) {
			this.accounts[size] = account;
			size++;
			return true;
		}else {
			return false;
		}
		
	} //return false if account exists
	
	public boolean remove(Account account) { 
		int index = this.find(account);
		if(index != -1) {
			this.accounts[index] = this.accounts[size];
			this.accounts[size] = null;
			size--;
			return true;
		}else {
			return false;
		}
	} //return false if account doesn’t exist
	
	public boolean deposit(Account account, double amount) { 
		int index = this.find(account);
		if(index != -1) {
			this.accounts[index].credit(amount);
			return true;
		}else {
			return false;
		}
	}
	//return 0: withdrawal successful, 1: insufficient funds, -1 account doesn’t exist
	public int withdrawal(Account account, double amount) {
		int index = this.find(account);
		if(index != -1) {
			if(this.accounts[index].getBalance() < amount) {
				return 1;
			}else {
				this.accounts[index].debit(amount);
				return 0;
			}
		}else {
			return -1;
		}
	}
	private void sortByDateOpen() {
		
		for(int i = 0; i < size; i++) {
			int indexLowest = 0;
			for(int j = i + 1; j < size; j++) {
				if(this.accounts[j].getDate().compareTo(this.accounts[indexLowest].getDate())  < 0) { //if the date being looked at right now is earlier than the date currently believed to be the lowest, replace the indexLowest variable
					indexLowest = j;
				}
			}
			Account temp;
			temp = this.accounts[i];
			this.accounts[i] = this.accounts[indexLowest];
			this.accounts[indexLowest] = temp;
		}
		
	} //sort in ascending order
	private void sortByLastName() {
		for(int i = 0; i < size; i++) {
			int indexLowest = 0;
			for(int j = i + 1; j < size; j++) {
				if(this.accounts[j].getProfile().getLastName().compareTo(this.accounts[indexLowest].getProfile().getLastName()) < 0) { //if the date being looked at right now is earlier than the date currently believed to be the lowest, replace the indexLowest variable
					indexLowest = j;
				}
			}
			Account temp;
			temp = this.accounts[i];
			this.accounts[i] = this.accounts[indexLowest];
			this.accounts[indexLowest] = temp;
		}
	} //sort in ascending order
	public void printByDateOpen() {
		this.sortByDateOpen();
		printAccounts();
	}
	public void printByLastName() { 
		this.sortByLastName();
		printAccounts();
	}
	public void printAccounts() {
		for(Account account : accounts) {
			System.out.println(account.toString());
		}
	}
}

