package cf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static boolean bipartite;
	static int N, M;
	static ArrayList<Integer>[] adj;
	static int[] color;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N + 1];
		for (int n = 0; n <= N; n++) {
			adj[n] = new ArrayList<>();
		}
		color = new int[N + 1];
		Arrays.fill(color, -1);
		bipartite = true;
		int a, b;
		int[][] input = new int[M][2];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			input[m][0] = a = Integer.parseInt(st.nextToken());
			input[m][1] = b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}

		dfs(1, 0);

		if (!bipartite) {
			bw.write("NO\n");
			bw.close();
			return;
		}

		bw.write("YES\n");
		for (int m = 0; m < M; m++) {
			if (color[input[m][0]] > color[input[m][1]]) {
				bw.write("0");
			} else {
				bw.write("1");
			}
		}
		bw.write("\n");
		bw.close();

	}

	static void dfs(int here, int c) {

		color[here] = c;

		for (int to : adj[here]) {
			if (color[to] == -1) {
				dfs(to, c ^ 1);
			} else {
				if (color[here] == color[to]) {
					bipartite = false;
					return;
				}
			}
		}

	}

}
