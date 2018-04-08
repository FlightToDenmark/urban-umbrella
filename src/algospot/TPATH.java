package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class TPATH {

	public static final int INF = 987654321;
	public static int N, M;
	public static int[] parent, rank;
	public static ArrayList<Pair> edges;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st1.nextToken());
			M = Integer.parseInt(st1.nextToken());

			edges = new ArrayList<>();

			for (int m = 0; m < M; m++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st2.nextToken());
				int end = Integer.parseInt(st2.nextToken());
				int v = Integer.parseInt(st2.nextToken());
				edges.add(new Pair(start, end, v));
			}

			Collections.sort(edges);
			System.out.println(minWeightDiff());

		}

	}

	public static void union(int u, int v) {

		u = find(u); v = find(v);

		if (u == v)	return;

		if (rank[u] > rank[v]) {
			int temp = u;
			u = v;
			v = temp;
		}

		parent[u] = v;
		if (rank[u] == rank[v]) rank[v]++;

	}

	public static int find(int u) {

		while (u != parent[u]) u = parent[u];
		return u;

	}

	public static int kruskalMinUpperBound(int low) {

		parent = new int[N];
		for (int n = 0; n < N; n++)	parent[n] = n;
		rank = new int[N];
		Arrays.fill(rank, 1);

		for (int e = 0; e < edges.size(); e++) {
			Pair p = edges.get(e);
			int weight = edges.get(low).v;
			if (p.v < weight) continue;
			
			union(p.start, p.end);
			if (find(0) == find(N - 1)) return p.v;
		}

		return INF;

	}

	public static int minWeightDiff() {

		int ret = INF;
		for (int i = 0; i < edges.size(); i++) {
			ret = Math.min(ret, kruskalMinUpperBound(i) - edges.get(i).v);
		}
		return ret;
	}

}

class Pair implements Comparable<Pair> {

	int start;
	int end;
	int v;

	public Pair(int start, int end, int v) {
		super();
		this.start = start;
		this.end = end;
		this.v = v;
	}

	@Override
	public int compareTo(Pair p) {
		return this.v - p.v;
	}

}
