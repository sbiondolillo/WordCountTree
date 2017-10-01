/*
 * TextNode Class
 * Samuel Biondolillo
 * CIS210M:ZZ Data Structures and Elementary Algorithms
 * Goal: To create a class to allow Nodes to hold a String value
 * Version  0.0.1   10/1/17
 */

package classes;

public class TextNode extends Node {
	
	private String text;
	
	public TextNode(int value, String text) {
		super(value);
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	/*
	 * Provide a readable format for printing Nodes
	 */
	@Override
	public String toString() {
		String output = "";
		output += (this.getLeftChild() == null) ? "X-": ((TextNode) this.getLeftChild()).getText() + "-";
		output += text + "-";
		output += (this.getRightChild() == null) ? "X\n": ((TextNode) this.getRightChild()).getText() + "\n";
		return output;
	}

}
