package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class SugarDelivery {

	public static int[] cache;
	public static final int MAX = 10000;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int kilogram = sc.nextInt();
		cache = new int[5001];
		Arrays.fill(cache, -1);

		int answer = sugar(kilogram);
		System.out.println((answer < MAX) ? answer : -1);

		sc.close();

	}

	public static int sugar(int kilogram) {

		if (kilogram == 0)
			return 0;

		if (kilogram < 5 && kilogram != 3)
			return MAX;

		if (cache[kilogram] != -1)
			return cache[kilogram];

		return cache[kilogram] = Math.min(sugar(kilogram - 3), sugar(kilogram - 5)) + 1;

	}

}
