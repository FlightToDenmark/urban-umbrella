package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IndependentSet {

	public static int[] weight;
	public static List<ArrayList<Integer>> adjacent;
	public static int[][] cache;
	public static int[] parent;
	public static List<Integer> backtrackSet;
	public static int N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		weight = new int[N + 1];
		adjacent = new ArrayList<ArrayList<Integer>>();
		cache = new int[N + 1][2];
		parent = new int[N + 1];
		backtrackSet = new ArrayList<>();

		for (int[] c : cache) Arrays.fill(c, -1);

		for (int n = 0; n <= N; n++) adjacent.add(new ArrayList<Integer>());

		for (int n = 1; n <= N; n++) weight[n] = sc.nextInt();

		for (int n = 0; n < N - 1; n++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adjacent.get(a).add(b);
			adjacent.get(b).add(a);
		}

		sc.close();

		parent[1] = 1;
		int oneOut = dfs(1, 0);
		int oneIn = dfs(1, 1);
		
		if (oneIn >= oneOut) {
			System.out.println(oneIn);
			findSet(1, 1);
		} else {
			System.out.println(oneOut);
			findSet(1, 0);
		}

		for (int e : backtrackSet) System.out.print(e + " ");

	}

	public static int dfs(int node, int isPicked) {

		int point = 0;
		if (isPicked == 0) {
			int pointA = 0, pointB = 0;
			for (int n : adjacent.get(node)) {
				if (parent[n] == 0 || parent[n] == node) {
					parent[n] = node;
					pointA = ((cache[n][0] != -1) ? cache[n][0] : dfs(n, 0));
					pointB = ((cache[n][1] != -1) ? cache[n][1] : dfs(n, 1));
				}
				point += Math.max(pointA, pointB);
			}
		} else {
			int pointA = 0;
			for (int n : adjacent.get(node)) {
				if (parent[n] == 0 || parent[n] == node) {
					parent[n] = node;
					pointA = ((cache[n][0] != -1) ? cache[n][0] : dfs(n, 0));
				}
				point += pointA;
			}
			point += weight[node];
		}

		return cache[node][isPicked] = point;

	}

	public static void findSet(int node, int isPicked) {

		if (isPicked == 0) {
			for (int n = 2; n <= N; n++) {
				if (parent[n] == node) {
					if (cache[n][1] >= cache[n][0])	findSet(n, 1);
					else findSet(n, 0);
				}
			}
		} else {
			backtrackSet.add(node);
			for (int n = 2; n <= N; n++) {
				if (parent[n] == node) findSet(n, 0);
			}
		}

	}

}
