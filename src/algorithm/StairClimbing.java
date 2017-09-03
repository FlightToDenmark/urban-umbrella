package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class StairClimbing {

	public static int stair;
	public static int[] score;
	public static int[] cache;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		stair = sc.nextInt();
		score = new int[stair + 1];
		cache = new int[stair + 1];
		Arrays.fill(cache, -1);

		for (int i = 1; i <= stair; i++)
			score[i] = sc.nextInt();

		System.out.println(Math.max(maxScore(0), maxScore(1)));

		sc.close();

	}

	public static int maxScore(int index) {


		if (index == stair)
			return score[stair];
		
		if (index == stair - 1)
			return cache[index] = score[stair - 1] + score[stair];
		
		if (index > stair)
			return -1000000;

		if (cache[index] != -1)
			return cache[index];

		return cache[index] = Math.max(maxScore(index + 3) + score[index] + score[index + 1], maxScore(index + 2) + score[index]);
	
	}

}
