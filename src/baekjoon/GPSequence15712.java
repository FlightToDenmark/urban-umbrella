package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GPSequence15712 {

	static long a, r, n, mod;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		a = Long.parseLong(st.nextToken());
		r = Long.parseLong(st.nextToken());
		n = Long.parseLong(st.nextToken());
		mod = Long.parseLong(st.nextToken());

		if (mod == 0) {
			System.out.println("0");
		} else {
			System.out.println(a * g(n - 1) % mod);
		}

	}

	static long power(long a, long b) {

		long sum = 1;
		while (b > 0) {
			if (b % 2 == 1) {
				sum = sum * a % mod;
			}
			a = a * a % mod;
			b /= 2;
		}
		return sum;

	}

	static long g(long x) {

		if (x == 0) {
			return 1;
		}
		if (x == 1) {
			return (1 + r) % mod;
		}
		if (x % 2 == 1) {
			return g(x / 2) * (1 + power(r, x / 2 + 1)) % mod;
		}
		return (g(x / 2 - 1) * (1 + power(r, x / 2)) % mod + power(r, x) % mod) % mod;

	}

}
