/*
 * TestWordCountTree Class
 * Samuel Biondolillo
 * CIS210M - Data Structures and Elementary Algorithms
 * Goal - build a class to test our program
 * Version	0.0.1	10/1/17
 */

package classes;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TestWordCountTree {

	public static void main(String[] args) throws IOException {
		// Set up a new processor
		TextFileProcessor tfp = new TextFileProcessor();
		
		// Get a file from the user
		Scanner input = new Scanner(System.in);
		System.out.println("Please specify a file path:");
		String fileName = input.nextLine();
		System.out.println("Processing...");
		Path filePath = Paths.get(fileName);
		
		// process the file and display the result
		tfp.processFile(filePath);
		System.out.println(tfp.getWordList());
		
		// count the words and display the result
		tfp.countWords();
		System.out.println(tfp.getWordCounts());
		
		// put the words in a tree and display the result
		TextTreeBuilder ttb = new TextTreeBuilder(tfp.getWordCounts());
		System.out.println(ttb.getTextTree());

	}

}
