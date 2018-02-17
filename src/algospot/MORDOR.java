package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MORDOR {

	public static int[] h, h_minus;
	public static int[][] min, max;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {

			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st1.nextToken());
			int way = Integer.parseInt(st1.nextToken());

			h = new int[height];
			h_minus = new int[height];
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < height; i++) {
				h[i] = Integer.parseInt(st2.nextToken());
				h_minus[i] = -h[i];
			}

			RMQ rmq = new RMQ(h);
			RMQ rmq_minus = new RMQ(h_minus);

			for (int i = 0; i < way; i++) {
				StringTokenizer st3 = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st3.nextToken());
				int to = Integer.parseInt(st3.nextToken());
				System.out.println(-rmq_minus.query(from, to) - rmq.query(from, to));
			}

		}

		br.close();

	}

}

class RMQ {

	int n;
	int[] rangeMin;

	public RMQ(int[] array) {
		this.n = array.length;
		this.rangeMin = new int[n * 4];
		init(array, 0, n - 1, 1);
	}

	int init(int[] array, int left, int right, int node) {

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
