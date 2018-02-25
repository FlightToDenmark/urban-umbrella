package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinChange {

	public static int N, M;
	public static long coin[], cache1[][], cache2[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		coin = new long[M];

		if (N < Integer.MAX_VALUE) {
			cache1 = new long[N + 1][M];
			for (long[] a : cache1)	Arrays.fill(a, -1);
		} else {
			int remain = N - Integer.MAX_VALUE;
			cache1 = new long[N + 1][M];
			cache2 = new long[remain + 1][M];
			for (long[] a : cache1)	Arrays.fill(a, -1);
			for (long[] a : cache2)	Arrays.fill(a, -1);
		}

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++)	coin[m] = Integer.parseInt(st2.nextToken());
		Arrays.sort(coin);
		System.out.println(getWays(N, 0));

	}

	public static long getWays(long money, int available) {

		if (money == 0)	return 1;

		if (available == M)	return 0;

		if (money < Integer.MAX_VALUE) {
			int castMoney = Math.toIntExact(money);
			if (cache1[castMoney][available] != -1)	return cache1[castMoney][available];
		} else {
			int castMoney = Math.toIntExact(money - Integer.MAX_VALUE);
			if (cache2[castMoney][available] != -1)	return cache2[castMoney][available];
		}
		
		long ret = 0;

		long nextMoney = money - coin[available];
		if (nextMoney >= 0)	ret += getWays(nextMoney, available);

		ret += getWays(money, available + 1);

		if (money < Integer.MAX_VALUE) {
			int castMoney = Math.toIntExact(money);
			cache1[castMoney][available] = ret;
		} else {
			int castMoney = Math.toIntExact(money - Integer.MAX_VALUE);
			cache2[castMoney][available] = ret;
		}

		return ret;

	}

}
