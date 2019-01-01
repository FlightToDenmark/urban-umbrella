package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Cow14469 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Queue<Pair> pq = new PriorityQueue<>();
		StringTokenizer st;
		int a, b, endTime = 0;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			pq.add(new Pair(a, b));
		}
		Pair here;
		for (int n = 0; n < N; n++) {
			here = pq.poll();
			endTime = Math.max(endTime, here.arrive);
			endTime += here.time;
		}
		bw.write(endTime + "\n");
		bw.flush();
		bw.close();

	}

	public static class Pair implements Comparable<Pair> {

		int arrive, time;

		public Pair(int arrive, int time) {
			super();
			this.arrive = arrive;
			this.time = time;
		}

		@Override
		public int compareTo(Pair pair) {
			return this.arrive - pair.arrive;
		}

	}

}
