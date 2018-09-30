package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Processor1767 {

	static final int MAX = 99999;
	static int N;
	static int I, J;
	static int[][] cell;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			cell = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int answer = MAX;
			if (findCore()) {
				int i = I;
				int j = J;
				for (int d = 0; d < 4; d++) {
					answer = Math.min(answer, solve(i, j, d));
				}
			}
			System.out.println("#" + t + " " + answer);

		}

	}

	static int solve(int x, int y, int d) {

		int line = possible(x, y, d);
		if (line > 0) {
			cell[x][y] = -1;
		} else {
			return MAX;
		}

		int ret = MAX;
		int i, j;
		if (findCore()) {
			i = I;
			j = J;
			for (int dd = 0; dd < 4; dd++) {
				ret = Math.min(ret, solve(i, j, dd));
			}
		} else {
			restore(x, y, d);
			return line;
		}

		restore(x, y, d);
		return line + ret;

	}

	static boolean findCore() {

		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				if (cell[i][j] == 1) {
					I = i;
					J = j;
					return true;
				}
			}
		}

		return false;

	}

	static int possible(int x, int y, int d) {

		int line = 0;

		List<Integer> point = new ArrayList<>();
		if (d == 0) {
			for (int newY = y - 1; newY >= 0; newY--) {
				if (cell[x][newY] == 0) {
					point.add(newY);
					line++;
				} else {
					return -1;
				}
			}
			for (int newY : point) {
				cell[x][newY] = 2;
			}
		}

		if (d == 1) {
			for (int newX = x + 1; newX < N; newX++) {
				if (cell[newX][y] == 0) {
					point.add(newX);
					line++;
				} else {
					return -1;
				}
			}
			for (int newX : point) {
				cell[newX][y] = 2;
			}
		}

		if (d == 2) {
			for (int newY = y + 1; newY < N; newY++) {
				if (cell[x][newY] == 0) {
					point.add(newY);
					line++;
				} else {
					return -1;
				}
			}
			for (int newY : point) {
				cell[x][newY] = 2;
			}
		}

		if (d == 3) {
			for (int newX = x - 1; newX >= 0; newX--) {
				if (cell[newX][y] == 0) {
					point.add(newX);
					line++;
				} else {
					return -1;
				}
			}
			for (int newX : point) {
				cell[newX][y] = 2;
			}
		}

		return line;

	}

	static void restore(int x, int y, int d) {

		cell[x][y] = 1;

		if (d == 0) {
			for (int newY = y - 1; newY >= 0; newY--) {
				cell[x][newY] = 0;
			}
		}

		if (d == 1) {
			for (int newX = x + 1; newX < N; newX++) {
				cell[newX][y] = 0;
			}
		}

		if (d == 2) {
			for (int newY = y + 1; newY < N; newY++) {
				cell[x][newY] = 0;
			}
		}

		if (d == 3) {
			for (int newX = x - 1; newX >= 0; newX--) {
				cell[newX][y] = 0;
			}
		}

	}

}
