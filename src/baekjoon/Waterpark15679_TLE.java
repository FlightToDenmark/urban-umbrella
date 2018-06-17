package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Waterpark15679_TLE {

	static int N, D;
	static int[] K;
	static long[] cache;
	static final int MIN = -1111111111;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = new int[N];
		cache = new long[N];
		Arrays.fill(cache, MIN);

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++)
			K[n] = Integer.parseInt(st.nextToken());

		long max = MIN;
		for (int n = 0; n < N; n++) {
			long answer = solve(n);
			if (answer > max)
				max = answer;
		}
		System.out.println(max);

	}

	static long solve(int start) {

		if (start >= N)
			return 0;

		if (cache[start] != MIN)
			return cache[start];

		long answer = MIN;
		for (int d = 1; d <= D; d++)
			answer = Math.max(answer, K[start] + solve(start + d));

		return cache[start] = answer;

	}

}
