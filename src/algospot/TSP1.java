package algospot;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TSP1 {

	public static double[][] distance;
	public static boolean[] visited;
	public static Deque<Integer> path;
	public static int totalCity;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		while (testCase-- > 0) {

			totalCity = sc.nextInt();

			distance = new double[totalCity][totalCity];
			visited = new boolean[totalCity];
			path = new LinkedList<>();

			for (int i = 0; i < totalCity; i++)
				for (int j = 0; j < totalCity; j++)
					distance[i][j] = sc.nextDouble();

			Double minLength = Double.MAX_VALUE;
			for (int start = 0; start < totalCity; start++) {
				Double length = findPaths(start);
				minLength = Math.min(minLength, length);
			}
			System.out.format("%.10f\n", minLength);

		}

		sc.close();

	}

	public static double findPaths(int city) {

		visited[city] = true;
		path.add(city);

		if (path.size() == totalCity) {
			visited[city] = false;
			path.pollLast();
			return 0;
		}

		double length = Double.MAX_VALUE;

		for (int next = 0; next < totalCity; next++) {
			if (visited[next]) continue;
			int here = city;
			double nextLength = distance[here][next] + findPaths(next);
			length = Math.min(length, nextLength);
		}

		visited[city] = false;
		path.pollLast();

		return length;

	}

}
