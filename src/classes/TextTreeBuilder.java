/*
 * TextTreeBuilder Class
 * Samuel Biondolillo
 * CIS210M - Data Structures and Elementary Algorithms
 * Goal - create a class to build a tree of TextNodes from a HashMap<String,Integer>
 * Version 	0.0.1	10/1/17
 */

package classes;

import java.util.HashMap;

public class TextTreeBuilder {

	private BinaryTree textTree = new BinaryTree();
	
	public BinaryTree getTextTree() {
		return textTree;
	}
	
	public TextTreeBuilder(HashMap<String,Integer> map) {
		for (String key: map.keySet()) {
			textTree.add(new TextNode(map.get(key), key));
		}
	}
}
