package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoadsAndLibraries {

	public static List<ArrayList<Integer>> adjacent;
	public static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int query = sc.nextInt();

		while (query-- > 0) {

			int city = sc.nextInt();
			int road = sc.nextInt();
			long coLib = sc.nextInt();
			long coRo = sc.nextInt();

			if(coRo>=coLib) {
				System.out.println(city*coLib);
				for (int r = 0; r < road; r++) {
					sc.nextInt(); sc.nextInt();
				}
				continue;
			}
			
			adjacent = new ArrayList<>();
			visited = new boolean[city + 1];

			for (int c = 0; c <= city; c++)	adjacent.add(new ArrayList<>());

			for (int r = 0; r < road; r++) {
				int cityA = sc.nextInt();
				int cityB = sc.nextInt();
				adjacent.get(cityA).add(cityB);
				adjacent.get(cityB).add(cityA);
			}

			long totalCost = 0;
			for (int c = 1; c <= city; c++)
				if (!visited[c]) totalCost += (dfs(c)-1) * coRo + coLib;
			
			System.out.println(totalCost);
		
		}

		sc.close();

	}

	public static int dfs(int city) {

		visited[city] = true;
		List<Integer> adj = adjacent.get(city);

		int member = 1;
		
		for(int to : adj) if (!visited[to]) member += dfs(to);
		
		return member;
		
	}

}
