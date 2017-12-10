package exercise;

import java.util.Scanner;

public class Bitcount {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		while (testCase-- > 0) System.out.println(bitCaculator(sc.nextLong(), sc.nextLong()));
				
		sc.close();

	}

	public static long bitCaculator(long start, long end) {

		long total = 0;
		for (long i = start; i < end; i++) total += Long.bitCount(i ^ (i + 1));
		return total;
	
	}

}
