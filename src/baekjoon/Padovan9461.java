package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Padovan9461 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] A = new long[101];
		A[1] = 1;
		A[2] = 1;
		A[3] = 1;
		for (int n = 4; n <= 100; n++) {
			A[n] = A[n - 3] + A[n - 2];
		}
		for (int t = 0; t < T; t++) {
			System.out.println(A[Integer.parseInt(br.readLine())]);
		}

	}

}
