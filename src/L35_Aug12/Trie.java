package L35_Aug12;

import java.util.HashMap;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Aug-2019
 *
 */

public class Trie {

	private class Node {
		char ch;
		boolean eow;
		HashMap<Character, Node> table = new HashMap<>();

		public Node(char ch) {
			this.ch = ch;
		}
	}

	private Node root;

	public Trie() {
		root = new Node('*');
	}

	public void addWord(String word) {
		addWord(root, word);
	}

	private void addWord(Node node, String word) {

		if (word.length() == 0) {
			node.eow = true;
			return;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		if (node.table.containsKey(ch)) {
			Node child = node.table.get(ch);
			addWord(child, row);
		} else {
			Node child = new Node(ch);
			node.table.put(ch, child);

			addWord(child, row);
		}

	}

	public void display() {
		System.out.println("-------------------------");
		display(root, "");
		System.out.println("-------------------------");
	}

	private void display(Node node, String ans) {

		if (node.eow) {
			System.out.println(ans);
		}

		for (char ch : node.table.keySet()) {
			Node child = node.table.get(ch);
			display(child, ans + ch);
		}

	}

	public boolean searchWord(String word) {
		return searchWord(root, word);
	}

	private boolean searchWord(Node node, String word) {

		if (word.length() == 0) {
			return node.eow;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		if (node.table.containsKey(ch)) {
			Node child = node.table.get(ch);
			return searchWord(child, row);
		} else {
			return false;
		}

	}

	public boolean startsWith(String word) {
		return startsWith(root, word);
	}

	private boolean startsWith(Node node, String word) {

		if (word.length() == 0) {
			return true;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		if (node.table.containsKey(ch)) {
			Node child = node.table.get(ch);
			return startsWith(child, row);
		} else {
			return false;
		}

	}

	public void removeWord(String word) {
		removeWord(root, word);
	}

	private void removeWord(Node node, String word) {

		if (word.length() == 0) {
			node.eow = false;
			return;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		if (node.table.containsKey(ch)) {
			Node child = node.table.get(ch);
			removeWord(child, row);

			if (child.eow == false && child.table.size() == 0) {
				node.table.remove(ch);
			}
		} else {
			return;
		}

	}

}
