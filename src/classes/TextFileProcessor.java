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
import java.util.HashMap;
import java.util.Scanner;

public class TextFileProcessor {
	
	private ArrayList<String> wordList = new ArrayList<String>();
	private HashMap<String,Integer> wordCounts = new HashMap<String,Integer>();
	
	public ArrayList<String> getWordList() {
		return wordList;
	}
	
	/*
	 * Reads a text file and creates a list of the individual words
	 * @param sourceFile - a valid file Path object
	 * requires one word per line in source file
	 */
	public void processFile(Path sourceFile) throws IOException {
		try (Scanner input = new Scanner(sourceFile)){
			while (input.hasNextLine()) {
				String temp = input.nextLine();
				temp = temp.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
				wordList.add(temp);
			}
			input.close();
		}
		catch (IOException e) {
			System.out.println("Unable to access that file.");
		}	
	}
	
	/*
	 * Iterates over wordlist, adding each word as a key in a HashMap
	 * if the word is already a key in the HashMap, increment the value
	 */
	public void countWords() {
		for (String s: wordList) {
			wordCounts.merge(s, 1, Integer::sum);
		}
	}

}
