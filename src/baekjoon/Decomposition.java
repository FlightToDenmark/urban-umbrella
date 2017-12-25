package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Decomposition {

	public static List<ArrayList<Integer>> adj;
	public static boolean visited[];
	public static int[] child;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		adj = new ArrayList<>();
		visited = new boolean[n+1];
		child = new int[n+1];
		for (int i = 0; i <= n; i++) adj.add(new ArrayList<Integer>());

		for (int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj.get(a).add(b);
			adj.get(b).add(a);
		}

		sc.close();

		dfs(1);
		
		int cut = 0;
		while(m!=0) {
			for(int i=1; i<=n; i++){
				if(m==child[i] || n-m==child[i]) {
					cut++;
					break;
				}
			}
		}
		System.out.println(cut);
				
	}

	public static int dfs(int node) {

		visited[node] = true;

		int children = 1;
		for (int next : adj.get(node)) {
			if (!visited[next])
				children += dfs(next);
		}

		return child[node] = children;

	}

}
