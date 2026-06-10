package main;

public class QuizQuestion {
    String Heading;
    String CodeSnippet;
    String CorrectAnswer;
    int TimeLimit;

    public QuizQuestion(String Heading, String CodeSnippet, String CorrectAnswer, int TimeLimit){
        this.Heading = Heading;
        this.CodeSnippet = CodeSnippet;
        this.CorrectAnswer = CorrectAnswer;
        this.TimeLimit = TimeLimit;
    }

    // Getters
    public String getHeading() {return Heading; }
    public String getCodeSnippet() {return CodeSnippet; }
    public String getCorrectAnswer() {return CorrectAnswer; }
    public int getTimeLimit() {return TimeLimit; }

}
