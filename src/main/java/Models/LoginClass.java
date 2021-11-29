package Models;

public class LoginClass {
	private String usernameString;
	private String passwrdString;
	public LoginClass(String usernameString, String passwrdString) {
		super();
		this.usernameString = usernameString;
		this.passwrdString = passwrdString;
	}
	public String getUsernameString() {
		return usernameString;
	}
	public void setUsernameString(String usernameString) {
		this.usernameString = usernameString;
	}
	public String getPasswrdString() {
		return passwrdString;
	}
	public void setPasswrdString(String passwrdString) {
		this.passwrdString = passwrdString;
	}
	
	

}
