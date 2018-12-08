package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Asteroids1867 {

	static int N, K;
	static int[] match;
	static boolean[] visited;
	static boolean[][] adj;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		match = new int[N + 1];
		visited = new boolean[N + 1];
		adj = new boolean[N + 1][N + 1];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			adj[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
		}
		System.out.println(bipartiteMatch());

	}

	static int bipartiteMatch() {

		int total = 0;

		for (int a = 1; a <= N; a++) {
			Arrays.fill(visited, false);
			if (dfs(a)) {
				total++;
			}
		}

		return total;

	}

	static boolean dfs(int a) {

		if (visited[a]) {
			return false;
		}

		visited[a] = true;

		for (int b = 1; b <= N; b++) {
			if (adj[a][b]) {
				if (match[b] == 0 || dfs(match[b])) {
					match[b] = a;
					return true;
				}
			}
		}

		return false;

	}

}
