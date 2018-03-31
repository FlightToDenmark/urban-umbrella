package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BricksGame {

	public static int N;
	public static long[] brick, sum, cache;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {

			N = Integer.parseInt(br.readLine());
			brick = new long[N];
			sum = new long[N];
			cache = new long[N];
			Arrays.fill(cache, -1);

			StringTokenizer st = new StringTokenizer(br.readLine());

			long s = 0;
			for (int n = 0; n < N; n++) {
				brick[n] = Long.parseLong(st.nextToken());
				s += brick[n];
			}

			sum[0] = s;
			for (int n = 1; n < N; n++) {
				sum[n] = sum[n - 1] - brick[n - 1];
			}

			System.out.println(myTurn(0));

		}

	}

	public static long myTurn(int index) {

		if (index > N - 1) return 0;

		if (cache[index] != -1)	return cache[index];

		long max = 0;
		for (int r = 1; r <= 3; r++) {
			long point = sum[index] - myTurn(index + r);
			if (point > max) max = point;
		}

		return cache[index] = max;

	}

}
