import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Account {
	private String userName, password, email;
	Datee birthdate;
	private Datee dateOfRegistration;
	private Gender gender;

	public void editAccount() {
		int c = 0;
		Scanner choice = new Scanner(System.in);
		Scanner newvalue = new Scanner(System.in);
		while (true) {
			System.out.println("1 for user name");
			System.out.println("2 for password");
			System.out.println("3 for email");
			System.out.println("4 for finish editing");
			System.out.println("enter num of your choice");
			c = choice.nextInt();
			switch (c) {
			case 1:
				System.out.println("enter new user name");
				userName = newvalue.nextLine();
				break;
			case 2:
				System.out.println("enter new password");
				password = newvalue.nextLine();
				break;
			case 3:
				System.out.println("enter new email");
				email = newvalue.nextLine();
				break;
			case 4:
				c = 0;
				break;
			default:
				System.out.println("wrong input");
			}
			if (c == 0)
				break;
		}
	}

	public String toString() {
		String acc = "username " + userName + "\n" + "password " + password + "\n" + "email " + email + "\n"
				+ "birthdate " + birthdate + "\n" + "date of registeration " + dateOfRegistration + "\n" + "gender "
				+ gender;
		return acc;
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
