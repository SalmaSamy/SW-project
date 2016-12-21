import java.util.ArrayList;

public class GameDB {
	
	static ArrayList<Game> listOfGames = new ArrayList<Game>() ; 
	
	static Game loadGame( int gameID )
	{
		for(int i=0 ; i<listOfGames.size() ; i++)
		{
			if( listOfGames.get(i).getGameDetails().getGameID() == gameID)
				return listOfGames.get(i) ;
		}
		return null ;
	}
	
	static ArrayList<GameDetails> loadGamesDetails()
	{
		ArrayList<GameDetails> GD = new ArrayList<GameDetails>() ;
		
		for(int i=0 ; i<listOfGames.size() ; i++)
		{
			GD.add(listOfGames.get(i).getGameDetails()) ;
		}
		return GD ;
		
	}
	
	static void updateGameRating( int gameID , double rate )
	{
		//DB
	}
	
	static void deleteGame(Game game)
	{
		listOfGames.remove(game) ;
	}
	
	static void addGame(Game game)
	{
		listOfGames.add(game) ;
	}

}
