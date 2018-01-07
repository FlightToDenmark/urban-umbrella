package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Decomposition {

	public static List<ArrayList<Integer>> adj;
	public static boolean visited[];
	public static int[] component;
	public static int[][] cache;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		adj = new ArrayList<>();
		visited = new boolean[N+1];
		component = new int[N+1];
		cache = new int[N+1][N+1];
		
		for (int i = 0; i <= N; i++) adj.add(new ArrayList<Integer>());

		for (int i = 0; i < N - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj.get(a).add(b);
			adj.get(b).add(a);
		}

		sc.close();
		
		dfs(1);
		
		for (int i=1; i<=N; i++) {
			System.out.println(component[i]);
		}

				
	}
	

	

	public static int dfs(int node) {

		visited[node] = true;

		int children = 1;
		for (int next : adj.get(node)) {
			if (!visited[next]) children += dfs(next);
		}
		
		for(int i=0; i<children; i++) {
			cache[node][i] = 1;
		}

		
		cache[node][children] = 1;		
		return component[node] = children;
	
	}
	
	

}
