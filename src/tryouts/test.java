package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1014 {

	static final int O = 46, X = 120;
	static int N, M;
	static int[] map;
	static int[][] cache;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[] line;
		map = new int[N * M + 1];
		cache = new int[N * M + 1][1 << (M + 1)];
		for (int n = 0; n < N; n++) {
			line = br.readLine().toCharArray();
			for (int m = 1; m <= M; m++) {
				map[n * M + m] = (line[m - 1] == O) ? 0 : 1;
			}
		}

		int S = 0;
		for (int i = N * M; i > (N - 1) * M; i--) {
			S += (1 << (N * M - i + 1));
		}
		int answer = 0;
		answer = Math.max(answer, solve(M * N, S));
		System.out.println(answer);

	}

	static int solve(int here, int S) {

		if (here <= 0) {
			return 0;
		}

		if (cache[here][S] != 0) {
			return cache[here][S];
		}

		int answer = solve(here - 1, S >> 1); // here 선택 X. 여기가 막혀있든 아니든.
		if (map[here] == 0 && (S & 1) == 0) { // 여기가 열려있다면
			if (here % M == 0) {
				S = (S >> 2) + (1 << M);
			} else if (here % M == 1) {
				S = (S >> 2) + (1 << (M - 2));
			} else {
				S = (S >> 2) + (1 << (M - 2)) + (1 << M);
			}
			answer = Math.max(answer, solve(here - 2, S) + 1); // here 선택 O
		}
		return cache[here][S] = answer;

	}

}
