
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
	private int userID;
	private double score;
	private boolean isTerminated;
	private Account account;
	private char type; // s for student... t for teacher
	private AtomicInteger count = new AtomicInteger(0);

	User() {
		userID = count.incrementAndGet();
	}

	private void signIn() {
		isTerminated = false;
	}

	public char getType() {
		return type;
	}

	public void setType(char t) {
		type = t;
	}

	public void setAccount(Account a) {
		account = a;
	}

	public void updateScore(double score) {
		this.score += score;
	}

	public double getScore() {
		return score;
	}

	public int getUserID() {
		return userID;
	}

	public boolean getState() {
		return isTerminated;
	}

	public Account getAccount() {
		return account;
	}
	
    public void showProfile(){
     System.out.println(account + " \nScore: "+ score );	
    }
    
}
