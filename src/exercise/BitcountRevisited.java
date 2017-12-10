package exercise;

import java.util.Scanner;

public class BitcountRevisited {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		while (testCase-- > 0) {
			long from = bitCalculator(sc.nextLong());
			long to = bitCalculator(sc.nextLong());
			System.out.println(to - from);
		}
		
		sc.close();

	}

	public static long bitCalculator(long number) {
		
		String s = Long.toBinaryString(number);
		
		int length = s.length();

		int total = 0;
		for(int i=0; i<length; i++) {
			if(s.charAt(i)=='1') total += (Math.pow(2, length-i)-1);
		}
		
		return total;		
	
	}

}
