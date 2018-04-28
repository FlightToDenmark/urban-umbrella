package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Floyd11404 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int INF = 999999;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] D = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				D[i][j] = (i == j) ? 0 : INF;
			}
		}

		StringTokenizer st;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			D[i][j] = Math.min(k, D[i][j]);
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (D[i][k] == INF)	continue;
				for (int j = 1; j <= N; j++) {
					if (D[k][j] == INF)	continue;
					D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(D[i][j] != INF ? D[i][j] + " " : 0 + " ");
			}
			System.out.println();
		}

	}

}
