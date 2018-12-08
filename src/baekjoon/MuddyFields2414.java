package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MuddyFields2414 {

	static int N, M, numA, numB;
	static boolean[] visited;
	static int[] match;
	static char[][] map;
	static int[][] row, col;
	static boolean[][] adj;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		row = new int[N][M];
		col = new int[N][M];
		for (int n = 0; n < N; n++) {
			map[n] = br.readLine().toCharArray();
		}
		System.out.println(bipartiteMatch());

	}

	static int bipartiteMatch() {

		numbering();
		int total = 0;
		for (int a = 1; a <= numA; a++) {
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

		for (int b = 1; b <= numB; b++) {
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
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (map[n][m] == '*') {
					if (!before) {
						numA++;
					}
					row[n][m] = numA;
					before = true;
				} else {
					before = false;
				}
			}
			before = false;
		}

		for (int m = 0; m < M; m++) {
			for (int n = 0; n < N; n++) {
				if (map[n][m] == '*') {
					if (!before) {
						numB++;
					}
					col[n][m] = numB;
					before = true;
				} else {
					before = false;
				}
			}
			before = false;
		}

		visited = new boolean[numA + 1];
		match = new int[numB + 1];
		adj = new boolean[numA + 1][numB + 1];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (map[n][m] == '*') {
					adj[row[n][m]][col[n][m]] = true;
				}
			}
		}

	}

}
