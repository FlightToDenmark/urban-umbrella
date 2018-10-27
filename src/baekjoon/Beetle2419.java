package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beetle2419 {

	static int N, M;
	static int[] candy;
	static int[][][] cache;
	static final int LEFT = 0, RIGHT = 1;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		candy = new int[N + 1];
		cache = new int[N + 1][N + 1][2];
		candy[0] = 0;
		for (int n = 1; n <= N; n++) {
			candy[n] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(candy);
		int start = 0;
		for (int n = 0; n <= N; n++) {
			if (candy[n] == 0) {
				start = n;
				break;
			}
		}
		int answer = Integer.MIN_VALUE;
		for (int n = 0; n <= N; n++) {
			memset();
			answer = Math.max(answer, n * M - solve(start, start, LEFT, n));
		}
		System.out.println(answer);

	}

	static int solve(int L, int R, int direction, int total) {

		if (total == 0) {
			return 0;
		}

		if (cache[L][R][direction] != -1) {
			return cache[L][R][direction];
		}

		int toLeft = Integer.MAX_VALUE, toRight = Integer.MAX_VALUE;
		int distance = 0;

		if (L > 0) {
			distance = ((direction == LEFT) ? candy[L] : candy[R]) - candy[L - 1];
			toLeft = solve(L - 1, R, LEFT, total - 1) + distance * total;
		}

		if (R < N) {
			distance = candy[R + 1] - ((direction == LEFT) ? candy[L] : candy[R]);
			toRight = solve(L, R + 1, RIGHT, total - 1) + distance * total;
		}

		return cache[L][R][direction] = Math.min(toLeft, toRight);

	}

	static void memset() {

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				for (int k = 0; k <= 1; k++) {
					cache[i][j][k] = -1;
				}
			}
		}

	}

}
