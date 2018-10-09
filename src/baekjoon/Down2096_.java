package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Down2096_ {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] A = new int[N + 1][3];
		int[][] min = new int[N + 1][3];
		int[][] max = new int[N + 1][3];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				min[i][j] = max[i][j] = A[i][j];
				min[i][j] += Math.min(min[i - 1][1], (j == 1) ? Math.min(min[i - 1][0], min[i - 1][2]) : min[i - 1][j]);
				max[i][j] += Math.max(max[i - 1][1], (j == 1) ? Math.max(max[i - 1][0], max[i - 1][2]) : max[i - 1][j]);
			}
		}

		Arrays.sort(max[N]);
		Arrays.sort(min[N]);

		System.out.println(max[N][2] + " " + min[N][0]);

	}

}
