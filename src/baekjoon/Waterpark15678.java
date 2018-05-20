package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Waterpark15678 {

	static int N, D;
	static int[] K;
	static long[] cache;
	static final int MIN = -1111111111;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = new int[N + 1];
		cache = new long[N + 1];
		Arrays.fill(cache, MIN);

		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++)
			K[n] = Integer.parseInt(st.nextToken());

		System.out.println(solve(0));

	}

	static long solve(int start) {

		if (start > N)
			return 0;

		if (cache[start] != MIN)
			return cache[start];

		long answer = MIN;
		for (int d = 1; d <= D; d++)
			answer = Math.max(answer, K[start] + solve(start + d));

		return cache[start] = answer;

	}

}
