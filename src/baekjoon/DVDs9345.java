package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DVDs9345 {

	static final int INF = 1073741823;
	static int Q, A, B, N, K, T, size, tmp;
	static int[] dvd = new int[100000], min = new int[262145], max = new int[262145];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			treeInit();
			while (K-- > 0) {
				st = new StringTokenizer(br.readLine());
				Q = Integer.parseInt(st.nextToken());
				A = Integer.parseInt(st.nextToken());
				B = Integer.parseInt(st.nextToken());
				if (Q == 0) {
					tmp = dvd[A];
					dvd[A] = dvd[B];
					dvd[B] = tmp;
					update(A, dvd[A], min);
					update(B, dvd[B], min);
					update(A, -dvd[A], max);
					update(B, -dvd[B], max);
				} else {
					if (query(0, size - 1, 1, A, B, min) == A && -query(0, size - 1, 1, A, B, max) == B) {
						bw.write("YES\n");
					} else {
						bw.write("NO\n");
					}
				}
			}
		}
		bw.close();

	}

	static void treeInit() {

		size = 1;
		while (size < N) {
			size *= 2;
		}
		for (int i = 0; i < size * 2; i++) {
			min[i] = INF;
			max[i] = -INF;
		}
		for (int i = 0; i < N; i++) {
			dvd[i] = i;
			update(i, i, min);
			update(i, -i, max);
		}

	}

	static void update(int i, int value, int[] tree) {

		i += size;
		tree[i] = value;
		while (i > 1) {
			i >>= 1;
			tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
		}

	}

	static int query(int nodeL, int nodeR, int nodeIndex, int queryL, int queryR, int[] tree) {

		if (queryR < nodeL || nodeR < queryL) {
			return INF;
		}

		if (queryL <= nodeL && nodeR <= queryR) {
			return tree[nodeIndex];
		}

		int mid = (nodeL + nodeR) >> 1;
		return Math.min(query(nodeL, mid, nodeIndex * 2, queryL, queryR, tree),
				query(mid + 1, nodeR, nodeIndex * 2 + 1, queryL, queryR, tree));

	}

}
