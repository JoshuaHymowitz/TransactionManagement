
public class Date implements Comparable<Date> {
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	private int year;
	private int month;
	private int day;
	
	/**
	Compares two dates and returns a value representing which date is later in time.
	@param date a date object to be compared
	@return -1 if the date this is called on is earlier than the parameter date
			0 if they are equal
			1 if the first date is later
	*/
	public int compareTo(Date date) { 
		// compare year then month then year
		// if any of them is greater then return -1 or 1
		if(this.year > date.year) {
			return 1;
		}
		else if (this.year < date.year) {
			return -1;
		}
		if(this.month > date.month) {
			return 1;
		}
		else if(this.month < date.month) {
			return -1;
		}
		if(this.day > date.day) {
			return 1;
		}
		else if(this.day < date.day) {
			return -1;
		}
		return 0; // the dates must be equal
		
	} 
	/**
	Stringifies a date object in the format mm/dd/yyyy
	@return string in the format above
	*/
	public String toString() { 
		
		String res = "";
		
		if(this.month <= 9) {
			res += "0"; // need a zero in front of a single digit
		}
		res += this.month;
		res += "/";
		
		if(this.day <= 9) {
			res += "0";
		}
		res += this.day;
		res += "/";
		
		res += this.year;
		
		return res;
	} 
	
	/**
	Check to see if a date object has valid values
	Year must be less than 2021, month must be 1-12, day must be 1-31
	@return boolean representing the validity of the date
	*/
	public boolean isValid() { 
		
		if(this.year > 2020) {
			return false;
		}
		if(this.day < 1 || this.day > 31) {
			return false;
		}
		if(this.month < 1 || this.month > 12) {
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Date date1 = new Date(1999,9,23);
		Date date2 = new Date(19929,9,23);
		Date date3 = new Date(2012,2,3);
		Date date4 = new Date(2018,12,31);
		Date date5 = new Date(2020,10,3);
		
		System.out.println(date1.isValid());
		System.out.println(date2.isValid());
		System.out.println(date1.toString());
		System.out.println(date3.toString());
		System.out.println(date5.toString());
		
		System.out.println(date1.compareTo(date3));
		System.out.println(date4.compareTo(date3));
		System.out.println(date5.compareTo(date5));
	}
	
}


