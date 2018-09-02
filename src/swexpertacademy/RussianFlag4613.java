package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RussianFlag4613 {

	static final int W = 0, B = 1, R = 2;
	static int N, M;
	static char[][] board = new char[50][50];
	static int[][] memo = new int[50][3]; // color
	static int[][] cache = new int[50][3]; // DP

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= testCase; t++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			for (int[] cache : memo) {
				Arrays.fill(cache, 0);
			}

			for (int[] memo : cache) {
				Arrays.fill(memo, -1);
			}

			for (int n = 0; n < N; n++) {

				board[n] = br.readLine().toCharArray();

				for (int m = 0; m < M; m++) {
					if (board[n][m] == 'W') {
						memo[n][W]++;
					} else if (board[n][m] == 'B') {
						memo[n][B]++;
					} else if (board[n][m] == 'R') {
						memo[n][R]++;
					}
				}
			}

			System.out.println("#" + t + " " + solve(0, 0));

		}

	}

	static int solve(int row, int color) { // 0: W, 1: B, 2: R

		if (cache[row][color] != -1) {
			return cache[row][color];
		}

		int answer = M - memo[row][color];

		if (row == N - 1) {
			if (color == R) {
				return cache[row][color] = M - memo[row][R];
			} else {
				return cache[row][color] = 99999;
			}
		}

		if (color == W) {
			answer += Math.min(solve(row + 1, W), solve(row + 1, B));
		}

		if (color == B) {
			answer += Math.min(solve(row + 1, B), solve(row + 1, R));
		}

		if (color == R) {
			for (int r = row + 1; r < N; r++) {
				answer += M - memo[r][R];
			}
		}

		return cache[row][color] = answer;

	}

}
