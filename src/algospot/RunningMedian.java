package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class RunningMedian {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			RNG rng = new RNG(a, b);
			System.out.println(runningMedian(N, rng));
		}

	}

	public static int runningMedian(int N, RNG rng) {

		Queue<Integer> minHeap = new PriorityQueue<>();
		Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		int ret = 0;

		for (int n = 1; n <= N; n++) {
			if (maxHeap.size() == minHeap.size()) maxHeap.add(rng.next());
			else minHeap.add(rng.next());

			if (!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
				int a = maxHeap.poll(); int b = minHeap.poll();
				maxHeap.add(b);
				minHeap.add(a);
			}
			ret = (ret + maxHeap.peek()) % 20090711;
		}
		return ret	;

	}

}

class RNG {

	int seed, a, b;

	public RNG(int a, int b) {
		this.a = a;
		this.b = b;
		this.seed = 1983;
	}

	public int next() {
		int ret = seed;
		seed = Math.toIntExact(((seed * (long)a) + b) % 20090711);
		return ret;
	}

}
