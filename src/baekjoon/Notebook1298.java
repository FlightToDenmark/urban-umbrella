package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Notebook1298 {

	static int N, M;
	static boolean[][] adj;
	static boolean[] visited;
	static int[] aMatch, bMatch;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new boolean[N + 1][M + 1];
		aMatch = new int[N + 1];
		bMatch = new int[M + 1];

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			adj[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
		}

		System.out.println(bipartiteMatch());

	}

	static int bipartiteMatch() {

		int total = 0;

		for (int a = 1; a <= N; a++) {
			visited = new boolean[N + 1];
			if (dfs(a))	total++;
		}

		return total;

	}

	static boolean dfs(int a) {

		if (visited[a])	return false;

		visited[a] = true;

		for (int b = 1; b <= M; b++) {
			if (adj[a][b]) {
				if (bMatch[b] == 0 || dfs(bMatch[b])) {
					aMatch[a] = b;
					bMatch[b] = a;
					return true;
				}
			}
		}

		return false;

	}

}
