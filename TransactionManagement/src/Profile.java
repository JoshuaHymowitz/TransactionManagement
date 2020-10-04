/**

@author Max Bartlik, Josh Hymowitz
*/

public class Profile {
	private String fname;
	private String lname;
	
	/**
	 * accessor method to return a string containing a concatentaion of the first and last name
	 * 
	 * @return string containing the full name
	 */
	public String getName() {
		String output = "";
		output += fname;
		output += " ";
		output += lname;
		return output;
	}
	
	public boolean equals(Profile otherProfile) {
		if(this.getName().equals(otherProfile.getName())) {
			return true;
		}else {
			return false;
		}
	}
	
	public String getLastName() {
		return this.lname;
	}
}