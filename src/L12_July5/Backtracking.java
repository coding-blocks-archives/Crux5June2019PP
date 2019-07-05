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

		QueenCombination2D(new boolean[2][2], 0, 0, 0, 2, "");
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
		board[row][col] = true;
		QueenCombination2D(board, row, col + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
		board[row][col] = false;

		// no
		QueenCombination2D(board, row, col + 1, qpsf, tq, ans);

	}

}
