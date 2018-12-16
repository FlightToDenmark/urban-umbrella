package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ShortestPaths1753_SPFA {

	static final int INF = 987654321;
	static int V, E, K;
	static int[] D;
	static boolean[] inQ;
	static List<PP>[] adj;
	static Queue<Integer> Q;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		adj = new LinkedList[V + 1];
		D = new int[V + 1];
		inQ = new boolean[V + 1];
		Q = new LinkedList<>();
		for (int v = 0; v <= V; v++) {
			adj[v] = new LinkedList<>();
			D[v] = INF;
		}
		int from, to, dist;
		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			dist = Integer.parseInt(st.nextToken());
			adj[from].add(new PP(to, dist));
		}

		Q.add(K);
		inQ[K] = true;
		D[K] = 0;

		while (!Q.isEmpty()) {

			int here = Q.poll();
			inQ[here] = false;

			for (PP next : adj[here]) {
				to = next.to;
				dist = next.dist;
				if (D[to] > D[here] + dist) {
					D[to] = D[here] + dist;
					if (!inQ[to]) {
						Q.add(to);
						inQ[to] = true;
					}
				}
			}

		}
				
		for (int v = 1; v <= V; v++) {
			if (D[v] >= INF) {
				bw.write("INF\n");
			} else {
				bw.write(D[v] + "\n");
			}
		}
		bw.flush();
		

	}

}

class PP {

	int to, dist;

	public PP(int to, int dist) {
		super();
		this.to = to;
		this.dist = dist;
	}

}