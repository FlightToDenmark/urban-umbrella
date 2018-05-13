package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class RealBFS {

	static int N;
	static int path;
	static int before;
	static int[] dist, depth;
	static boolean[] visited;
	static int[][] parent;
	static List<List<Integer>> children;
	static Queue<Integer> Q;
	static final int H = 18;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			path = 0;
			visited = new boolean[N + 1];
			depth = new int[N + 1];
			dist = new int[N + 1];
			parent = new int[N + 1][H];
			Q = new LinkedList<>();
			children = new ArrayList<>();
			for (int n = 0; n <= N; n++) {
				children.add(new ArrayList<>());
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int n = 2; n <= N; n++) {
				children.get(Integer.parseInt(st.nextToken())).add(n);
			}
			dfs(1, 1, 0); // Make Tree (source, depth, distance from root)
			fillParents();
			Q.add(1);
			before = 1;
			bfs();
			System.out.println("#" + t + " " + path);

		}

	}

	static void dfs(int s, int d, int dd) {

		visited[s] = true;
		depth[s] = d;
		dist[s] = dd;

		for (int to : children.get(s)) {
			if (!visited[to]) {
				parent[to][0] = s;
				dfs(to, d + 1, dd + 1);
			}
		}

	}

	static void fillParents() {

		for (int j = 1; j < 18; j++) {
			for (int i = 1; i <= N; i++) {
				parent[i][j] = parent[parent[i][j - 1]][j - 1];
			}
		}

	}

	static int lca(int a, int b) {

		if (a == b)
			return a;

		if (depth[b] > depth[a]) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		int h = H;
		while (h-- > 0) {
			if (depth[a] - depth[b] >= (1 << h)) {
				a = parent[a][h];
			}
		}

		if (a == b)
			return a;

		h = H;
		while (h-- > 0) {
			if (parent[a][h] != parent[b][h]) {
				a = parent[a][h];
				b = parent[b][h];
			}
		}

		return parent[a][0];

	}

	static void bfs() {

		while (!Q.isEmpty()) {

			int here = Q.poll();

			path += dist[here] + dist[before] - 2 * dist[lca(here, before)];

			List<Integer> child = children.get(here);
			for (int c : child) {
				Q.add(c);
			}

			before = here;

		}

	}

}
