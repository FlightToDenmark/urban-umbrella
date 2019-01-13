package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FromSeoul14863 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int t1, m1, t2, m2;
		int[] D = new int[K + 1];
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			t1 = Integer.parseInt(st.nextToken());
			m1 = Integer.parseInt(st.nextToken());
			t2 = Integer.parseInt(st.nextToken());
			m2 = Integer.parseInt(st.nextToken());
			for (int k = K; k >= 0; k--) {
				D[k] = -1;
				if (k >= t1 && D[k - t1] != -1) {
					D[k] = D[k - t1] + m1;
				}
				if (k >= t2 && D[k - t2] != -1) {
					D[k] = max(D[k], D[k - t2] + m2);
				}
			}
		}
		int answer = 0;
		for (int k = 1; k <= K; k++) {
			answer = max(answer, D[k]);
		}
		bw.write(answer + "\n");
		bw.flush();

	}

	static int max(int a, int b) {

		if (a >= b) {
			return a;
		} else {
			return b;
		}

	}

}
