package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci1003 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		int[][] C = new int[41][2];

		C[0][0] = 1;
		C[0][1] = 0;
		C[1][0] = 0;
		C[1][1] = 1;

		for (int n = 2; n <= 40; n++) {
			C[n][0] = C[n - 1][0] + C[n - 2][0];
			C[n][1] = C[n - 1][1] + C[n - 2][1];
		}

		while (testCase-- > 0) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(C[N][0] + " " + C[N][1]);
		}

	}

}