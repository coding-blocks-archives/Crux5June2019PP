package Assignments.July20;

import java.util.Arrays;

public class ChessBoard2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] ch = fillArray(3);
		int cnt = chessBoard2(ch, 0, 0, "");

		System.out.println();
		System.out.print(cnt);

	}

	public static char[][] fillArray(int n) {

		boolean[] primes = new boolean[(n * n) + 1];

		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;

		for (int table = 2; table * table <= n * n; table++) {

			if (!primes[table])
				continue;
			for (int mult = 2; mult * table <= n * n; mult++) {

				primes[table * mult] = false;
			}
		}

		int cnt = 1;
		boolean isMine = true;
		char[][] ch = new char[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (primes[cnt]) {

					if (isMine) {
						ch[i][j] = 'M';
					} else {
						ch[i][j] = 'P';
					}

					isMine = !isMine;
				} else {
					ch[i][j] = 'R';
				}

				cnt++;
			}
		}

		return ch;
	}

	public static int chessBoard2(char[][] board, int cr, int cc, String ans) {

		if (cr == board.length - 1 && cc == board[0].length - 1) {
			System.out.print(ans + "{" + cr + "-" + cc + "} ");
			return 1;
		}

		if (cr < 0 || cr >= board.length || cc < 0 || cc >= board[0].length || board[cr][cc] == 'M') {
			return 0;
		}

		int cnt = 0;

		String temp = ans + "{" + cr + "-" + cc + "}P";

		if (board[cr][cc] == 'P') {
			cnt += chessBoard2(board, board.length - 1, board[0].length - 1, ans + "{" + cr + "-" + cc + "}P");

		}

		temp = ans + "{" + cr + "-" + cc + "}K";
		cnt += chessBoard2(board, cr + 2, cc + 1, temp);
		cnt += chessBoard2(board, cr + 1, cc + 2, temp);

		if (cr == 0 || cc == 0 || cr == board.length - 1 || cc == board[0].length - 1) {

			for (int moves = 1; moves + cc < board[0].length; moves++) {

				temp = ans + "{" + cr + "-" + cc + "}R";
				cnt += chessBoard2(board, cr, cc + moves, temp);
			}

			for (int moves = 1; moves + cr < board.length; moves++) {

				temp = ans + "{" + cr + "-" + cc + "}R";
				cnt += chessBoard2(board, cr + moves, cc, temp);
			}

		}

		if (cr == cc || cr + cc == board.length) {
			for (int moves = 1; moves + cr < board.length && moves + cc < board[0].length; moves++) {

				temp = ans + "{" + cr + "-" + cc + "}B";
				cnt += chessBoard2(board, cr + moves, cc + moves, temp);
			}

		}

		return cnt;
	}

}
