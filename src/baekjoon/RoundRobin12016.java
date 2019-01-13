package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class RoundRobin12016 {

	static int N;
	static int[] tree;
	static long[] answer;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		tree = new int[N + 1];
		answer = new long[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Task> pq = new PriorityQueue<>();
		for (int n = 1; n <= N; n++) {
			update(n, 1);
			pq.offer(new Task(n, Integer.parseInt(st.nextToken())));
		}

		Task task;
		long time, totalTime = 0, before = 0;
		int a, b, num, total = N;
		for (int n = 0; n < N; n++) {
			task = pq.poll();
			num = task.num;
			time = task.time - before;
			a = sum(num);
			b = total--; // sum(N)
			totalTime += b * (time - 1) + a;// a * time + (b - a) * (time - 1);
			answer[num] = totalTime;
			update(num, -1);
			before += time;
			totalTime += b - a;
		}

		for (int n = 1; n <= N; n++) {
			bw.write(answer[n] + "\n");
		}
		bw.flush();

	}

	static void update(int i, int value) {

		while (i <= N) {
			tree[i] += value;
			i += (i & -i);
		}

	}

	static int sum(int i) {

		int total = 0;
		while (i > 0) {
			total += tree[i];
			i -= (i & -i);
		}
		return total;

	}

	static class Task implements Comparable<Task> {

		int num, time;

		public Task(int num, int time) {
			super();
			this.num = num;
			this.time = time;
		}

		@Override
		public int compareTo(Task task) {
			return (this.time == task.time) ? this.num - task.num : this.time - task.time;
		}

	}

}