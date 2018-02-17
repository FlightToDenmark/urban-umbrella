package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fenwick2042 {

	public static int N;
	public static long[] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int K = Integer.parseInt(st1.nextToken());
		long[] num = new long[N + 1];
		tree = new long[N + 1];
		for (int n = 1; n <= N; n++) {
			update(n, num[n] = Integer.parseInt(br.readLine()));
		}

		for (int i = 1; i <= M + K; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			if (a == 1) {
				int b = Integer.parseInt(st2.nextToken());
				long c = Long.parseLong(st2.nextToken());
				update(b, c - num[b]);
				num[b] = c;
			} else {
				int b = Integer.parseInt(st2.nextToken());
				int c = Integer.parseInt(st2.nextToken());
				System.out.println(sum(c) - sum(b-1));
			}
		}

		br.close();

	}

	public static long sum(int i) {

		long ans = 0;

		while (i > 0) {
			ans += tree[i];
			i -= (i & -i);
		}

		return ans;

	}

	public static void update(int i, long num) {

		while (i <= N) {
			tree[i] += num;
			i += (i & -i);
		}

	}

}
