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
			this.accounts[index] = this.accounts[size - 1];
			this.accounts[size - 1] = null;
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
			int indexLowest = i;
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
			int indexLowest = i;
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
		for(int i = 0; i < size; i++) {
			System.out.println(this.accounts[i].toString());
		}
	}

/**
	public static void main(String[] args) {
		Date date1 = new Date(2010, 10, 1);
		Date date2 = new Date(2011, 10, 1);
		Date date3 = new Date(2012, 10, 1);
		Date date4 = new Date(2017, 10, 1);
		Date date5 = new Date(2020, 10, 1);
		Date date6 = new Date(2018, 10, 1);
		
		Profile p1 = new Profile("Josh", "Hymowitz");
		Profile p2 = new Profile("Shamehir", "Raja");
		Profile p3 = new Profile("Andrew", "Ceng");
		Profile p4 = new Profile("Louis", "Shinohara");
		Profile p5 = new Profile("Gautham", "Roni");
		Profile p6 = new Profile("Priya", "Patel");
		
		Checking a1 = new Checking(p1, 10, date1, true);
		Checking a2 = new Checking(p2, 10, date2, true);
		Checking a3 = new Checking(p3, 10, date3, true);
		Checking a4 = new Checking(p4, 10, date4, true);
		Checking a5 = new Checking(p5, 10, date5, true);
		Savings a6 = new Savings(p6, 10, date6, true);
		
		AccountDatabase db = new AccountDatabase();
		
		db.add(a1);
		db.add(a2);
		db.add(a3);
		db.add(a4);
		db.add(a5);
		
		db.printAccounts();
		System.out.println("\n-----------\n");
		db.printByLastName();
		System.out.println("\n-----------\n");
		db.printByDateOpen();
		
		
		System.out.println(db.find(a6));
		db.add(a6);
		System.out.println(db.find(a6));
		db.remove(a2);
		db.printAccounts();
		
		db.deposit(a4, 20);
		db.printAccounts();
		System.out.println(db.withdrawal(a2, 15));
		
		System.out.println(db.remove(a2));
		System.out.println(db.add(a4));
		
	
	}*/
}

