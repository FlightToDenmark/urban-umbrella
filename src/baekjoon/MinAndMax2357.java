package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinAndMax2357 {

	public static long[] a, b;
	public static long[][] min;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int length = Integer.parseInt(st1.nextToken());
		int way = Integer.parseInt(st1.nextToken());

		a = new long[length + 1];
		b = new long[length + 1];
		for (int i = 1; i <= length; i++) {
			a[i] = Integer.parseInt(br.readLine());
			b[i] = -a[i];
		}

		RMQ min = new RMQ(a);
		RMQ max = new RMQ(b);

		for (int i = 0; i < way; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st2.nextToken());
			int to = Integer.parseInt(st2.nextToken());
			System.out.println(min.query(from, to) + " " + -max.query(from, to));
		}

		br.close();

	}

}

//class RMQ {
//
//	int n;
//	long[] rangeMin;
//
//	public RMQ(long[] array) {
//		this.n = array.length;
//		this.rangeMin = new long[n * 4];
//		init(array, 0, n - 1, 1);
//	}
//
//	long init(long[] array, int left, int right, int node) {
//
//		if (left == right)
//			return rangeMin[node] = array[left];
//
//		int mid = (left + right) / 2;
//		long leftMin = init(array, left, mid, node * 2);
//		long rightMin = init(array, mid + 1, right, node * 2 + 1);
//
//		return rangeMin[node] = Math.min(leftMin, rightMin);
//
//	}
//
//	long query(int left, int right) {
//		return query(left, right, 1, 0, n - 1);
//	}
//
//	long query(int left, int right, int node, int nodeLeft, int nodeRight) {
//
//		if (right < nodeLeft || nodeRight < left)
//			return Integer.MAX_VALUE;
//
//		if (left <= nodeLeft && nodeRight <= right)
//			return rangeMin[node];
//
//		int mid = (nodeLeft + nodeRight) / 2;
//
//		return Math.min(query(left, right, node * 2, nodeLeft, mid),
//				query(left, right, node * 2 + 1, mid + 1, nodeRight));
//	}
//
//}
