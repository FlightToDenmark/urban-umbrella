package cf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Pair[] song = new Pair[N];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			song[n] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(song, (a, b) -> (b.beauty - a.beauty));
		Queue<Pair> pq = new PriorityQueue<>((a, b) -> (a.length - b.length));
		long sum = 0, max = 0;
		for (int n = 0; n < N; n++) {
			pq.add(song[n]);
			sum += song[n].length;
			if (pq.size() > K) {
				sum -= pq.poll().length;
			}
			max = Math.max(max, sum * song[n].beauty);
		}
		bw.write(max + "\n");
		bw.close();

	}

	public static class Pair {

		int length, beauty;

		public Pair(int length, int beauty) {
			super();
			this.length = length;
			this.beauty = beauty;
		}

	}

}
