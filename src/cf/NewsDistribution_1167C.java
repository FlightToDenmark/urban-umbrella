import java.io.*;
import java.util.*;

public class Main {

	static int N, M, K, idx;
	static List<Integer>[] adj;
	static int[] group, answer;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		group = new int[N + M + 1];
		adj = new ArrayList[N + M + 1];
		answer = new int[N + 1];
		for (int n = 0; n <= N + M; n++) {
			adj[n] = new ArrayList<>();
		}
		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			for (int k = 0; k < K; k++) {
				int v = Integer.parseInt(st.nextToken());
				adj[v].add(m + N);
				adj[m + N].add(v);
			}
		}
		for (int i = 1; i <= N; i++) {
			if (group[i] == 0) {
				idx++;
				answer[idx] = dfs(i);
			}
			bw.write(answer[group[i]] + " ");
		}
		bw.newLine();
		bw.close();

	}

	static int dfs(int a) {

		group[a] = idx;
		int ret = (a > N) ? 0 : 1;
		for (int next : adj[a]) {
			if (group[next] == 0) {
				ret += dfs(next);
			}
		}
		return ret;

	}

}
