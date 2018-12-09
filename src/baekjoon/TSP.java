package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class TSP {

	public static final int INF = 1000000000;
	public static int[][] distance;
	public static int[][] cache;
	public static int C;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		C = sc.nextInt();

		distance = new int[C][C];
		cache = new int[C][1 << C];

		for (int[] d : cache)
			Arrays.fill(d, -1);

		for (int i = 0; i < C; i++)
			for (int j = 0; j < C; j++)
				distance[i][j] = sc.nextInt();

		System.out.println(findPaths(0, 1));

		sc.close();

	}

	public static int findPaths(int here, int visited) {

		if (visited == (1 << C) - 1) {
			if (distance[here][0] > 0) {
				return distance[here][0];
			} else {
				return INF;
			}
		}

		if (cache[here][visited] >= 0)
			return cache[here][visited];

		int ret = INF;
		for (int next = 0; next < C; next++) {
			if ((visited & (1 << next)) != 0)
				continue;
			if (distance[here][next] == 0)
				continue;
			int cand = distance[here][next] + findPaths(next, visited + (1 << next));
			ret = Math.min(ret, cand);
		}

		return cache[here][visited] = ret;

	}

}
