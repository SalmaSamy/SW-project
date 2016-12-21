
import java.util.Vector;

public class UserDB {

	private static Vector<User> listOfUsers = new Vector<User>();
	// carries students and teachers identified by attribute type

	static void addNewUser(User user) {
		listOfUsers.add(user);
	}
	public static Vector<User> getListOfUsers() {
		return listOfUsers;
	}

	static void updatePassword(String userName, String newPass) {

	}

	static void updateEmail(String userName, String newPass) {

	}

	static void updateUserPoints(int value) {

	}

	static void updateTeacherDomains(Vector<Domain> domains) {

	}
}
