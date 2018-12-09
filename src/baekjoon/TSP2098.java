package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TSP2098 {

	static int N;
	static int[][] cost, cache;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		cache = new int[N][1 << N];
		for (int[] c : cache) {
			Arrays.fill(c, -1);
		}
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(dfs(0, (1 << 0)));

	}

	static int dfs(int here, int S) {

		if (S == (1 << N) - 1) {
			if (cost[here][0] > 0) {
				return cost[here][0];
			} else {
				return Integer.MAX_VALUE / 2;
			}
		}

		if (cache[here][S] != -1) {
			return cache[here][S];
		}

		int answer = Integer.MAX_VALUE / 2;
		for (int to = 0; to < N; to++) {
			if ((S & (1 << to)) == 0 && cost[here][to] > 0) {
				answer = Math.min(answer, dfs(to, S | (1 << to)) + cost[here][to]);
			}
		}
		return cache[here][S] = answer;

	}

}
