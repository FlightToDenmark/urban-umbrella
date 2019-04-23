import java.io.*;
import java.util.*;

public class Main {

	static int N, start, end, maxDist, totalDist;
	static ArrayList<Pair>[] adj;
	static boolean[] visited;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int n = 0; n <= N; n++) {
			adj[n] = new ArrayList<>();
		}
		int from, to, dist;
		for (int n = 1; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			dist = Integer.parseInt(st.nextToken());
			adj[from].add(new Pair(to, dist));
			adj[to].add(new Pair(from, dist));
		}
		dfs(start, 0, 0);
		bw.write(totalDist - maxDist + "\n");
		bw.close();

	}

	static void dfs(int here, int dist, int max) {

		visited[here] = true;
		if (here == end) {
			totalDist = dist;
			maxDist = max;
			return;
		}

		for (Pair to : adj[here]) {
			if (!visited[to.to]) {
				dfs(to.to, dist + to.dist, Math.max(max, to.dist));
			}
		}

	}

	static class Pair {

		int to, dist;

		public Pair(int to, int dist) {
			super();
			this.to = to;
			this.dist = dist;
		}

	}

}
