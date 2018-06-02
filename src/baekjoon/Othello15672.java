package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Othello15672 {

	static char[][] board = {
			{ '#', '#', '#', '#', '#', '#', '#' }, { '#', '.', '.', '.', '.', '.', '.' },
			{ '#', '.', '.', '.', '.', '.', '.' }, { '#', '.', '.', 'W', 'B', '.', '.' },
			{ '#', '.', '.', 'B', 'W', '.', '.' }, { '#', '.', '.', '.', '.', '.', '.' },
			{ '#', '.', '.', '.', '.', '.', '.' } };

	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int row, col;
		StringTokenizer st;
		for (int n = 0; n < N; n++) {
			
			st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			
			if (n % 2 == 0)
				board[row][col] = 'B';
			else
				board[row][col] = 'W';

			for (int d = 0; d < 8; d++) {

				int rNow = row;
				int cNow = col;

				List<PointA> list = new ArrayList<>();

				while (true) {
					rNow += dx[d];
					cNow += dy[d];

					if (rNow < 1 || cNow < 1 || rNow > 6 || cNow > 6) break;

					if (board[rNow][cNow] == '.') break;
					
					if (board[rNow][cNow] != board[row][col]) {
						list.add(new PointA(rNow, cNow));
						continue;
					}
					if (board[rNow][cNow] == board[row][col]) {
						for (PointA p : list) {
							board[p.x][p.y] = board[row][col];
						}
						break;
					}
				}

			}

		}

		for (int r = 1; r <= 6; r++) {
			for (int c = 1; c <= 6; c++) {
				System.out.print(board[r][c]);
			}
			System.out.println();
		}

		int white = 0;
		int black = 0;
		for (int r = 1; r <= 6; r++) {
			for (int c = 1; c <= 6; c++) {
				if (board[r][c] == 'W')	white++;
				if (board[r][c] == 'B')	black++;
			}
		}

		if (white > black) System.out.println("White");
		else System.out.println("Black");

	}

}

class PointA {

	int x, y;

	public PointA(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}
