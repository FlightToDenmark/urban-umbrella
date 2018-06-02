package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Stable2188 {

	static int N, M;
	static boolean[] visited;
	static int[] bMatch;
	static boolean[][] adj;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		bMatch = new int[M + 1];
		adj = new boolean[N + 1][M + 1];

		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken());
			for (int i = 0; i < I; i++) {
				adj[m][Integer.parseInt(st.nextToken())] = true;
			}
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
					bMatch[b] = a;
					return true;
				}
			}
		}

		return false;

	}

}
