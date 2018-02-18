package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MeasureTime {

	public static long[] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {

			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st1.nextToken());
			int[] num = new int[N];
			tree = new long[1000001];
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++)
				num[n] = Integer.parseInt(st2.nextToken());

			System.out.println(countMoves(num));

		}

	}

	public static long sum(int i) {

		long ans = 0;
		
		while (i > 0) {
			ans += tree[i];
			i -= (i & -i);
		}
		
		return ans;

	}

	public static void update(int i, int num) {

		while (i <= tree.length) {
			tree[i] += num;
			i += (i & -i);
		}

	}

	public static long countMoves(int[] A) {

		long ret = 0;

		for (int i = 0; i < A.length; i++) {
			ret += sum(999999) - sum(A[i]);
			update(A[i], 1);
		}

		return ret;

	}

}
