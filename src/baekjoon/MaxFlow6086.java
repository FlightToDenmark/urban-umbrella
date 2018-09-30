package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MaxFlow6086 {

	static final int V = 52;
	static final int A = 0, Z = 25;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] c = new int[V][V];
		int[][] f = new int[V][V];
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] adj = new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<>();
		}

		StringTokenizer st;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			char aa = st.nextToken().charAt(0);
			char bb = st.nextToken().charAt(0);
			int a = (aa <= 'Z') ? aa - 65 : aa - 71;
			int b = (bb <= 'Z') ? bb - 65 : bb - 71;
			c[a][b] = c[b][a] += Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}

		int totalFlow = 0;
		while (true) {
			int[] prev = new int[V];
			Arrays.fill(prev, -1);
			Queue<Integer> Q = new LinkedList<>();
			Q.add(A);
			while (!Q.isEmpty()) {
				int here = Q.poll();
				for (int next : adj[here]) {
					if (c[here][next] - f[here][next] > 0 && prev[next] == -1) {
						Q.add(next);
						prev[next] = here;
						if (next == Z)
							break;
					}
				}
			}
			if (prev[Z] == -1) {
				break;
			}
			int flow = Integer.MAX_VALUE;
			for (int i = Z; i != A; i = prev[i]) {
				flow = Math.min(flow, c[prev[i]][i] - f[prev[i]][i]);
			}
			for (int i = Z; i != A; i = prev[i]) {
				f[prev[i]][i] += flow;
				f[i][prev[i]] -= flow;
			}
			totalFlow += flow;

		}

		bw.write(totalFlow + "\n");
		bw.flush();

	}

}
