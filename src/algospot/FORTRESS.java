package algospot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FORTRESS {

	public static int node;
	public static int[] x, y, r;
	public static List<ArrayList<Integer>> children;
	public static int longest;
	public static boolean[] visited;
	
	public static void main(String[] args) {

		// Integer[] values = {12, 8, 3, 44, 5};
		// Arrays.sort(values, Integer::compare);
		// System.out.println(Arrays.asList(values));

		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		while (testCase-- > 0) {
			node = sc.nextInt();
			x = new int[node];
			y = new int[node];
			r = new int[node];
			visited = new boolean[node];
			children = new ArrayList<>();
			for (int n = 0; n < node; n++) {
				children.add(new ArrayList<Integer>());
				x[n] = sc.nextInt();
				y[n] = sc.nextInt();
				r[n] = sc.nextInt();
			}
			
			System.out.println(solve());

		}

		sc.close();

	}

	public static boolean encloses(int a, int b) {

		int rDiff = r[a] - r[b];
		return rDiff > 0 && Math.pow(rDiff, 2) > sqrtDist(a, b);

	}

	public static double sqrtDist(int a, int b) {

		return Math.pow(x[a] - x[b], 2) + Math.pow(y[a] - y[b], 2);

	}

	public static boolean isChild(int parent, int child) {

		if (!encloses(parent, child))
			return false;

		for (int n = 0; n < node; n++)
			if (n != parent && n != child && encloses(parent, n) && encloses(n, child))
				return false;

		return true;

	}

	public static int makeTree(int root) {
		
		visited[root] = true;

		for (int n = 0; n < node; n++) {
			if (!visited[n] && isChild(root, n)) {
				children.get(root).add(makeTree(n));
			}
		}		
		return root;

	}

	public static int treeHeight(int root) {

		List<Integer> heights = new ArrayList<>();

//		System.out.println(Arrays.asList(children));
		
		for (int n : children.get(root)) heights.add(treeHeight(n));
		
		if(heights.size() == 0) return 0;
		
//		Collections.sort(heights, Integer::compare);
		Collections.sort(heights);
		
//		System.out.println(Arrays.asList(heights));

		int size = heights.size();
		if (size >= 2) longest = Math.max(longest, heights.get(size - 1) + heights.get(size - 2) + 2);

		return heights.get(size - 1) + 1;

	}
	
	public static int solve() {
		
		makeTree(0);
		longest = 0;
		int height = treeHeight(0);
		return Math.max(longest, height);
	
	}

}
