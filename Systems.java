import java.util.ArrayList;

public class Systems {

	public static ArrayList<GameDetails> gameDetails = new ArrayList<GameDetails>();
	private static User loggedInUser = null;

	public static User getLoggedInUser() {
		return loggedInUser;
	}

	public static void setLoggedInUser(User user) {
		loggedInUser = user;
	}
	
	public static void addUser(User user) {
		UserDB.addNewUser(user);
	}
	public static void setLoggedInUser(String nameOrEmail, String password) {
		if (nameOrEmail.indexOf("@") != -1) {
			for (int i = 0; i < UserDB.getListOfUsers().size(); i++) {
				Account account = UserDB.getListOfUsers().get(i).getAccount();
				if (account.getUserName().equals(nameOrEmail) && account.getPassword().equals(password)) {
					loggedInUser = UserDB.getListOfUsers().get(i);
				}
			}
		} else {
			for (int i = 0; i < UserDB.getListOfUsers().size(); i++) {
				Account account = UserDB.getListOfUsers().get(i).getAccount();
				if (account.getEmail().equals(nameOrEmail) && account.getPassword().equals(password)) {
					loggedInUser = UserDB.getListOfUsers().get(i);
				}
			}
		}
	}

	public static void addGameDetails(GameDetails newGameDetails) {
		gameDetails.add(newGameDetails);
	}

	public static ArrayList<GameDetails> selectGameDetailsByDomain(Domain domain) {
		ArrayList<GameDetails> selected = new ArrayList<GameDetails>();

		for (int i = 0; i < gameDetails.size(); i++) {
			if (gameDetails.get(i).getDomain() == domain)
				selected.add(gameDetails.get(i));
		}

		return selected;
	}

	public static ArrayList<GameDetails> filterGameDetailsByOwner(Teacher teacher) {
		ArrayList<GameDetails> selected = new ArrayList<GameDetails>();

		for (int i = 0; i < gameDetails.size(); i++) {
			if (gameDetails.get(i).getCreator() == teacher)
				selected.add(gameDetails.get(i));
		}

		return selected;
	}

	public static ArrayList<GameDetails> filterGameDetailsByLevel(DiffecultyLevel level) {
		ArrayList<GameDetails> selected = new ArrayList<GameDetails>();

		for (int i = 0; i < gameDetails.size(); i++) {
			if (gameDetails.get(i).getDiffecultyLevel() == level)
				selected.add(gameDetails.get(i));
		}

		return selected;
	}

	public static void updateGamesFromDB() {
		gameDetails = GameDB.loadGamesDetails();
	}

	public static Boolean verifyLogInInfoByUserName(String userName, String password) {
		for (int i = 0; i < UserDB.getListOfUsers().size(); i++) {
			if (UserDB.getListOfUsers().get(i).getAccount().getUserName() == userName
					&& UserDB.getListOfUsers().get(i).getAccount().getPassword() == password)
				return true;
		}

		return false;
	}

	public static Boolean verifyLogInInfoByEmail(String email, String password) {
		for (int i = 0; i < UserDB.getListOfUsers().size(); i++) {
			if (UserDB.getListOfUsers().get(i).getAccount().getEmail() == email
					&& UserDB.getListOfUsers().get(i).getAccount().getPassword() == password)
				return true;
		}

		return false;
	}

}
