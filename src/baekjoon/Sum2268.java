package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum2268 {

	static int N, M;
	static int[] A;
	static long[] tree;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N + 1];
		tree = new long[N + 1];

		int i, j;
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("0")) {
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				System.out.println((i < j) ? (sum(j) - sum(i - 1)) : (sum(i) - sum(j - 1)));
			} else {
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				update(i, j - A[i]);
				A[i] = j;
			}
		}

	}

	static void update(int i, int num) {

		while (i <= N) {
			tree[i] += num;
			i += (i & -i);
		}

	}

	static long sum(int i) {

		long ret = 0;

		while (i > 0) {
			ret += tree[i];
			i -= (i & -i);
		}

		return ret;
	}

}
