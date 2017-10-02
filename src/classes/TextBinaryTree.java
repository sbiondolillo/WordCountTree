/*
 * TextBinaryTree Class
 * Samuel Biondolillo
 * CIS210M:ZZ Data Structures and Elementary Algorithms
 * Goal: To create a special class which models a Binary Search Tree
 *       with TextNodes which hold an ArrayList<String>
 * Version  0.0.1   10/1/17
 */

package classes;

import java.util.ArrayList;

public class TextBinaryTree extends BinaryTree {
	
	private ArrayList<TextNode> nodes = new ArrayList<TextNode>();
	private TextNode root = null;
	
	/*
	 * Adds a node to the tree if there is an empty place
	 * adds the node's text to the tree if there is an existing node with the same value
	 * @param node - any valid TextNode with a single word in the words ArrayList
	 */
	public void add(TextNode node) {
		// store off the current word for appending in case of collisions
		String word = node.getWords().get(0);
		// if there isn't a root yet, add the node and set it as root
		if (this.root == null) {
			this.nodes.add(node);
			this.root = node;
		} 
		else {
			// start at the root
			TextNode currentNode = this.root;
			// traverse the tree making comparisons
			while (true) {
				// greater than
				if (node.getValue() > currentNode.getValue()) {
					// if there is an existing right child, move the pointer
					if (currentNode.hasRightChild()) {
						currentNode = (TextNode) currentNode.getRightChild();
						continue;
					} 
					// set this node as the right child
					else {
						currentNode.setRightChild(node);
						this.nodes.add(node);
						break;
					}
				}
				// less than
				else if (node.getValue() < currentNode.getValue()) {
					// if there is an existing left child, move the pointer
					if (currentNode.hasLeftChild()) {
						currentNode = (TextNode) currentNode.getLeftChild();
						continue;
					} 
					// set this node as the left child
					else {
						currentNode.setLeftChild(node);
						this.nodes.add(node);
						break;
					}
				}
				// equal
				else {
					// add the word to the existing list
					currentNode.append(word);
					break;
				}
			}
		}
	}

	/*
	 * Provide a readable format for printing to console
	 */
	@Override
	public String toString() {
		String output = "";
		output += "Root at Node #" + this.nodes.indexOf(root) + "\n";
		for (int i = 0; i < nodes.size(); i++) {
			output += "Node #" + i + ": ";
			output += nodes.get(i);
			output += "\n";
		}
		return output;
	}
	
}
