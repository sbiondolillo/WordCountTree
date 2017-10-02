/*
 * TextNode Class
 * Samuel Biondolillo
 * CIS210M:ZZ Data Structures and Elementary Algorithms
 * Goal: To create a class to allow Nodes to hold a String value
 * Version  0.0.1   10/1/17
 */

package classes;

import java.util.ArrayList;

public class TextNode extends Node {
	
	private ArrayList<String> words = new ArrayList<String>();
	
	/*
	 * Constructor
	 * @value - any valid int
	 * @text - any valid ArrayList<String>
	 */
	public TextNode(int value, ArrayList<String> words) {
		super(value);
		this.words = words;
	}
	
	/*
	 * Getter for instance variable
	 */
	public ArrayList<String> getWords() {
		return words;
	}

	/*
	 * Add a word to the node's words array
	 * @param newWord - any valid String
	 */
	public void append(String newWord) {
		words.add(newWord);
	}
	
	/*
	 * Provide a readable format for printing TextNodes
	 */
	@Override
	public String toString() {
		String output = "";
		output += (this.getLeftChild() == null) ? "X-": ((TextNode) this.getLeftChild()).getWords() + "-";
		/*for ( String word: words ) {
			output += word + "-";
		}*/
		output += words + "-";
		output += (this.getRightChild() == null) ? "X\n": ((TextNode) this.getRightChild()).getWords() + "\n";
		return output;
	}

}
