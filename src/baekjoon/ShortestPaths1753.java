package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class ShortestPaths1753 {

	static final int INF = 987654321;
	static int V, E, K;
	static int[] D;
	static boolean[] visited;
	static List<PB>[] adj;
	static Queue<PB> pq;

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
		visited = new boolean[V + 1];
		pq = new PriorityQueue<>();
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
			adj[from].add(new PB(to, dist));
		}

		pq.add(new PB(K, 0));
		D[K] = 0;
		while (!pq.isEmpty()) {
			PB here = pq.poll();
			if (visited[here.to]) {
				continue;
			}
			visited[here.to] = true;
			for (PB next : adj[here.to]) {
				if (D[next.to] > D[here.to] + next.dist) {
					D[next.to] = D[here.to] + next.dist;
					pq.add(new PB(next.to, D[next.to]));
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

class PB implements Comparable<PB> {

	int to, dist;

	public PB(int to, int dist) {
		super();
		this.to = to;
		this.dist = dist;
	}

	@Override
	public int compareTo(PB pb) {
		return this.dist - pb.dist;
	}

}