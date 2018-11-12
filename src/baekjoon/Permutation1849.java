package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Permutation1849 {

	static int N, size;
	static int[] tree, A;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		init();
		A = new int[N];
		int ret = 0;
		for (int n = 1; n <= N; n++) {
			ret = query(1, Integer.parseInt(br.readLine()));
			update(ret, 0);
			A[ret] = n;
		}
		for (int n = 0; n < N; n++) {
			bw.write(A[n] + "\n");
		}
		bw.flush();

	}

	static void init() {
		size = 1;
		while (size < N) {
			size *= 2;
		}
		tree = new int[size*2];
		for (int i = 0; i < size; i++) {
			update(i, 1);
		}
	}

	static void update(int i, int value) {
		i += size;
		tree[i] = value;
		while (i > 1) {
			i /= 2;
			tree[i] = tree[2 * i] + tree[2 * i + 1];
		}
	}

	static int query(int node, int k) {

		if (node >= size) {
			return node - size;
		}
		int pivot = tree[2*node];
		if (k < pivot) {
			return query(2 * node, k);
		} else {
			return query(2 * node + 1, k - pivot);
		}

	}

}
