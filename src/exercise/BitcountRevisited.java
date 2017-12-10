package exercise;

import java.math.BigInteger;
import java.util.Scanner;

public class BitcountRevisited {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		while (testCase-- > 0) {
			BigInteger from = bitCalculator(sc.nextLong());
			BigInteger to = bitCalculator(sc.nextLong());
			System.out.println(to.subtract(from));
		}

		sc.close();

	}

	public static BigInteger bitCalculator(long number) {

		String s = Long.toBinaryString(number);

		int length = s.length();

		BigInteger total = BigInteger.ZERO;
		for (int i = 0; i < length; i++) {
			if (s.charAt(i) == '1') {
				Long l = (long) (Math.pow(2, length - i) - 1);
				total = total.add(BigInteger.valueOf(l));
			}
		}
		return total;

	}

}
