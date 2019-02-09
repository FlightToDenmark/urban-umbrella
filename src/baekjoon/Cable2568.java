package baekjoon;

import java.io.*;
import java.util.*;

public class Cable2568 {

	static int[] L, inc;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		L = new int[N + 1];
		inc = new int[N + 1];
		List<Pair> list = new ArrayList<>(N);
		StringTokenizer st;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);

		int index = 0, increase = 0;
		L[index] = Integer.MIN_VALUE;
		for (int n = 0; n < N; n++) {
			if (list.get(n).number > L[index]) {
				L[++index] = list.get(n).number;
				inc[n] = increase++;
			} else {
				int lb = lowerBound(0, index, list.get(n).number) - 1;
				L[lb] = list.get(n).number;
				inc[n] = lb - 1;
			}
		}

		bw.write(N - index + "\n");
		int L = increase - 1;
		for (int i = N - 1; i >= 0; i--) {
			if (L == inc[i]) {
				list.get(i).number = 0;
				L--;
			}
		}

		for (int n = 0; n < N; n++) {
			if (list.get(n).number != 0) {
				bw.write(list.get(n).index + "\n");
			}
		}
		bw.close();

	}

	static int lowerBound(int start, int end, int target) {

		int mid;
		while (start < end) {
			mid = (start + end) / 2;
			if (L[mid] < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return end + 1;

	}

	static class Pair implements Comparable<Pair> {

		int index, number;

		public Pair(int index, int number) {
			super();
			this.index = index;
			this.number = number;
		}

		@Override
		public int compareTo(Pair pair) {
			return this.index - pair.index;
		}

	}

}
