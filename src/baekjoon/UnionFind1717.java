package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UnionFind1717 {

	static int[] rank, parent;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		rank = new int[N + 1];
		Arrays.fill(rank, 1);
		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) parent[i] = i;

		int a, b, c;
		for (int m = 0; m < M; m++) {
			
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if (a == 0)	union(b, c);
			else {
				if (find(b) == find(c)) System.out.println("YES");
				else System.out.println("NO");
			}

		}

	}

	static void union(int x, int y) {

		x = find(x);
		y = find(y);

		if (x == y)	return;

		if (rank[y] > rank[x]) { // x > y
			int tmp = x;
			x = y;
			y = tmp;
		}

		parent[y] = x;
		if (rank[x] == rank[y])	rank[x]++;

	}

	static int find(int x) {

		while (x != parent[x]) x = parent[x];
		return x;

	}

}

