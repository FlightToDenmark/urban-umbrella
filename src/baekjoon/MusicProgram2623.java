package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class MusicProgram2623 {

	static int[] inbound;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<ArrayList<Integer>> adjacent = new LinkedList<>();
		List<Integer> order = new LinkedList<>();
		for (int n = 0; n <= N; n++) {
			adjacent.add(new ArrayList<Integer>());
		}

		inbound = new int[N + 1];
		int S, prev, next;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			prev = Integer.parseInt(st.nextToken());
			for (int s = 1; s < S; s++) {
				next = Integer.parseInt(st.nextToken());
				adjacent.get(prev).add(next);
				inbound[next]++;
				prev = next;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int n = 1; n <= N; n++) {
			if (inbound[n] == 0)
				queue.add(n);
		}

		for (int n = 1; n <= N; n++) {

			if (queue.isEmpty()) {
				bw.write(0 + "\n");
				bw.flush();
				System.exit(0);
			}

			int here = queue.poll();
			order.add(here);
			for (int to : adjacent.get(here)) {
				if (--inbound[to] == 0) {
					queue.add(to);
				}
			}

		}

		for (int o : order) {
			bw.write(o + "\n");
		}
		bw.flush();

	}

}
