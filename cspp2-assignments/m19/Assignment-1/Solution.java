import java.util.Scanner;

/**
 * Solution class for code-eval.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */

    List<Quiz> choiceObj = new List<Quiz>();
    public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        System.out.println(questionCount + "are added to the quiz");
        for (int i = 0; i < questionCount; i++) {
            String questionStr = s.nextLine();
            String[] check = questionStr.split(":");
            quiz.addAll(check);
            choiceObj.add(check[1]);

        }
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        for (int k = 0; k < quiz.size(); k++) {
            String answer = s.nextLine();
        }
        for (int i = 0; i < answerCount; i++) {
            System.out.println(quiz.get(i).getQuestion()+"(" + quiz.get(i).getMaxMarks()+")");
            String[] choices = choiceObj.get(i).getChoices().split(",");
            for ( int j =0 ; i<choices.size() - 1; j++) {
                System.out.print(choices[i]+"  ");
            }
            System.out.print(choices[size - 1]);
        }

    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        for (int i = 0; i < quiz.size(); i++) {
            System.out.println(quiz.get(i).getQuestion());

        }
    }
}
class Quiz {
    private String question;
    private String choices;
    private String correctAns;
    private int maxMarks;
    private int panalty;
    Quiz(final String q, final String c, final String cA, final int m, final int p) {
        this.question = q;
        this.correctAns = cA;
        this.maxMarks = m;
        this.panalty = p;
        this.choices = c;
}
    public String getQuestion() {
        return this.question;
    }
    public String getChoices() {
        return this.choices;
    }
    public String getCorrectAns() {
        return this.correctAns;
    }
    public int getMaxMarks() {
        return this.maxMarks;
    }
    public int getPanalty() {
        return this.panalty;
    }
    public int getScore() {


    }

}
