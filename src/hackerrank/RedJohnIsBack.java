package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class RedJohnIsBack {

	static int[] memo = new int[41];
	static boolean[] isPrime;
	static int[] primeUnder;

	public static void main(String[] args) {

		Arrays.fill(memo, -1);

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		calculateAll(40);
		isPrime = new boolean[memo[40] + 1];
		primeUnder = new int[memo[40] + 1];
		Arrays.fill(isPrime, true);
		eratos();
		caculatePrimeUnder();
		
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			System.out.println(primeUnder[memo[n]]);
		}
		in.close();

	}

	static void calculateAll(int n) {

		for (int i = 1; i <= n; i++) {
			if (i >= 1 && i <= 3)
				memo[i] = 1;
			else if (i == 4)
				memo[i] = 2;
			else
				memo[i] = memo[i - 1] + memo[i - 4];
		}

	}

	static void eratos() {

		isPrime[0] = isPrime[1] = false;
		for (int n = 2; (n * n) <= memo[40]; n++) {
			if (isPrime[n]) {
				for (int m = n * 2; m <= memo[40]; m += n) {
					isPrime[m] = false;
				}
			}
		}

	}

	static void caculatePrimeUnder() {
		
		for (int i = 2; i <= memo[40]; i++) {
			if (isPrime[i]) {
				primeUnder[i] = primeUnder[i - 1] + 1;
			} else {
				primeUnder[i] = primeUnder[i - 1];
			}
		}

	}

}
