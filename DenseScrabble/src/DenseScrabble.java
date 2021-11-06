import java.io.IOException;

public class DenseScrabble extends TextFileAccessor {
	//constants
	private final int[] SCRABBLE_SCORES = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
	private final int ASCII_CODE_a = 97;
	//variables
	private String winningWord;
	private double highscore;
	private int lineNumber;
	private int winningLineNumber;
	protected void processLine(String curLine) {
		String[] words = curLine.split(" ");
		double[] scores = new double[words.length];
		for(int i = 0 ; i < words.length; i++) {
			char[] working = words[i].toLowerCase().toCharArray();
			int wordScore = 0;
			for(int j = 0 ; j < working.length; j++) {
				if(Character.isLetter(working[j])) {
					wordScore += SCRABBLE_SCORES[working[j]-ASCII_CODE_a];
				}
			}
			scores[i] = (double)wordScore/working.length;
		}
		double greatest = 0;
		int winningScoreIndex = 0;
		for( int i = 0; i < scores.length; i++){
			if(scores[i] > greatest) {
				greatest = scores[i];
				winningScoreIndex = i;
			}
		}
		if(greatest > highscore) {
			highscore = greatest;
			winningWord = words[winningScoreIndex];
			winningLineNumber = lineNumber;
		}
		lineNumber++;
	}
	public void printReport() {
		//System.out.println(winningWord + " " + highscore + " " + winningLineNumber);
		System.out.println("winner: " + winningWord + "   score " + highscore + "   Line number: "+ winningLineNumber);
	}
	
	public DenseScrabble(String filename) throws IOException {
		openFile(filename);
		// TODO: initialize variables in constructor
		highscore = 0;
		lineNumber = 1;
	}
	
	
}
