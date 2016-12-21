import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Account {
	private String userName, password, email;
	Datee birthdate;
	private Datee dateOfRegistration;
	private Gender gender;

	@Override
	public String toString() {
		return "userName = " + userName +  "\nemail = " + email + "\nbirthdate = "
				+ birthdate + "\ndateOfRegistration = " + dateOfRegistration + "\ngender = " + gender ;
	}

	public void setUserName(String name) {
		userName = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setdateOfRegistration(Datee dor) {
		dateOfRegistration = dor;
	}

	public void setbirthdate(Datee bd) {
		birthdate = bd;
	}

	public Datee getbirthdate() {
		return birthdate;
	}

	public Datee getdateOfRegistration() {
		return dateOfRegistration;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}
  
	
}
