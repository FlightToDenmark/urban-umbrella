package baekjoon;

import java.io.*;
import java.util.*;

public class MegaInversions5012 {

	static final int MAX = 100000, size = 131072;
	static int N;
	static int[] input, tree, a, b;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		input = new int[N + 1];
		a = new int[N + 1];
		b = new int[N + 1];
		tree = new int[262145];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			input[n] = Integer.parseInt(st.nextToken());
		}
		for (int n = 1; n <= N; n++) {
			a[n] = sum(MAX) - sum(input[n]);
			update(input[n]);
		}
		Arrays.fill(tree, 0);
		for (int n = N; n >= 1; n--) {
			b[n] = sum(input[n] - 1);
			update(input[n]);
		}
		long answer = 0;
		for (int n = 1; n <= N; n++) {
			answer += (long) a[n] * b[n];
		}
		bw.write(answer + "\n");
		bw.close();

	}

	static int query(int nodeL, int nodeR, int nodeIndex, int queryL, int queryR) {

		if (queryR < nodeL || nodeR < queryL) {
			return 0;
		}

		if (queryL <= nodeL && nodeR <= queryR) {
			return tree[nodeIndex];
		}

		int mid = (nodeL + nodeR) >> 1;
		return query(nodeL, mid, nodeIndex * 2, queryL, queryR)
				+ query(mid + 1, nodeR, nodeIndex * 2 + 1, queryL, queryR);

	}

	static int sum(int i) {

		int ans = 0;
		while (i > 0) {
			ans += tree[i];
			i -= (i & -i);
		}
		return ans;

	}

	static void update(int i) {

		while (i <= MAX) {
			tree[i] += 1;
			i += (i & -i);
		}

	}

	static void update(int index, int value) {

		index += size;
		tree[index] += value;
		while (index > 1) {
			index >>= 1;
			tree[index] = tree[index * 2] + tree[index * 2 + 1];
		}

	}

}
