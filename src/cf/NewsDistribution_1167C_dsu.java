import java.io.*;
import java.util.*;

public class Main {

	static int N, M, K;
	static int[] group, parent, rank;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		group = new int[N + 1];
		parent = new int[N + 1];
		rank = new int[N + 1];
		for (int n = 1; n <= N; n++) {
			parent[n] = n;
			rank[n] = 1;
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			for (int k = 0; k < K; k++) {
				group[k] = Integer.parseInt(st.nextToken());
			}
			for (int k = 1; k < K; k++) {
				union(group[k - 1], group[k]);
			}
		}
		for (int n = 1; n <= N; n++) {
			bw.write(rank[find(n)] + " ");
		}
		bw.newLine();
		bw.close();

	}

	static void union(int a, int b) {

		a = find(a);
		b = find(b);

		if (a == b) {
			return;
		}

		if (rank[b] > rank[a]) {
			a ^= b;
			b ^= a;
			a ^= b;
		}
		parent[b] = a;
		rank[a] += rank[b];

	}

	static int find(int x) {

		if (x == parent[x]) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}

	}

}
