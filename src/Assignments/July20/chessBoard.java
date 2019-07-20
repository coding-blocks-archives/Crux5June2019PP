package may28;

import java.util.Arrays;

public class chessBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] charray = fillArray(3);
		System.out.println(board1(charray, 0, 0, 2, 2, ""));

	}

	public static char[][] fillArray(int n) {

		boolean[] primes = new boolean[(n * n) + 1];

		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;

		for (int table = 2; table * table < primes.length; table++) {

			if (!primes[table])
				continue;

			for (int mult = 2; mult * table < primes.length; mult++) {

				primes[table * mult] = false;
			}
		}

		char[][] charray = new char[n][n];
		int cnt = 1;
		boolean isMine = true;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (primes[cnt]) {

					if (isMine) {
						charray[i][j] = 'M';
					} else {
						charray[i][j] = 'P';
					}

					isMine = !isMine;

				} else {
					charray[i][j] = 'R';
				}

				cnt++;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(charray[i][j] + " ");
			}
			System.out.println();
		}

		return charray;

	}

	public static int board1(char[][] board, int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans + "{" + cr + "-" + cc + "} ");
			return 1;
		}

		if (cr > er || cc > ec || board[cr][cc] == 'M') {
			return 0;
		}
		int cnt = 0;

		if (board[cr][cc] == 'P') {
			cnt += board1(board, er, ec, er, ec, ans + "{" + cr + "-" + cc + "}P");
		}

		// knight
		cnt += board1(board, cr + 2, cc + 1, er, ec, ans + "{" + cr + "-" + cc + "}K");
		cnt += board1(board, cr + 1, cc + 2, er, ec, ans + "{" + cr + "-" + cc + "}K");

		// Rook

		if (cr == 0 || cc == 0 || cr == er || cc == ec) {

			for (int i = 1; i <= ec; i++)
				cnt += board1(board, cr, cc + i, er, ec, ans + "{" + cr + "-" + cc + "}R");

			for (int i = 1; i <= er; i++)
				cnt += board1(board, cr + i, cc, er, ec, ans + "{" + cr + "-" + cc + "}R");
		}
		// Bishop

		if (cr == cc || cr + cc == er) {
			for (int i = 1; i <= er && i <= ec; i++) {
				cnt += board1(board, cr + i, cc + i, er, ec, ans + "{" + cr + "-" + cc + "}B");
			}
		}

		return cnt;
	}

}
