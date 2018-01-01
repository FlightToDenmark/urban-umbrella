package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parent {

	public static boolean[] visited;
	public static int[] parent;
	public static List<ArrayList<Integer>> adjacent;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int node = sc.nextInt();

		visited = new boolean[node + 1];
		parent = new int[node + 1];
		adjacent = new ArrayList<ArrayList<Integer>>();

		for (int n = 0; n <= node; n++)
			adjacent.add(new ArrayList<Integer>());

		for (int n = 0; n < node - 1; n++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adjacent.get(a).add(b);
			adjacent.get(b).add(a);
		}

		sc.close();

		dfs(1);

		for (int n = 2; n <= node; n++)
			System.out.println(parent[n]);

	}

	public static void dfs(int node) {

		visited[node] = true;

		for (int n : adjacent.get(node)) {
			if (!visited[n]) {
				parent[n] = node;
				dfs(n);
			}
		}

	}

}
