package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z1074 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		System.out.println(solve(N, r, c));

	}

	static int solve(int N, int r, int c) {

		if (N == 0)	return 0;

		int A = (int) Math.pow(2, N - 1);
		int X = (r / A) * 2 + (c / A);

		int newR = r;
		int newC = c;

		if (X == 1 || X == 3) newC -= A;
		if (X == 2 || X == 3) newR -= A;

		return X * ((int) Math.pow(2, 2 * N - 2)) + solve(N - 1, newR, newC);

	}

}
