package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class KLIS {

	public static int[] cacheLength = new int[501], cacheCount = new int[501];
	public static int N, K; // N: sequence length, K: Kth LIS
	public static int[] S; // S: sequence
	public static List<Integer> lis;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		while (testCase-- > 0) {

			N = sc.nextInt();
			K = sc.nextInt();
			S = new int[N + 1];
			lis = new ArrayList<>();
			Arrays.fill(cacheLength, -1);
			Arrays.fill(cacheCount, -1);

			S[0] = Integer.MIN_VALUE;
			for (int i = 1; i <= N; i++)
				S[i] = sc.nextInt();

			System.out.println(lis(-1) - 1);
			reconstruct(1, K-1);
			System.out.println(lis);

		}

		sc.close();

	}

	public static int lis(int start) {

		if (cacheLength[start + 1] != -1)
			return cacheLength[start + 1];

		int ret = 1;

		for (int next = start + 1; next < N; next++)
			if (start == -1 || S[start] < S[next])
				ret = cacheLength[start + 1] = Math.max(ret, lis(next) + 1);

		return ret;

	}

	public static int count(int start) {

		if (lis(start) == 1)
			return 1;

		if (cacheCount[start + 1] != -1)
			return cacheCount[start + 1];

		int ret = 0;

		for (int next = start + 1; next < N; next++)
			if ((start == -1 || S[start] < S[next]) && lis(start) == lis(next) + 1)
				ret = cacheCount[start + 1] = ret + count(next);

		return ret;

	}

	public static void reconstruct(int start, int skip) {

		if (start != -1)
			lis.add(S[start]);

		Queue<Pair> followers = new PriorityQueue<>();

		for (int next = start + 1; next < N; next++)
			if ((start == -1 || S[start] < S[next]) && lis(start) == lis(next) + 1)
				followers.add(new Pair(S[next], next));

		for (int i = 0; i < followers.size(); i++) {
			int index = followers.poll().index;
			int count = count(index);

			if (count <= skip)
				skip -= count;
			else {
				reconstruct(index, skip);
				break;
			}
		}

	}

}

class Pair implements Comparable<Pair> {

	int number, index;

	public Pair(int number, int index) {
		this.number = number;
		this.index = index;
	}

	@Override
	public int compareTo(Pair pair) {
		return this.number - pair.number;
	}

}
