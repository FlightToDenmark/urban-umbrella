package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AttackingRooks9525 {

	static int N, A, B;
	static int[] match;
	static char[][] map;
	static int[][] row, col;
	static boolean[] visited;
	static boolean[][] adj;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		row = new int[N][N];
		col = new int[N][N];
		for (int n = 0; n < N; n++) {
			map[n] = br.readLine().toCharArray();
		}
		System.out.println(bipartiteMatch());

	}

	static int bipartiteMatch() {

		numbering();
		int total = 0;
		for (int a = 1; a <= A; a++) {
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

		for (int b = 1; b <= B; b++) {
			if (adj[a][b]) {
				if (match[b] == 0 || dfs(match[b])) {
					match[b] = a;
					return true;
				}
			}
		}
		return false;
	}

	static void numbering() {

		boolean beforeA = false;
		boolean beforeB = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '.') {
					if (!beforeA) {
						A++;
					}
					row[i][j] = A;
					beforeA = true;
				} else {
					beforeA = false;
				}
				if (map[j][i] == '.') {
					if (!beforeB) {
						B++;
					}
					col[j][i] = B;
					beforeB = true;
				} else {
					beforeB = false;
				}
			}
			beforeA = false;
			beforeB = false;
		}

		visited = new boolean[A + 1];
		match = new int[B + 1];
		adj = new boolean[A + 1][B + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '.') {
					adj[row[i][j]][col[i][j]] = true;
				}
			}
		}

	}

}
