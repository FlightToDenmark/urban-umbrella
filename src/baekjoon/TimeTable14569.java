package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TimeTable14569 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int K;
		long[] classBit = new long[N];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			for (int k = 0; k < K; k++) {
				classBit[n] |= (1L << Integer.parseInt(st.nextToken()));
			}
		}

		int M = Integer.parseInt(br.readLine());
		int P;
		int possible;
		long[] studentBit = new long[M];
		for (int m = 0; m < M; m++) {
			possible = 0;
			st = new StringTokenizer(br.readLine());
			P = Integer.parseInt(st.nextToken());
			for (int p = 0; p < P; p++) {
				studentBit[m] |= (1L << Integer.parseInt(st.nextToken()));
			}
			for (int n = 0; n < N; n++) {
				if ((classBit[n] & studentBit[m]) == classBit[n]) {
					possible++;
				}
			}
			System.out.println(possible);
		}

	}

}
