import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class UserInterface {
	public static Scanner cin = new Scanner(System.in);
	
public static void main(String[] args) {

		while (true) {
			System.out.println("\n\t\tWelcome To Learnable");
			System.out.println("\n\n1.Sign in\n2.Sign up\n3.Exit");

			int choice = cin.nextInt();

			if (choice == 1) {
				signIn();
			} else if (choice == 2) {
				signUp();
			} else
				break;

			while (Systems.getLoggedInUser() != null) {
				System.out.println("\n\n\n1.Play Game");
				System.out.println("\n2.Show Score");
				System.out.println("\n3.Show Profile");
				System.out.println("\n4.edite Account");

				int lastOption = 5;
				if (Systems.getLoggedInUser().getType() == 't') {
					System.out.println("\n5.CreateGame");
					lastOption = 6;
				}
				System.out.println("\n" + lastOption + ".log Out");

				choice = cin.nextInt();
				if (choice == lastOption) {
					Systems.setLoggedInUser(null);
					break;
				}
				if (choice == 1) {
					System.out.println("\n\nDomains: \n");
					System.out.println("\n1. " + Domain.Math + "\n2. " + Domain.Science);
					System.out.println("3. " + Domain.Chemistry + "\n4. " + Domain.Programming);
					System.out.println("\nChoose Domain: ");

					ArrayList<GameDetails> games = new ArrayList<GameDetails>();
					
					switch (cin.nextInt()) {
					case 1:
						games = Systems.selectGameDetailsByDomain(Domain.Math);
						break;
					case 2:
						games = Systems.selectGameDetailsByDomain(Domain.Science);
						break;
					case 3:
						games = Systems.selectGameDetailsByDomain(Domain.Chemistry);
						break;
					case 4:
						games = Systems.selectGameDetailsByDomain(Domain.Programming);
						break;
					}
					while (true) {
						System.out.println("\n\n\n\n\n\n");
						for (int i = 0; i < games.size(); i++)
							System.out.println((i + 1) + "." + games.get(i) + "\n\n");
						
						if (games.size() == 0) {
							System.out.println("No such games");
							break;
						}
						System.out.println("Game number: ");
						Game game = GameDB.loadGame(games.get(cin.nextInt() - 1).getGameID());
						GameController.establishGame(game);
						double score = game.showResults();
						Systems.getLoggedInUser().updateScore(score);
						
						System.out.println("press 1 to back");
						int temp = cin.nextInt();
						if (temp == 1)
							break;
					}
				}
				if (choice == 2) {
					System.out.println("Your score = " + Systems.getLoggedInUser().getScore());
				}
				if (choice == 3) {
				System.out.println(Systems.getLoggedInUser().showProfile());
				}
				if (choice == 4) {
					int c = 0;
					while (true) {
						System.out.println("1 for user name");
						System.out.println("2 for password");
						System.out.println("3 for email");
						System.out.println("4 for finish editing");
						System.out.println("enter num of your choice");
						c = cin.nextInt();
						cin.nextLine();
						switch (c) {
						case 1:
							System.out.println("enter new user name");
							Systems.getLoggedInUser().getAccount().setUserName(cin.nextLine());
							break;
						case 2:
							System.out.println("enter new password");
							Systems.getLoggedInUser().getAccount().setPassword(cin.nextLine());
							break;
						case 3:
							System.out.println("enter new email");
							Systems.getLoggedInUser().getAccount().setEmail(cin.nextLine());
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
				if (choice == 5) {
					Game newGame = new Game();
					newGame.createGame((Teacher)Systems.getLoggedInUser());
					GameDB.addGame(newGame);
					Systems.updateGamesFromDB();
				}
			}
		}
		cin.close();
	}

	public static void signIn() {
		boolean flag = false;
		String nameOrEmail = "", password = "";
		while (!flag) {
			System.out.print("\n\nUser Name or email: ");
			nameOrEmail = cin.next();

			System.out.print("\n\nPassword: ");
			password = cin.next();

			if (nameOrEmail.indexOf("@") != -1)
				flag = Systems.verifyLogInInfoByEmail(nameOrEmail, password);
			else
				flag = Systems.verifyLogInInfoByUserName(nameOrEmail, password);

			if (!flag) {
				System.out.println("wrong username or email\n press 1 to back");
				int choice = cin.nextInt();
				if (choice == 1)
					break;
			}
		}
		if (flag)
			Systems.setLoggedInUser(nameOrEmail, password);

		return;
	}

	public static void signUp() {
		System.out.println("1.Register as student");
		System.out.println("2.Register as teacher");

		int choice = cin.nextInt();
		
		boolean valid = UserController.createNewUser(choice);
		if (valid)
			System.out.println("\n\n\n welcome, your are registered now\n");
		
		return;
	}

		public static boolean getAccountInfo(Account account) {
		boolean flag = false;
		String name = "";
		System.out.print("User name: ");
		while (!flag) {
			name = cin.next();
			account.setUserName(name);
			flag = UserController.validateUserName(name);

			if (!flag) {
				System.out.println("Enter 1 to back or 2 to re-enter");
				int choice = cin.nextInt();
				if (choice == 1)
					return false;
			}
		}

		System.out.print("Password: ");
		account.setPassword(cin.next());

		System.out.print("Email: ");
		account.setEmail(cin.next());

		System.out.print("Birthdate in form d/m/y: ");
		String date = cin.next();
		int d, m, y;
		d = Integer.parseInt(date.substring(0, date.indexOf("/")));
		date = date.substring(date.indexOf("/") + 1);
		m = Integer.parseInt(date.substring(0, date.indexOf("/")));
		date = date.substring(date.indexOf("/") + 1);
		y = Integer.parseInt(date);

		account.setbirthdate(new Date(d, m, y));

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		date = dateFormat.format(cal.getTime());// kda ma3aya tare5 enhrda
												// f3leyan
		d = Integer.parseInt(date.substring(0, date.indexOf("/")));
		date = date.substring(date.indexOf("/") + 1);
		m = Integer.parseInt(date.substring(0, date.indexOf("/")));
		date = date.substring(date.indexOf("/") + 1);
		y = Integer.parseInt(date);

		account.setdateOfRegistration(new Date(d, m, y));

		return true;
	}

}
