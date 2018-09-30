package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Candy2243 {

	static int SIZE = 1048576;
	static int[] tree = new int[SIZE * 2];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int a, b, c, ret;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if (a == 1) {
				System.out.println(ret = query(1, b - 1));
				update(SIZE + ret, -1);
			} else {
				c = Integer.parseInt(st.nextToken());
				update(SIZE + b, c);
			}
		}

	}

	static int query(int node, int k) {

		if (node >= SIZE) return node - SIZE;

		int pivot = tree[2 * node];
		if (k < pivot) return query(2 * node, k);
		else return query(2 * node + 1, k - pivot);

	}

	static void update(int i, int val) {

		tree[i] += val;
		while (i > 1) {
			i = i / 2;
			tree[i] = tree[2 * i] + tree[2 * i + 1];
		}

	}

}
