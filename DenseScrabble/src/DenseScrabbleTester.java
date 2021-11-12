import java.util.Scanner;

/**
 * If given a text file, run Dense Scrabble and find the word with the highest
 * average scrabble score based on normal scrabble rules, then print that word,
 * that word's average score, and the line number it appears on.
 * 
 * @author gabrieljones
 *
 */
public class DenseScrabbleTester {
	public static void main(String args[]) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("enter file name");
			String filename = scanner.next();
			DenseScrabble scrabble = new DenseScrabble(filename);
			scrabble.processFile();
			scrabble.printReport();
			scanner.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
