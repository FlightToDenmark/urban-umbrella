package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class AlmostShortestPath5719 {

	static int N, M, S, D;
	static boolean[] visited = new boolean[500];
	static List<Node>[] adj = new ArrayList[500];
	static Queue<Node> pq = new PriorityQueue<>();
	static Queue<Integer> backtrack = new LinkedList<>();
	static int[] distance = new int[500];
	static final int INF = 987654321;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 500; i++) {
			adj[i] = new ArrayList<>();
		}
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0) {
				System.exit(0);
			}

			for (int n = 0; n < N; n++) {
				visited[n] = false;
				adj[n].clear();
				distance[n] = INF;
			}
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			int from, to, dist;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				dist = Integer.parseInt(st.nextToken());
				adj[from].add(new Node(to, dist));
			}

			// Dijkstra
			pq.clear();
			pq.add(new Node(S, 0));
			distance[S] = 0;
			while (!pq.isEmpty()) {
				Node here = pq.poll();
				if (visited[here.num]) {
					continue;
				}
				visited[here.num] = true;
				for (Node next : adj[here.num]) {
					if (distance[next.num] > distance[here.num] + next.dist) {
						distance[next.num] = distance[here.num] + next.dist;
						pq.add(new Node(next.num, distance[next.num]));
					}
				}
			}

			// Backtrack BFS
			backtrack.clear();
			backtrack.add(D);
			while (!backtrack.isEmpty()) {
				int here = backtrack.poll();
				for (int before = 0; before < N; before++) {
					for (int i = 0; i < adj[before].size(); i++) {
						Node n = adj[before].get(i);
						if (n.num == here && distance[here] == distance[before] + n.dist) {
							n.setDist(-1);
							backtrack.add(before);
						}
					}
				}
			}

			// Dijkstra, again
			for (int n = 0; n < N; n++) {
				visited[n] = false;
				distance[n] = INF;
			}
			pq.clear();
			pq.add(new Node(S, 0));
			distance[S] = 0;
			while (!pq.isEmpty()) {
				Node here = pq.poll();
				if (visited[here.num]) {
					continue;
				}
				visited[here.num] = true;
				for (Node next : adj[here.num]) {
					if (next.dist == -1) {
						continue;
					}
					if (distance[next.num] > distance[here.num] + next.dist) {
						distance[next.num] = distance[here.num] + next.dist;
						pq.add(new Node(next.num, distance[next.num]));
					}
				}
			}

			System.out.println((distance[D] >= INF) ? -1 : distance[D]);

		}
	}

}

class Node implements Comparable<Node> {

	int num, dist;

	public Node(int num, int dist) {
		super();
		this.num = num;
		this.dist = dist;
	}

	public void setDist(int dist) {
		this.dist = dist;
	}

	@Override
	public int compareTo(Node node) {
		return this.dist - node.dist;
	}

}
