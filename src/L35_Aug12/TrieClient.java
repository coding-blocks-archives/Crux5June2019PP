package L35_Aug12;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Aug-2019
 *
 */

public class TrieClient {

	public static void main(String[] args) {

		// Trie trie = new Trie();
		// trie.addWord("arc");
		// trie.addWord("and");
		// trie.addWord("an");
		// trie.addWord("sea");
		// trie.addWord("seen");
		// trie.addWord("see");
		//
		// System.out.println(trie.searchWord("an"));
		// System.out.println(trie.startsWith("b"));
		//
		// trie.display();
		// trie.removeWord("seen");
		// trie.removeWord("see");
		// trie.display();

		ArrayList<String> list = new ArrayList<>();
		list.add("oath");
		list.add("pea");
		list.add("thf");
		list.add("eat");

		char[][] carr = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };

		SearchWord(carr, list);

	}

	// https://leetcode.com/problems/word-search-ii/
	public static void SearchWord(char[][] arr, ArrayList<String> list) {

		Trie trie = new Trie();

		for (String val : list) {
			trie.addWord(val);
		}

		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				SearchWord(arr, list, new boolean[arr.length][arr[0].length], i, j, "", set, trie);
			}
		}

		System.out.println(set);

	}

	private static void SearchWord(char[][] arr, ArrayList<String> list, boolean[][] visited, int row, int col,
			String ans, HashSet<String> set, Trie trie) {

		if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || visited[row][col]) {
			return;
		}

		if (!trie.startsWith(ans)) {
			return;
		}

		if (trie.searchWord(ans)) {
			set.add(ans);
		}

		visited[row][col] = true;

		SearchWord(arr, list, visited, row + 1, col, ans + arr[row][col], set, trie);
		SearchWord(arr, list, visited, row - 1, col, ans + arr[row][col], set, trie);
		SearchWord(arr, list, visited, row, col - 1, ans + arr[row][col], set, trie);
		SearchWord(arr, list, visited, row, col + 1, ans + arr[row][col], set, trie);

		visited[row][col] = false;

	}

}
