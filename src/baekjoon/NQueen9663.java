package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NQueen9663 {

	static int N, answer;
	static boolean[] col, down, up;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new boolean[N];
		down = new boolean[2 * N - 1];
		up = new boolean[2 * N - 1];
		solve(0);
		System.out.println(answer);

	}

	static void solve(int i) {

		if (i == N) {
			answer++;
			return;
		}

		for (int j = 0; j < N; j++) {
			if (!col[j] && !up[i + j] && !down[i - j + N - 1]) {
				col[j] = true;
				up[i + j] = true;
				down[i - j + N - 1] = true;
				solve(i + 1);
				col[j] = false;
				up[i + j] = false;
				down[i - j + N - 1] = false;
			}
		}

	}

}
