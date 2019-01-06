package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SVEMIR2887 {

	static int[] parent;
	static PointP[] pointX, pointY, pointZ;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		parent = new int[N];
		pointX = new PointP[N];
		pointY = new PointP[N];
		pointZ = new PointP[N];
		int x, y, z;
		for (int n = 0; n < N; n++) {
			parent[n] = n;
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			pointX[n] = new PointP(n, x, y, z);
			pointY[n] = new PointP(n, x, y, z);
			pointZ[n] = new PointP(n, x, y, z);
		}

		Arrays.sort(pointX, (p1, p2) -> (p1.x - p2.x));
		Arrays.sort(pointY, (p1, p2) -> (p1.y - p2.y));
		Arrays.sort(pointZ, (p1, p2) -> (p1.z - p2.z));
		PriorityQueue<EdgeE> pq = new PriorityQueue<>();
		for (int n = 1; n < N; n++) {
			pq.offer(new EdgeE(pointX[n - 1].num, pointX[n].num, abs(pointX[n - 1].x - pointX[n].x)));
			pq.offer(new EdgeE(pointY[n - 1].num, pointY[n].num, abs(pointY[n - 1].y - pointY[n].y)));
			pq.offer(new EdgeE(pointZ[n - 1].num, pointZ[n].num, abs(pointZ[n - 1].z - pointZ[n].z)));
		}

		EdgeE edge;
		int count = 0;
		long total = 0;
		while (!pq.isEmpty()) {
			edge = pq.poll();
			if (union(edge.from, edge.to)) {
				total += edge.cost;
				count++;
			}
			if (count == N - 1) {
				break;
			}
		}
		bw.write(total + "\n");
		bw.flush();
		bw.close();

	}

	static int find(int a) {

		while (a != parent[a]) {
			a = parent[a];
		}
		return a;

	}

	static boolean union(int a, int b) {

		a = find(a);
		b = find(b);
		if (a == b) {
			return false;
		}
		if (a > b) { // a < b
			int tmp = a;
			a = b;
			b = tmp;
		}
		parent[b] = a;
		return true;

	}

	static int abs(int x) {

		if (x < 0) {
			return -x;
		}
		return x;

	}

}

class EdgeE implements Comparable<EdgeE> {

	int from, to, cost;

	public EdgeE(int from, int to, int cost) {
		super();
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	public int compareTo(EdgeE edge) {
		return this.cost - edge.cost;
	}

}

class PointP {

	int num, x, y, z;

	public PointP(int num, int x, int y, int z) {
		super();
		this.num = num;
		this.x = x;
		this.y = y;
		this.z = z;
	}

}
