package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Security4243 {

	static int N;
	static final int LEFT = 0, RIGHT = 1;
	static long[] sumR = new long[101];
	static long[][][] memo = new long[102][102][2];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			int S = Integer.parseInt(br.readLine());
			Arrays.fill(sumR, 0);
			for (long[][] square : memo) {
				for (long[] line : square) {
					Arrays.fill(line, -1);
				}
			}
			for (int n = 2; n <= N; n++) {
				sumR[n] = sumR[n - 1] + Integer.parseInt(br.readLine());
			}
			System.out.println(solve(S, S, LEFT));
		}

	}

	static long solve(int L, int R, int direction) {

		if (memo[L][R][direction] != -1)
			return memo[L][R][direction];

		if (L == 1 && R == N)
			return 0;

		long ret = Long.MAX_VALUE;

		if (L > 1)
			ret = Math.min(ret,	solve(L - 1, R, LEFT) + (sumR[(direction == LEFT) ? L : R] - sumR[L - 1]) * (N - R + L - 1));

		if (R < N)
			ret = Math.min(ret,	solve(L, R + 1, RIGHT) + (sumR[R + 1] - sumR[(direction == LEFT) ? L : R]) * (N - R + L - 1));

		return memo[L][R][direction] = ret;

	}

}
