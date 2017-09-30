package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Journey {
	
	public static boolean[] visited;
	public static List<ArrayList<Integer>> adjacent;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int astronauts = sc.nextInt();
		int pairs = sc.nextInt();
		visited = new boolean[astronauts];
		adjacent = new ArrayList<ArrayList<Integer>>();
				
		for(int a=0; a<astronauts; a++)	adjacent.add(new ArrayList<Integer>());
		
		for(int p=0; p<pairs; p++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			adjacent.get(a).add(b);
			adjacent.get(b).add(a);
		}
		
		sc.close();
		
		long total = 0;
		long midSum = 0;
		for(int a=0; a<astronauts; a++){
			if(visited[a]==false){
				long size = dfs(a);
				total += midSum*size;
				midSum += size;
			}
		}
		System.out.println(total);
		
	}
	
	public static int dfs(int start){
		
		visited[start] = true;
		int ret = 1;
		
		List<Integer> adj = adjacent.get(start);
		for(int i=0; i<adj.size(); i++){
			int end = adj.get(i);
			if(visited[end]==false) ret += dfs(end);
		}
		
		return ret;
		
	}

}
