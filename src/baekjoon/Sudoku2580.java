package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sudoku2580 {

	public static int I, J;
	public static final int NINE = 9;
	public static int[][] S = new int[NINE][NINE];
	public static boolean[][] row = new boolean[NINE][NINE + 1];
	public static boolean[][] col = new boolean[NINE][NINE + 1];
	public static boolean[][] sqr = new boolean[NINE][NINE + 1];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < NINE; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < NINE; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
				if (S[i][j] == 0) continue;
				row[i][S[i][j]] = true;
				col[j][S[i][j]] = true;
				sqr[(i / 3) * 3 + (j / 3)][S[i][j]] = true;
			}
		}

		fill();
		print();

	}

	public static boolean fill() {

		if (isComplete()) return true;

		int i = I;
		int j = J;

		for (int num = 1; num <= 9; num++) {
			if (!row[i][num] && !col[j][num] && !sqr[(i / 3) * 3 + (j / 3)][num]) {
				putNumber(i, j, num);
				if (fill()) return true;
				removeNumber(i, j, num);
			}
		}
		return false;

	}

	public static void putNumber(int i, int j, int num) {

		row[i][num] = true;
		col[j][num] = true;
		sqr[(i / 3) * 3 + (j / 3)][num] = true;
		S[i][j] = num;

	}

	public static void removeNumber(int i, int j, int num) {

		row[i][num] = false;
		col[j][num] = false;
		sqr[(i / 3) * 3 + (j / 3)][num] = false;
		S[i][j] = 0;

	}

	public static boolean isComplete() {

		for (int i = 0; i < NINE; i++) {
			for (int j = 0; j < NINE; j++) {
				if (S[i][j] == 0) {
					I = i;
					J = j;
					return false;
				}
			}
		}
		return true;

	}

	public static void print() {

		for (int i = 0; i < NINE; i++) {
			for (int j = 0; j < NINE; j++) {
				System.out.print(S[i][j] + " ");
			}
			System.out.println();
		}

	}

}
