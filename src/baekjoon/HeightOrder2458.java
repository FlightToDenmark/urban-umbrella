package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HeightOrder2458 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int INF = 999;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] D = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				D[i][j] = (i == j) ? 0 : INF;
			}
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			D[i][j] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if(D[i][k]==INF) continue;
				for (int j = 1; j <= N; j++) {
					if(D[k][j]==INF) continue;
					D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
				}
			}
		}

		int total = 0;
		for (int i = 1; i <= N; i++) {
			int I = 0;
			for (int j = 1; j <= N; j++) {
				if (i == j)	continue;
				if (D[i][j] != INF || D[j][i] != INF) I++;
			}
			if (I == N - 1)	total++;
		}
		System.out.println(total);

	}

}
