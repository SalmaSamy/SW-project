
public class Question {

	private String question ;
	private String rightAnswer ;
	private String hint ;
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getRightAnswer() {
		return rightAnswer;
	}
	
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	
	public String getHint() {
		return hint;
	}
	
	public void setHint(String hint) {
		this.hint = hint;
	}
	
	void setChoices( String[] choices ){}
	
	String[] getChoices(){
		String[] s = new String[0];
		return s ;
	}
	
}
