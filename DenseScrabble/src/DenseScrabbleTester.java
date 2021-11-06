import java.util.Scanner;

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
