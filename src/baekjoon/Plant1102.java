package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Plant1102 {

	static int N, P;
	static int[] cache;
	static int[][] cost;
	static char[] YN;
	static boolean findAnswer;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		cache = new int[1 << N];
		Arrays.fill(cache, -1);
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		YN = br.readLine().toCharArray();
		P = Integer.parseInt(br.readLine());
		if (P == 0) {
			System.out.println(0);
			System.exit(0);

		}
		int status = 0;
		for (int i = 0; i < N; i++) {
			if (YN[i] == 'Y') {
				status |= (1 << i);
			}
		}

		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			if (YN[i] == 'Y') {
				answer = Math.min(answer, dfs(i, status));
			}
		}
		System.out.println(findAnswer ? answer : "-1");

	}

	static int dfs(int here, int S) {

		if (Integer.bitCount(S) >= P) {
			findAnswer = true;
			return 0;
		}

		if (cache[S] != -1) {
			return cache[S];
		}

		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			if (YN[i] == 'N') {
				YN[i] = 'Y';
				answer = Math.min(answer, dfs(i, (S | (1 << i))) + findMinFor(i));
				YN[i] = 'N';
			}
		}

		return cache[S] = answer;

	}

	static int findMinFor(int here) {

		int price = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			if (i != here && YN[i] == 'Y') {
				price = Math.min(price, cost[i][here]);
			}
		}
		return price;

	}

}
