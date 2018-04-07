package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FamilyTree {

	public static ArrayList<ArrayList<Integer>> child;
	public static int[] no2serial, serial2no, locInTrip, depth;
	public static List<Integer> trip;
	public static int nextSerial;
	public static NewRMQ nrmq;
	public static RMQ1 rmq;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st1.nextToken());
			int Q = Integer.parseInt(st1.nextToken());
			child = new ArrayList<>();
			no2serial = new int[N];
			serial2no = new int[N];
			locInTrip = new int[N];
			depth = new int[N];
			trip = new ArrayList<>();
			nextSerial = 0;
			for (int i = 0; i < N; i++)	child.add(new ArrayList<Integer>());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 1; i < N; i++) child.get(Integer.parseInt(st2.nextToken())).add(i);
			traverse(0, 0);
			Integer[] travel = new Integer[trip.size()];
			travel = trip.toArray(travel);
//			rmq = new NewRMQ(trip);
			rmq = new RMQ1(travel);

			for (int q = 0; q < Q; q++) {
				StringTokenizer st3 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st3.nextToken());
				int b = Integer.parseInt(st3.nextToken());
				System.out.println(distance(a, b));
			}

		}

	}

	public static void traverse(int here, int d) {

		no2serial[here] = nextSerial;
		serial2no[nextSerial] = here;
		nextSerial++;

		depth[here] = d;

		locInTrip[here] = trip.size();
		trip.add(no2serial[here]);

		for (Integer c : child.get(here)) {
			traverse(c, d + 1);
			trip.add(no2serial[here]);
		}

	}

	public static int distance(int u, int v) {

		int lu = locInTrip[u], lv = locInTrip[v];

		if (lu > lv) {
			int temp = lu;
			lu = lv;
			lv = temp;
		}

		int lca = serial2no[rmq.query(lu, lv)];

		return depth[u] + depth[v] - 2 * depth[lca];

	}

}

class NewRMQ {

	int n;
	int[] rangeMin;

	public NewRMQ(ArrayList<Integer> array) {
		this.n = array.size();
		this.rangeMin = new int[n * 4];
		init(array, 0, n - 1, 1);
	}

	int init(ArrayList<Integer> array, int left, int right, int node) {

		if (left == right)
			return rangeMin[node] = array.get(left);

		int mid = (left + right) / 2;
		int leftMin = init(array, left, mid, node * 2);
		int rightMin = init(array, mid + 1, right, node * 2 + 1);

		return rangeMin[node] = Math.min(leftMin, rightMin);

	}

	int query(int left, int right) {
		return query(left, right, 1, 0, n - 1);
	}

	int query(int left, int right, int node, int nodeLeft, int nodeRight) {

		if (right < nodeLeft || nodeRight < left)
			return Integer.MAX_VALUE;

		if (left <= nodeLeft && nodeRight <= right)
			return rangeMin[node];

		int mid = (nodeLeft + nodeRight) / 2;

		return Math.min(query(left, right, node * 2, nodeLeft, mid),
				query(left, right, node * 2 + 1, mid + 1, nodeRight));
		
	}

}

class RMQ1 {

	int n;
	int[] rangeMin;

	public RMQ1(Integer[] array) {
		this.n = array.length;
		this.rangeMin = new int[n * 4];
		init(array, 0, n - 1, 1);
	}

	int init(Integer[] array, int left, int right, int node) {

		if (left == right) return rangeMin[node] = array[left];

		int mid = (left + right) / 2;
		int leftMin = init(array, left, mid, node * 2);
		int rightMin = init(array, mid + 1, right, node * 2 + 1);

		return rangeMin[node] = Math.min(leftMin, rightMin);

	}

	int query(int left, int right) {
		return query(left, right, 1, 0, n - 1);
	}

	int query(int left, int right, int node, int nodeLeft, int nodeRight) {

		if (right < nodeLeft || nodeRight < left) return Integer.MAX_VALUE;

		if (left <= nodeLeft && nodeRight <= right)	return rangeMin[node];

		int mid = (nodeLeft + nodeRight) / 2;

		return Math.min(query(left, right, node * 2, nodeLeft, mid),
				query(left, right, node * 2 + 1, mid + 1, nodeRight));
	}

}
