package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Dark6497 {

	static int V, E;
	static int[] sup = new int[200000];
	static Queue<Edge> list = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			if (V == 0 && E == 0) {
				System.exit(0);
			}
			for (int v = 0; v < V; v++) {
				sup[v] = v;
			}
			list.clear();
			int a, b, c, sum = 0;
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				sum += c = Integer.parseInt(st.nextToken());
				list.add(new Edge(a, b, c));
			}
			int weight = 0;
			int total = 0;
			while (!list.isEmpty()) {
				Edge e = list.poll();
				if (union(e.from, e.to)) {
					weight += e.w;
					if (++total == V - 1) {
						break;
					}
				}
			}
			System.out.println(sum - weight);
		}

	}

	static boolean union(int a, int b) {

		a = find(a);
		b = find(b);
		if (a == b) {
			return false;
		}
		sup[b] = a;
		return true;

	}

	static int find(int a) {

		while (a != sup[a]) {
			a = sup[a];
		}
		return a;

	}

}

class Edge implements Comparable<Edge> {

	int from, to, w;

	public Edge(int from, int to, int w) {
		super();
		this.from = from;
		this.to = to;
		this.w = w;
	}

	@Override
	public int compareTo(Edge edge) {
		return this.w - edge.w;
	}

}
