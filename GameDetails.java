import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class GameDetails {

	private Teacher Creator;
	private Domain domain;
	private double score ; 
	private double rating , sumRating ;
	private DiffecultyLevel diffecultyLevel;
	private String name, Resource, Description , type;
	private int numOfRepots , gameID , numOfRates , numOfQuestions ; 
	private AtomicInteger count = new AtomicInteger(0); 
	
	Scanner cin = new Scanner(System.in) ;
	
	public GameDetails()
	{
		gameID = count.incrementAndGet() ;
	}
	
	public void reportAGame()
	{
		numOfRepots++ ;
	}
	public void fillGameDetails()
	{
		System.out.print("\nGame Name: ");
		setName(cin.nextLine());
		System.out.print("Score: ");
		setScore(cin.nextDouble()) ;
		System.out.print("Description: ");
		setDescription(cin.nextLine());
		System.out.print("Resources: ");
		setResource(cin.nextLine());
		
		System.out.println("\n1." + Domain.Math + "\n2." + Domain.Science);
		System.out.println("3." + Domain.Chemistry + "\n4." + Domain.Programming);
		System.out.print("Choose Domain Number: ");
		setDomain(cin.nextInt());
		
		System.out.println("\n1.MCQ\n2.T/F\nChoose Type: ");
		if(cin.nextInt() == 1) setType("MCQ");
		else setType("T/F") ;
		
		System.out.print("Number Of Questions: ");
		setNumOfQuestions(cin.nextInt());
		
		gameID = count.incrementAndGet(); 
	}
	public void updateRating(double rate) {
		
		numOfRates++ ;
		sumRating += rate ;
		this.rating = sumRating / (numOfRates*1.0) ;
	}
	
	public int getGameID() {
		return gameID;
	}
	public double getRating() {
		return rating;
	}
	
	public int getNumOfRepots() {
		return numOfRepots;
	}
	public void setNumOfRepots(int numOfRepots) {
		this.numOfRepots = numOfRepots;
	}
	
	public Teacher getCreator() {
		return Creator;
	}
	public void setCreator(Teacher creator) {
		Creator = creator;
	}
	
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(int num) {
		
		switch(num)
		{
			case 1 :
				domain = Domain.Math ;
				break ;
			case 2 :
				domain = Domain.Science ;
				break ;
			case 3 :
				domain = Domain.Chemistry ;
				break ;
			case 4 :
				domain = Domain.Programming ;
				break ;
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getResource() {
		return Resource;
	}
	public void setResource(String resource) {
		Resource = resource;
	}
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}	
	
	public DiffecultyLevel getDiffecultyLevel() {
		return diffecultyLevel;
	}
	public void setDiffecultyLevel(DiffecultyLevel diffecultyLevel) {
		this.diffecultyLevel = diffecultyLevel;
	}
	
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	public int getNumOfQuestions() {
		return numOfQuestions;
	}
	public void setNumOfQuestions(int numOfQuestions) {
		this.numOfQuestions = numOfQuestions;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return name + ":\n\nCreator: " + Creator + "\nScore: " + score + "\nDomain: " + domain
				+ "\nResource: " + Resource + "\nDescription: " + Description + "\nRating: " + rating
				+ "\nDiffecultyLevel: " + diffecultyLevel ;
	}

}
