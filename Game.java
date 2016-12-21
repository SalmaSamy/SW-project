import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private GameDetails gameDetails ; 
	private GameResult gameResult;
	private ArrayList<Question> questions = new ArrayList<Question>() ; 	
	Scanner cin = new Scanner(System.in) ;
 
	Game()
	{
		gameDetails = new GameDetails() ;
		gameResult = new GameResult() ;
	}
	
	public void runGame()
	{
		gameResult = new GameResult() ; 
		for(int i=0 ; i<gameDetails.getNumOfQuestions() ; i++)
		{
			System.out.println("\n\n" + questions.get(i).getQuestion()+"\n");
			String[] choices = questions.get(i).getChoices() ;
			for(int j=0 ; j<( gameDetails.getType().equals("MCQ") ? 4 : 2 ) ; j++)
			{
				System.out.println((j+1) + ". " + choices[j]);
			}
			System.out.print("Answer number: ");
			gameResult.addToAnswers(questions.get(i).getRightAnswer(), choices[cin.nextInt()]);
		}
		
	}
	
	public void editGame()
	{   
		int check =0 ; 
		System.out.println(gameDetails);
		
		while(check != 2){
			for(int i=0 ; i <questions.size() ; i++)
				System.out.println(i+". "+questions.get(i).getQuestion());
			
		System.out.println("Number of Question you want to edit");
		int index= cin.nextInt();
		cin.nextLine();
		
        this.addQuestion();
        
        questions.set(index,questions.get(questions.size()-1));
        questions.remove(questions.size()-1);
		System.out.println("Wanna edit more question enter 1 \n skip enter2");
		   check= cin.nextInt();
	   }
	}
	
	public void createGame(Teacher teacher)
	{
		gameDetails.setCreator(teacher);
		gameDetails.fillGameDetails() ;
		
		for(int i=0 ; i<gameDetails.getNumOfQuestions() ; i++)
		{
			this.addQuestion() ;
		}
		System.out.println(gameDetails.getNumOfQuestions());
		System.out.println(gameDetails.getName() + " Created");
	}
	
	public void addQuestion()
	{
		
		Question question ;
		if(gameDetails.getType().equals("MCQ"))
			question = new MCQ() ;
		else
			question = new TrueAndFalse() ;
		
		System.out.print("\n\nQuestion: ");
		question.setQuestion(cin.nextLine());
		System.out.print("The Right Answer: ");
		question.setRightAnswer(cin.nextLine());
		System.out.print("Hint: ");
		question.setHint(cin.nextLine());
		
		
		if(gameDetails.getType().equals("MCQ"))
		{
			String[] answers = new String[4] ;
			System.out.println("Enter 4 answers: ");
			
			for(int i=0  ; i<4 ; i++)
			{
				System.out.print("1.  ");
				answers[i] = cin.nextLine() ;
			}
			
			question.setChoices(answers) ;
		}
		
		questions.add(question) ;		
	}
	
	double showResults()
	{
		gameResult.calculateScore(gameDetails.getScore());
		
		System.out.println("Your Score " + gameResult.getdynamicScore() ) ;
		
		if(gameResult.getdynamicScore()/(gameDetails.getScore()*1.0) >= 0.5 )
		{
			System.out.println("Congratulations! You Win");
			return gameResult.getdynamicScore() ;
		}
		else
		{
			System.out.println("You Lose, Try Again");
		}
		
		return 0.0 ;
	}
	
	public GameDetails getGameDetails() {
		return gameDetails;
	}
	
	
}
