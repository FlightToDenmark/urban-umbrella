package algospot;

import java.util.Arrays;
import java.util.Scanner;

public class TSP2 {

	public static final double INF = 1000000000;
	public static double[][] distance;
	public static double[][] cache;
	public static int C;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		while (testCase-- > 0) {

			C = sc.nextInt();

			distance = new double[C][C];
			cache = new double[C][1 << C];

			for (double[] d : cache) Arrays.fill(d, -1);

			for (int i = 0; i < C; i++)
				for (int j = 0; j < C; j++)
					distance[i][j] = sc.nextDouble();

			double min = INF;
			for (int city = 0; city < C; city++) min = Math.min(min, findPaths(city, 1 << city));
			System.out.format("%.10f", min);

		}

		sc.close();

	}

	public static double findPaths(int here, int visited) {

		if (visited == (1 << C) - 1) return 0;

		if (cache[here][visited] >= 0) return cache[here][visited];
		
		double ret = INF;
		for (int next = 0; next < C; next++) {
			if ((visited & (1 << next)) != 0) continue;
			double cand = distance[here][next] + findPaths(next, visited + (1 << next));
			ret = Math.min(ret, cand);
		}

		return cache[here][visited] = ret;

	}

}
