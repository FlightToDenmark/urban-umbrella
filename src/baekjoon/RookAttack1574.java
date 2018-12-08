package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RookAttack1574 {

	static int R, C, N, A, B;
	static int[] match;
	static int[][] row, col;
	static boolean[] visited;
	static boolean[][] map, adj;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new boolean[R + 1][C + 1];
		row = new int[R + 1][C + 1];
		col = new int[R + 1][C + 1];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
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

		A = 1;
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				row[r][c] = A;
			}
			A++;
		}
		B = 1;
		for (int c = 1; c <= C; c++) {
			for (int r = 1; r <= R; r++) {
				col[r][c] = B;
			}
			B++;
		}

		visited = new boolean[A + 1];
		match = new int[B + 1];
		adj = new boolean[A + 1][B + 1];
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				if (!map[r][c]) {
					adj[row[r][c]][col[r][c]] = true;
				}
			}
		}

	}

}
