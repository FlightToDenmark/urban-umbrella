package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EditorWars {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-->0) {

			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st1.nextToken());
			int M = Integer.parseInt(st1.nextToken());
			UnionFind uf = new UnionFind(N);

			StringTokenizer st2;
			int contradict = 0;
			for (int m = 0; m < M; m++) {

				st2 = new StringTokenizer(br.readLine());
				String s = st2.nextToken();
				int u = Integer.parseInt(st2.nextToken());
				int v = Integer.parseInt(st2.nextToken());

				if(contradict==0) {
					
					boolean bool = true;
	
					if (s.equals("ACK")) bool = uf.ack(u, v);
					else bool = uf.dis(u, v);
	
					if (!bool) contradict = m + 1;
				
				}

			}

			if (contradict == 0) System.out.println("MAX PARTY SIZE IS " + uf.partyMax());
			else System.out.println("CONTRADICTION AT " + contradict);

		}

	}

}

class UnionFind {

	int n;
	int[] parent, rank, enemy, size;

	public UnionFind(int n) {

		super();
		this.n = n;
		parent = new int[n];
		rank = new int[n];
		enemy = new int[n];
		size = new int[n];

		for (int i = 0; i < n; i++) parent[i] = i;
		Arrays.fill(rank, 0);
		Arrays.fill(enemy, -1);
		Arrays.fill(size, 1);

	}

	int find(int u) {

		if (parent[u] == u) return u;
		return parent[u] = find(parent[u]);

	}

	int union(int u, int v) {

		if (u == -1 || v == -1) return Math.max(u, v);

		u = find(u);
		v = find(v);

		if (u == v)	return u;

		if (rank[u] > rank[v]) {
			int tmp = u;
			u = v;
			v = tmp;
		}

		if (rank[u] == rank[v])	rank[v]++;

		parent[u] = v;

		size[v] += size[u];

		return v;

	}

	boolean dis(int u, int v) {

		u = find(u);
		v = find(v);

		if (u == v) return false;

		int a = union(u, enemy[v]);
		int b = union(v, enemy[u]);

		enemy[a] = b;
		enemy[b] = a;

		return true;

	}

	boolean ack(int u, int v) {

		u = find(u);
		v = find(v);

		if (enemy[u] == v) return false;

		int a = union(u, v);
		int b = union(enemy[u], enemy[v]);

		enemy[a] = b;
		if (b != -1) enemy[b] = a;
		return true;

	}

	int partyMax() {

		int ret = 0;

		for (int node = 0; node < n; node++) {
			if (parent[node] == node) {
				int e = enemy[node];
				if (e > node) continue;
				int s1 = size[node];
				int s2 = (e == -1 ? 0 : size[e]);
				ret += Math.max(s1, s2);
			}
		}

		return ret;

	}

}
