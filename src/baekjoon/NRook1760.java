package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NRook1760 {

	static int M, N, A, B;
	static int[] match;
	static int[][] map, row, col;
	static boolean[] visited;
	static boolean[][] adj;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		row = new int[M][N];
		col = new int[M][N];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				map[m][n] = Integer.parseInt(st.nextToken());
			}
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

		boolean before = false;
		for (int m = 0; m < M; m++) {
			for (int n = 0; n < N; n++) {
				if (map[m][n] == 0 || map[m][n] == 1) {
					if (!before) {
						A++;
					}
					row[m][n] = A;
					before = true;
				} else {
					before = false;
				}
			}
			before = false;
		}
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (map[m][n] == 0 || map[m][n] == 1) {
					if (!before) {
						B++;
					}
					col[m][n] = B;
					before = true;
				} else {
					before = false;
				}
			}
			before = false;
		}

		visited = new boolean[A + 1];
		match = new int[B + 1];
		adj = new boolean[A + 1][B + 1];
		for (int m = 0; m < M; m++) {
			for (int n = 0; n < N; n++) {
				if (map[m][n] == 0) {
					adj[row[m][n]][col[m][n]] = true;
				}
			}
		}

	}

}
