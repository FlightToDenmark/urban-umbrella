package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Fibonacci2749 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		int mod = 1000000;
		int P = mod / 10 * 15;
		int[] F = new int[P + 1];
		F[0] = 0;
		F[1] = 1;
		for (int n = 2; n <= P; n++) {
			F[n] = (F[n - 1] + F[n - 2]) % mod;
		}
		int index = Math.toIntExact(N % P);
		System.out.println(F[index]);

	}

}
