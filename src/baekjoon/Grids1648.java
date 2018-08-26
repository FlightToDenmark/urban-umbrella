package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Grids1648 {

	static int N, M;
	static int total;
	static int[][] cache = new int[14 * 14][1 << 14];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		total = N * M;
		for (int[] c : cache) {
			Arrays.fill(c, -1);
		}
		System.out.println(solve(0, 0));

	}

	static int solve(int A, int S) {

		if (A == total && S == 0) {
			return 1;
		}

		if (A >= total) {
			return 0;
		}
		
		if (cache[A][S] != -1) {
			return cache[A][S];
		}

		int answer;

		if ((S & 1) == 1) {
			answer = solve(A + 1, S >> 1);
		} else {
			answer = solve(A + 1, (S >> 1) | (1 << M - 1));
			if ((S & 2) == 0 && (A % M) != M - 1) {
				answer += solve(A + 2, S >> 2);
			}
		}

		return cache[A][S] = answer % 9901;

	}

}
