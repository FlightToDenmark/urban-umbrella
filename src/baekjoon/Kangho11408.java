package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Kangho11408 {

	static int N, M, V, SOURCE, SINK;
	static int[][] C, D, F;
	static List<Integer>[] adj;
	static int[] dist, prev;
	static boolean[] inQ;
	static final int INF = 987654321;
	static Queue<Integer> Q;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = N + M + 2;
		SINK = N + M + 1;
		C = new int[V][V];
		D = new int[V][V];
		F = new int[V][V];
		dist = new int[V];
		prev = new int[V];
		inQ = new boolean[V];
		adj = new ArrayList[V];
		adj[SOURCE] = new ArrayList<>();
		adj[SINK] = new ArrayList<>();
		Q = new LinkedList<>();
		int work, num, pay;
		for (int m = N + 1; m <= N + M; m++) {
			adj[m] = new ArrayList<>();
			adj[m].add(SINK);
			adj[SINK].add(m);
			C[m][SINK] = 1;
		}
		for (int n = 1; n <= N; n++) {
			adj[n] = new ArrayList<>();
			adj[SOURCE].add(n);
			adj[n].add(SOURCE);
			C[SOURCE][n] = 1;
			st = new StringTokenizer(br.readLine());
			work = Integer.parseInt(st.nextToken());
			for (int w = 0; w < work; w++) {
				num = N + Integer.parseInt(st.nextToken());
				pay = Integer.parseInt(st.nextToken());
				adj[n].add(num);
				adj[num].add(n);
				C[n][num] = 1;
				D[n][num] = pay;
				D[num][n] = -pay;
			}
		}

		int answer = 0, total = 0;
		while (true) {
			Arrays.fill(dist, INF);
			Arrays.fill(prev, -1);
			Arrays.fill(inQ, false);
			Q.clear();
			dist[SOURCE] = 0;
			inQ[SOURCE] = true;
			Q.add(SOURCE);

			while (!Q.isEmpty()) {
				int here = Q.poll();
				inQ[here] = false;
				for (int next : adj[here]) {
					if (C[here][next] - F[here][next] > 0 && dist[next] > dist[here] + D[here][next]) {
						dist[next] = dist[here] + D[here][next];
						prev[next] = here;
						if (!inQ[next]) {
							inQ[next] = true;
							Q.add(next);
						}
					}
				}
			}
			if (prev[SINK] == -1) {
				break;
			}

			for (int i = SINK; i != SOURCE; i = prev[i]) {
				F[prev[i]][i]++;
				F[i][prev[i]]--;
				answer += D[prev[i]][i];
			}
			total++;

		}

		System.out.printf("%d\n%d\n", total, answer);

	}

}
