package algospot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class POTION {

	static StringTokenizer st;
	static int N;
	static int[] r = new int[200]; // recipe
	static int[] p = new int[200]; // put

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {

			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				r[n] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				p[n] = Integer.parseInt(st.nextToken());
			}
			solve();

		}

	}

	static void solve() {

		int b = r[0];
		for (int n = 1; n < N; n++) {
			b = gcd(b, r[n]);
		}
		int a = b;
		for (int n = 0; n < N; n++) {
			a = Math.max(a, ceil(p[n] * b, r[n]));
		}
		for (int n = 0; n < N; n++) {
			System.out.print((r[n] * a / b - p[n]) + " ");
		}
		System.out.println();

	}

	static int gcd(int a, int b) {

		return b == 0 ? a : gcd(b, a % b);

	}

	static int ceil(int a, int b) {

		return (a + b - 1) / b;

	}

}
