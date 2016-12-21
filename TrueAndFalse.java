
public class TrueAndFalse extends Question {
	
	String[] choices;
	
	TrueAndFalse()
	{
		choices = new String[2] ;
		choices[0] = "" + T_F.True ;
		choices[1] = "" + T_F.False ;
	}
	
	String[] getChoices()
	{
		return choices ;
	}

}
