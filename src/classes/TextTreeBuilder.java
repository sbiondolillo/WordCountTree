/*
 * TextTreeBuilder Class
 * Samuel Biondolillo
 * CIS210M - Data Structures and Elementary Algorithms
 * Goal - create a class to build a tree of TextNodes from a HashMap<String,Integer>
 * Version 	0.0.1	10/1/17
 */

package classes;

import java.util.ArrayList;
import java.util.HashMap;

public class TextTreeBuilder {

	private TextBinaryTree bTextTree = new TextBinaryTree();
	private HashMap<String,Integer> map = null;
	
	/*
	 * Constructor
	 * @param map - any valid HashMap mapping Strings to Integers
	 */
	public TextTreeBuilder(HashMap<String,Integer> map) {
		this.map = map;
	}
	
	/*
	 * Getter for instance variable
	 */
	public TextBinaryTree getTextTree() {
		return bTextTree;
	}
	
	/*
	 * Builds up the bTextTree starting with the most common word
	 */
	public void buildTree() {
		while (map.size() > 0) {
			// identify a node with the maximum value
			TextNode first = this.findMaxValue(map);
			// add it so we have it as the root
			bTextTree.add(first);
			// remove it from map so we don't have to check it again
			map.remove(first.getWords().get(0));
		}
	}
	/*
	 * Identifies the maximum value in a HashMap and creates a 
	 * TextNode base on that key,value pair
	 * @param map - the HashMap<String,Integer> to be searched
	 */
	private TextNode findMaxValue(HashMap<String,Integer> map) {
		// find the maximum value
		int maxValue = 0;
		String maxString = "";
		for (String key: map.keySet()) {
			if (map.get(key) > maxValue) {
				maxValue = map.get(key);
				maxString = key;
			}
		}
		// use the value to build a TextNode
		ArrayList<String> maxArray = new ArrayList<String>();
		maxArray.add(maxString);
		return new TextNode(maxValue,maxArray);
	}
	
}
