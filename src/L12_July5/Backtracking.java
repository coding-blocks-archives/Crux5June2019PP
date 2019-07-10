package L12_July5;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 05-Jul-2019
 *
 */

public class Backtracking {

	static int count;

	public static void main(String[] args) {

		// QueenPermutation(new boolean[4], 0, 2, "");
		// QueenCombination(new boolean[4], 0, 3, "", -1);

		// coinChange(new int[] { 2, 3, 5, 6 }, 10, "", 0);
		// QueenCombinationBoxRespect(new boolean[4], 0, 0, 2, "");

		// QueenCombination2D(new boolean[4][4], 0, 0, 0, 3, "");

		// int[][] maze = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0
		// } };
		// blockedMaze(maze, 0, 0, "", new boolean[maze.length][maze[0].length]);

		char[][] arr = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		String word = "SEE";

		boolean ans = false;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == word.charAt(0)) {
					ans = ans || searchWord(arr, i, j, word, 0, new boolean[arr.length][arr[0].length]);

				}
			}
		}

		System.out.println(ans);

	}

	public static void QueenPermutation(boolean[] board, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(++count + ". " + ans);
			return;
		}
		for (int i = 0; i < board.length; i++) {

			if (board[i] == false) {
				board[i] = true;
				QueenPermutation(board, qpsf + 1, tq, ans + "q" + qpsf + "b" + i + " ");
				board[i] = false; // undo
			}

		}

	}

	public static void QueenCombination(boolean[] board, int qpsf, int tq, String ans, int lastBoxUsed) {

		if (qpsf == tq) {
			System.out.println(++count + ". " + ans);
			return;
		}

		for (int i = lastBoxUsed + 1; i < board.length; i++) {

			board[i] = true;
			QueenCombination(board, qpsf + 1, tq, ans + "q" + qpsf + "b" + i + " ", i);
			board[i] = false; // undo

		}

	}

	public static void coinChange(int[] denom, int amount, String ans, int lastCoinUsedIdx) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		if (amount < 0) {
			return;
		}

		for (int i = lastCoinUsedIdx; i < denom.length; i++) {
			coinChange(denom, amount - denom[i], ans + denom[i], i);
		}

	}

	public static void QueenCombinationBoxRespect(boolean[] board, int col, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}

		if (col == board.length) {
			return;
		}

		// yes
		board[col] = true;
		QueenCombinationBoxRespect(board, col + 1, qpsf + 1, tq, ans + "b" + col);
		board[col] = false;

		// no
		QueenCombinationBoxRespect(board, col + 1, qpsf, tq, ans);

	}

	public static void QueenCombination2D(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(++count + " " + ans);
			return;
		}

		if (col == board[0].length) {
			row = row + 1;
			col = 0;
		}

		if (row == board.length) {
			return;
		}

		// yes
		if (isItSafeToPlaceQueen(board, row, col)) {
			board[row][col] = true;
			QueenCombination2D(board, row, col + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
			board[row][col] = false;
		}

		// no
		QueenCombination2D(board, row, col + 1, qpsf, tq, ans);

	}

	public static boolean isItSafeToPlaceQueen(boolean[][] board, int row, int col) {

		// vertically up
		int r = row - 1;
		int c = col;

		while (r >= 0) {
			if (board[r][c]) {
				return false;
			}

			r--;
		}

		// horozontally left
		r = row;
		c = col - 1;

		while (c >= 0) {
			if (board[r][c]) {
				return false;
			}

			c--;
		}

		// diagonally left
		r = row - 1;
		c = col - 1;

		while (r >= 0 && c >= 0) {
			if (board[r][c]) {
				return false;
			}

			r--;
			c--;

		}

		// diagonally right
		r = row - 1;
		c = col + 1;

		while (r >= 0 && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}

			r--;
			c++;

		}

		return true;

	}

	public static void blockedMaze(int[][] maze, int row, int col, String ans, boolean[][] visited) {

		if (row == maze.length - 1 && col == maze[0].length - 1) {
			System.out.println(ans);
			return;
		}

		if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || visited[row][col]
				|| maze[row][col] == 1) {
			return;
		}

		visited[row][col] = true;

		// B
		blockedMaze(maze, row + 1, col, ans + "B", visited);

		// T
		blockedMaze(maze, row - 1, col, ans + "T", visited);

		// L
		blockedMaze(maze, row, col - 1, ans + "L", visited);

		// R
		blockedMaze(maze, row, col + 1, ans + "R", visited);

		visited[row][col] = false;

	}

	public static boolean searchWord(char[][] arr, int row, int col, String word, int idx, boolean[][] visited) {

		if (idx == word.length()) {
			return true;
		}

		if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || visited[row][col]) {
			return false;
		}

		if (arr[row][col] != word.charAt(idx)) {
			return false;
		}

		visited[row][col] = true;

		// T
		boolean t = searchWord(arr, row - 1, col, word, idx + 1, visited);

		// L
		boolean l = searchWord(arr, row, col - 1, word, idx + 1, visited);

		// R
		boolean r = searchWord(arr, row, col + 1, word, idx + 1, visited);

		// B
		boolean b = searchWord(arr, row + 1, col, word, idx + 1, visited);

		visited[row][col] = false;

		return t || l || r || b;
	}

}
