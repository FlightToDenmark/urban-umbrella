package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LCA11437 {

	static int N;
	static boolean[] visited;
	static int[] depth;
	static int[][] parent;
	static List<List<Integer>> adj;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		adj = new ArrayList<>();
		for (int n = 0; n <= N; n++) adj.add(new ArrayList<>());
		
		visited = new boolean[N + 1];
		depth = new int[N + 1];
		parent = new int[N + 1][17];

		StringTokenizer st;
		for (int n = 0; n < N - 1; n++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj.get(a).add(b);
			adj.get(b).add(a);
		}

		dfs(1, 1); // Make Tree
		fillParents();

		int M = Integer.parseInt(br.readLine());
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(lca(a, b));
		}

	}

	public static void dfs(int s, int d) {

		visited[s] = true;
		depth[s] = d;

		for (int to : adj.get(s)) {
			if (!visited[to]) {
				parent[to][0] = s;
				dfs(to, d + 1);
			}
		}

	}

	public static void fillParents() {

		for (int j = 1; j < 17; j++) {
			for (int i = 1; i <= N; i++) {
				parent[i][j] = parent[parent[i][j - 1]][j - 1];
			}
		}

	}

	public static int lca(int a, int b) {

		if (a == b)	return a;

		if (depth[b] > depth[a]) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		int H = 17;
		while (H-- > 0) {
			if (depth[a] - depth[b] >= (1 << H)) {
				a = parent[a][H];
			}
		}

		if (a == b)	return a;

		H = 17;
		while (H-- > 0) {
			if (parent[a][H] != parent[b][H]) {
				a = parent[a][H];
				b = parent[b][H];
			}
		}

		return parent[a][0];

	}

}
