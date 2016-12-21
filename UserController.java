public class UserController {

	public static boolean validateUserName(String name) { // false if this name
															// is token
		for (int i = 0; i < UserDB.getListOfUsers().size(); i++) {
			if (UserDB.getListOfUsers().get(i).getAccount().getUserName().equals(name) == true) {
				return false;
			}
		}
		return true;
	}
	public static boolean createNewUser(int type) { // 1 student 2 teacher
		
		Account account = new Account();
		boolean valid = UserInterface.getAccountInfo(account);
		if (!valid)
			return false;

		User user;
		if (type == 1) {
			user = new User();
			user.setType('s');
		} else {
			user = new Teacher();
			user.setType('t');
		}
		user.setAccount(account);
		Systems.addUser(user);
		Systems.setLoggedInUser(user);
		return true;
	}

}
