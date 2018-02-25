package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinChange_BruteForce {

	public static int N, M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		long[] coin = new long[M];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++)	coin[m] = Long.parseLong(st2.nextToken());
		Arrays.sort(coin);
		System.out.println(getWays(N, coin));

	}

	public static long getWays(long money, long[] c) {

		if (money == 0) return 1;

		long ret = 0;

		long nextMoney = money - c[0];
		if (nextMoney >= 0) ret += getWays(nextMoney, c);

		if (c.length > 1) {
			long[] newArr = Arrays.copyOfRange(c, 1, c.length);
			ret += getWays(money, newArr);
		}

		return ret;

	}

}