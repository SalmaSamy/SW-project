
public class GameResult {
	
	int numOfUsedHints ;
	int numOfRightAnswers ;
	int numOfQuestions;
	double dynamicScore ;
	
	void updateNumOfHints()
	{
		numOfUsedHints++ ;
	}
	
	void calculateScore( double score )
	{
		dynamicScore = score*(numOfRightAnswers/(numOfQuestions*1.0) ) ;
		dynamicScore = Math.max( dynamicScore-(numOfUsedHints*10) , 0 ) ; 
	}
	
	double getdynamicScore()
	{
		return dynamicScore ;
	}
	
	void addToAnswers( String rightAnswer , String userAnswer)
	{
		numOfQuestions++ ;
		if( userAnswer.equals(rightAnswer) )
			numOfRightAnswers++ ;
	}
}
