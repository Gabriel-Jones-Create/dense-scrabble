import java.io.IOException;

/**
 * Represents word and its attributes with highest average scrabble score based
 * on processed text file
 * 
 * @author gabrieljones
 *
 */
public class DenseScrabble extends TextFileAccessor {
	// constants
	private final int[] SCRABBLE_SCORES = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 }; // constants of normal scrabble scores based on letters
	private final int ASCII_CODE_a = 97;// ASCII code value for lower case a variables
	private String winningWord;// holds String of the current winning word
	private double highscore; // holds decimal value of the highest current score
	private int lineNumber; // holds value of the current line number
	private int winningLineNumber;// holds the value of the current winning line number

	protected void processLine(String curLine) {
		String[] words = curLine.split(" "); // creates a words String array of the words in the input string by differentiating by spaces
		double[] scores = new double[words.length];// creates a decimal array of the scores of the words in the current line
		// for every word in the input, finds score and sets it to the respective index in the scores array
		for (int i = 0; i < words.length; i++) {
			char[] working = words[i].toLowerCase().toCharArray();
			int wordScore = 0;
			for (int j = 0; j < working.length; j++) {
				if (Character.isLetter(working[j])) {
					wordScore += SCRABBLE_SCORES[working[j] - ASCII_CODE_a];
				}
			}
			scores[i] = (double) wordScore / working.length;
		}
		double greatest = 0; // holds winning score of the words in that line
		int winningScoreIndex = 0; // holds index of the word with the highest score in that line
		/* for every score in the scores array, checks if that score is greater than the
		current greatest score, if it is then it sets that word to the winning word
		and that score to the winning score of that line*/
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] > greatest) {
				greatest = scores[i];
				winningScoreIndex = i;
			}
		}
		/*if the winning score of the line is greater than the overall current winning
		  score, then highscore is set to the greatest score, winning word is set to
		  the current winning word of the line, and the winning line number is set to
		  the current line iteration of the function.*/
		if (greatest > highscore) {
			highscore = greatest;
			winningWord = words[winningScoreIndex];
			winningLineNumber = lineNumber;
		}
		lineNumber++;
	}

	public void printReport() {
		System.out.println("winner: " + winningWord + "   score " + highscore + "   Line number: " + winningLineNumber);
	}

	/**
	 * Constructs a Dense Scrabble object based on file if the file name exists,
	 * otherwise throws IOException
	 * 
	 * @param filename name of the file
	 * @throws IOException if input file name does not exist
	 */
	public DenseScrabble(String filename) throws IOException {
		openFile(filename);
		highscore = 0;
		lineNumber = 1;
	}

}
