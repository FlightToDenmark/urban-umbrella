package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MagicStar3967 {

	static char[] S = new char[12];
	static boolean[] A = new boolean[12];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] t = new char[5][];
		int idx = 0;
		for (int row = 0; row < 5; row++) {
			t[row] = br.readLine().toCharArray();
			for (int col = 0; col < 9; col++) {
				if (t[row][col] != '.') {
					S[idx++] = t[row][col];
					if (t[row][col] != 'x') {
						A[t[row][col] - 65] = true;
					}
				}
			}
		}

		fill(0);

		idx = 0;
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 9; col++) {
				if (t[row][col] != '.') {
					t[row][col] = S[idx++];
				}
				System.out.print(t[row][col]);
			}
			System.out.println();
		}

	}

	static boolean fill(int i) {

		if (i == 12) {
			return true;
		}

		if (S[i] != 'x') {
			return fill(i + 1);
		}

		for (int j = 0; j < 12; j++) {
			if (!A[j]) {
				A[j] = true;
				S[i] = (char) (j + 65);
				if (!sumOver() || !fill(i + 1)) {
					A[j] = false;
					S[i] = 'x';
				} else {
					return true;
				}
			}
		}

		return false;

	}

	static boolean sumCheck() {

		return (S[0] + S[2] + S[5] + S[7] == 282) && (S[0] + S[3] + S[6] + S[10] == 282)
				&& (S[1] + S[2] + S[3] + S[4] == 282) && (S[1] + S[5] + S[8] + S[11] == 282)
				&& (S[4] + S[6] + S[9] + S[11] == 282) && (S[7] + S[8] + S[9] + S[10] == 282);

	}

	static boolean sumOver() {

		if (S[0] != 120 && S[2] != 120 && S[5] != 120 && S[7] != 120) {
			if (S[0] + S[2] + S[5] + S[7] != 282) {
				return false;
			}
		}

		if (S[0] != 120 && S[3] != 120 && S[6] != 120 && S[10] != 120) {
			if (S[0] + S[3] + S[6] + S[10] != 282) {
				return false;
			}
		}

		if (S[1] != 120 && S[2] != 120 && S[3] != 120 && S[4] != 120) {
			if (S[1] + S[2] + S[3] + S[4] != 282) {
				return false;
			}
		}

		if (S[1] != 120 && S[5] != 120 && S[8] != 120 && S[11] != 120) {
			if (S[1] + S[5] + S[8] + S[11] != 282) {
				return false;
			}
		}

		if (S[4] != 120 && S[6] != 120 && S[9] != 120 && S[11] != 120) {
			if (S[4] + S[6] + S[9] + S[11] != 282) {
				return false;
			}
		}

		if (S[7] != 120 && S[8] != 120 && S[9] != 120 && S[10] != 120) {
			if (S[7] + S[8] + S[9] + S[10] != 282) {
				return false;
			}
		}

		return true;

	}

}
