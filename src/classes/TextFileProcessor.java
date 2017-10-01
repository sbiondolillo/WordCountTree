/*
 * TextFileProcessor Class
 * Samuel Biondolillo
 * CIS210M - Data Structures and Elementary Algorithms
 * Goal - build a class to turn a text file into a list of strings
 * Version	0.0.1	10/1/17
 */

package classes;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileProcessor {
	
	private ArrayList<String> wordList;
	
	public void processFile(Path sourceFile) throws IOException {
		try {
			Scanner input = new Scanner(sourceFile);
			while (input.hasNextLine()) {
				wordList.add(input.nextLine());
			}
			input.close();
		}
		catch (IOException e) {
			System.out.println("Unable to access that file.");
		}	
	}

}
