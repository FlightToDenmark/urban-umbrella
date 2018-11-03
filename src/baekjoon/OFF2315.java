package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OFF2315 {

	static int N, M, sum;
	static int[] D, W;
	static int[][][] cache;
	static final int LEFT = 0, RIGHT = 1;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = new int[N + 1];
		W = new int[N + 1];
		cache = new int[N + 1][N + 1][2];
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			D[n] = Integer.parseInt(st.nextToken());
			sum += W[n] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solve(M, M, LEFT, sum));

	}

	static int solve(int L, int R, int direction, int total) {

		if (L == 1 && R == N) {
			return 0;
		}

		if (cache[L][R][direction] != 0) {
			return cache[L][R][direction];
		}

		int ret = Integer.MAX_VALUE;
		int here = (direction == LEFT) ? L : R;
		if (L > 1) {
			ret = Math.min(ret, solve(L - 1, R, LEFT, total - W[here]) + (D[here] - D[L - 1]) * (total - W[here]));
		}
		if (R < N) {
			ret = Math.min(ret, solve(L, R + 1, RIGHT, total - W[here]) + (D[R + 1] - D[here]) * (total - W[here]));
		}

		return cache[L][R][direction] = ret;

	}

}
