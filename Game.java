import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private GameDetails gameDetails ; 
	private GameResult gameResult;
	private ArrayList<Question> questions = new ArrayList<Question>() ; 	
 
	Game()
	{
		gameDetails = new GameDetails() ;
		gameResult = new GameResult() ;
	}
	
	public void createGame(Teacher teacher)
	{
		for(int i=0 ; i<gameDetails.getNumOfQuestions() ; i++)
		{
			this.addQuestion() ;
		}
	}
	
	public void addQuestion()
	{
		
		Question question ;
		if(gameDetails.getType().equals("MCQ"))
			question = new MCQ() ;
		else
			question = new TrueAndFalse() ;
		
			GameInterface.QuestionInfo(question , (gameDetails.getType().equals("MCQ") ? true : false ) ) ;
			
		questions.add(question) ;		
	}
	
	 public double getResults()
	{
		String result = "" ;
		gameResult.calculateScore(gameDetails.getScore());
		
		result += "Your Score " + gameResult.getdynamicScore() ;
		
		if(gameResult.getdynamicScore()/(gameDetails.getScore()*1.0) >= 0.5 )
		{
			result += "Congratulations! You Win" ;
			GameInterface.viewResult(result);
			return gameResult.getdynamicScore() ;
		}
		else
		{
			result += "You Lose, Try Again";
			GameInterface.viewResult(result);
		}
		
		return 0.0 ;
	}
	
	public GameDetails getGameDetails() {
		return gameDetails;
	}
	
	public ArrayList<Question> getGameQuestions() {
		return questions;
	}
	
	public GameResult getGameResult()
	{
		return gameResult ;
	}
	
	
}