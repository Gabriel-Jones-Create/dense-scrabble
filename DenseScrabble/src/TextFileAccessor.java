import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;

/**
 * Provides a template for accessing files
 * 
 * @author gabrieljones
 *
 */
public abstract class TextFileAccessor {
	protected String fileName;
	protected Scanner scan;

	/**
	 * Opens a file and throws an IOException if the file cannot open
	 * 
	 * @param fn the file name
	 * @throws IOException if can't open file
	 */
	public void openFile(String fn) throws IOException {
		fileName = fn;
		scan = new Scanner(new FileReader(fileName));
	}

	/**
	 * Processes file by scanning each line
	 */
	public void processFile() {
		while (scan.hasNext()) {
			processLine(scan.nextLine());
		}
		scan.close();
	}

	/**
	 * Processes a line with the string line from the file
	 * 
	 * @param line the String line from a file
	 */
	protected abstract void processLine(String line);

	/**
	 * Prints the report for a given file
	 */
	public abstract void printReport();

}
