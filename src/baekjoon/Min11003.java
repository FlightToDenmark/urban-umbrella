package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Min11003 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Deque<Pair> deque = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		int input;
		for (int n = 0; n < N; n++) {
			input = Integer.parseInt(st.nextToken());
			while (!deque.isEmpty() && deque.peekLast().value > input) {
				deque.pollLast();
			}
			if (!deque.isEmpty() && deque.peekFirst().index <= n - L) {
				deque.pollFirst();
			}
			deque.addLast(new Pair(n, input));
			bw.write(deque.peekFirst().value + " ");
		}
		bw.flush();
		bw.close();

	}

	public static class Pair {

		int index, value;

		public Pair(int index, int value) {
			super();
			this.index = index;
			this.value = value;
		}

	}

}
