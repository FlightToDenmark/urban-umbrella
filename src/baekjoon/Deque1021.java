package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Deque1021 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer> deque = new LinkedList<>();

		for (int n = 1; n <= N; n++) {
			deque.add(n);
		}

		int total = 0;

		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {

			int a = Integer.parseInt(st.nextToken());

			int idxFromLeft = deque.indexOf(a);

			if (idxFromLeft == 0) {
				deque.remove(new Integer(a));
				continue;
			}

			int idxFromRight = deque.size() - idxFromLeft;

			if (idxFromLeft < idxFromRight) {

				while (idxFromLeft-- > 0) {
					int shift = deque.remove(0);
					deque.add(shift);
					total++;
				}

				deque.remove(new Integer(a));

			} else {

				while (idxFromRight-- > 0) {
					int shift = deque.remove(deque.size() - 1);
					deque.add(0, shift);
					total++;
				}

				deque.remove(new Integer(a));

			}

		}

		System.out.println(total);

	}

}
