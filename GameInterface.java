import java.util.ArrayList;
import java.util.Scanner;

public class GameInterface {

	static Scanner cin = new Scanner(System.in);
	//static Game game = new Game();
	static void runGame(Game game) {
		GameResult GR = game.getGameResult();
		GR.clear();

		for (int i = 0; i < game.getGameDetails().getNumOfQuestions(); i++) {
			System.out.println("\n\n" + game.getGameQuestions().get(i).getQuestion() + "\n");
			String[] choices = game.getGameQuestions().get(i).getChoices();
			for (int j = 0; j < (game.getGameDetails().getType().equals("MCQ") ? 4 : 2); j++) {
				System.out.println((j + 1) + ". " + choices[j]);
			}
			System.out.print("Answer number: ");
			GR.addToAnswers(game.getGameQuestions().get(i).getRightAnswer(), choices[cin.nextInt() - 1]);
		}

	}

	static Game createGame(Teacher teacher) {
		 Game game = new Game();
		game.getGameDetails().setCreator(teacher);
		System.out.print("\nGame Name: ");
		game.getGameDetails().setName(cin.nextLine());
		System.out.print("Score: ");
		game.getGameDetails().setScore(cin.nextDouble()) ;
		System.out.print("Description: ");
		game.getGameDetails().setDescription(cin.nextLine());
		System.out.print("Resources: ");
		game.getGameDetails().setResource(cin.nextLine());
		
		System.out.println("\n1." + Domain.Math + "\n2." + Domain.Science);
		System.out.println("3." + Domain.Chemistry + "\n4." + Domain.Programming);
		System.out.print("Choose Domain Number: ");
		game.getGameDetails().setDomain(cin.nextInt());
		
		System.out.println("\n1.MCQ\n2.T/F\nChoose Type: ");
		if(cin.nextInt() == 1) game.getGameDetails().setType("MCQ");
		else game.getGameDetails().setType("T/F") ;
		
		System.out.print("Number Of Questions: ");
		game.getGameDetails().setNumOfQuestions(cin.nextInt());
		
		cin.nextLine();
		game.createGame(teacher);
		
		System.out.println(game.getGameDetails().getNumOfQuestions());
		System.out.println(game.getGameDetails().getName() + " Created");
		return game;
	}

	static void QuestionInfo(Question question, Boolean MCQ) {
		System.out.print("\n\nQuestion: ");
		question.setQuestion(cin.nextLine());
		System.out.print("The Right Answer: ");
		question.setRightAnswer(cin.nextLine());
		System.out.print("Hint: ");
		question.setHint(cin.nextLine());

		if (MCQ) {
			String[] answers = new String[4];
			System.out.println("Enter 4 answers: ");

			for (int i = 0; i < 4; i++) {
				System.out.print("1.  ");
				answers[i] = cin.nextLine();
			}

			question.setChoices(answers);
		}

	}

	static void editGame(Game game) {
		int check = 0;
		System.out.println(game.getGameDetails());

		while (check != 2) {
			for (int i = 0; i < game.getGameQuestions().size(); i++)
				System.out.println(i + ". " + game.getGameQuestions().get(i).getQuestion());

			System.out.println("Number of Question you want to edit");
			int index = cin.nextInt();
			cin.nextLine();

			game.addQuestion();

			game.getGameQuestions().set(index, game.getGameQuestions().get(game.getGameQuestions().size() - 1));
			game.getGameQuestions().remove(game.getGameQuestions().size() - 1);

			System.out.println("1.Wanna edit more question enter\n2.Done");
			check = cin.nextInt();
		}
	}

	static void viewResult(String result) {
		System.out.println(result);
	}
}
