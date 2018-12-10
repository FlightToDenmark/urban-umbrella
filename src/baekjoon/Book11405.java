package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Book11405 {

	static final int INF = 987654321;
	static int N, M, V;
	static int SOURCE, SINK;
	static int[][] C, D, F;
	static List<Integer>[] adj;
	static int[] prev, dist;
	static boolean[] inQ;
	static Queue<Integer> queue;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = N + M;
		SINK = V + 1;
		C = new int[V + 2][V + 2];
		D = new int[V + 2][V + 2];
		F = new int[V + 2][V + 2];
		adj = new ArrayList[V + 2];
		prev = new int[V + 2];
		dist = new int[V + 2];
		inQ = new boolean[V + 2];
		for (int i = 0; i < V + 2; i++) {
			adj[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		for (int n = M + 1; n <= V; n++) {
			C[n][SINK] = Integer.parseInt(st.nextToken());
			adj[n].add(SINK);
			adj[SINK].add(n);
		}
		st = new StringTokenizer(br.readLine());
		for (int m = 1; m <= M; m++) {
			C[SOURCE][m] = Integer.parseInt(st.nextToken());
			adj[m].add(SOURCE);
			adj[SOURCE].add(m);
		}
		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			for (int n = M + 1; n <= V; n++) {
				D[m][n] = Integer.parseInt(st.nextToken());
				D[n][m] = -D[m][n];
				C[m][n] = INF;
				adj[m].add(n);
				adj[n].add(m);
			}
		}

		int answer = 0;
		while (true) {
			Arrays.fill(prev, -1);
			Arrays.fill(dist, INF);
			Arrays.fill(inQ, false);
			queue = new LinkedList<>();

			dist[SOURCE] = 0;
			inQ[SOURCE] = true;
			queue.add(SOURCE);

			while (!queue.isEmpty()) {
				int here = queue.poll();
				inQ[here] = false;
				for (int next : adj[here]) {
					if (C[here][next] - F[here][next] > 0 && dist[next] > dist[here] + D[here][next]) {
						dist[next] = dist[here] + D[here][next];
						prev[next] = here;
						if (!inQ[next]) {
							queue.add(next);
							inQ[next] = true;
						}
					}
				}
			}
			if (prev[SINK] == -1) {
				break;
			}

			int flow = INF;
			for (int i = SINK; i != SOURCE; i = prev[i]) {
				flow = Math.min(flow, C[prev[i]][i] - F[prev[i]][i]);
			}

			for (int i = SINK; i != SOURCE; i = prev[i]) {
				answer += flow * D[prev[i]][i];
				F[prev[i]][i] += flow;
				F[i][prev[i]] -= flow;
			}
		}
		System.out.println(answer);

	}

}
