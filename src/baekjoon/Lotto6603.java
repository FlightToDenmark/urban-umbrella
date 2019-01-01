package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Lotto6603 {

	static int N;
	static int[] num = new int[13];
	static boolean[] visited = new boolean[13];
	static BufferedReader br;
	static BufferedWriter bw;

	public static void main(String[] args) throws Exception {

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N == 0) {
				break;
			}
			for (int n = 0; n < N; n++) {
				num[n] = Integer.parseInt(st.nextToken());
				visited[n] = false;
			}
			for (int n = 0; n < N; n++) {
				visited[n] = true;
				dfs(n, 1);
				visited[n] = false;
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();

	}

	static void dfs(int i, int total) throws Exception {

		if (total == 6) {
			for (int n = 0; n < N; n++) {
				if (visited[n]) {
					bw.write(num[n] + " ");
				}
			}
			bw.newLine();
			return;
		}

		for (int n = i + 1; n < N; n++) {
			visited[n] = true;
			dfs(n, total + 1);
			visited[n] = false;
		}

	}

}
