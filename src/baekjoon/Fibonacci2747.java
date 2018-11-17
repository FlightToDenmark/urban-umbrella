package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Fibonacci2747 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] F = new int[N + 1];
		F[0] = 0;
		F[1] = 1;
		for (int n = 2; n <= N; n++) {
			F[n] = F[n - 1] + F[n - 2];
		}
		System.out.println(F[N]);

	}

}
