package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sequence2291 {

	static int N, M, K;
	static int[][][] D;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		D = new int[N + 1][M + 1][M + 1];
		for (int i = 1; i <= M; i++) {
			D[1][i][i] = 1;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				for (int k = 1; k <= j; k++) {
					for (int l = k; l <= M; l++) {
						D[i][k][j] += D[i - 1][l][j - k];
					}
				}
			}
		}
		kth(N, 1, M, K);

	}

	static void kth(int len, int pre, int sum, int k) {

		for (int i = pre; i <= M; i++) {
			if (D[len][i][sum] >= k) {
				System.out.print(i + " ");
				kth(len - 1, i, sum - i, k);
				return;
			} else {
				k -= D[len][i][sum];
			}
		}

	}

}
