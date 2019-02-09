package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chicken15686 {

	static boolean[] visited;
	static int N, M, answer = Integer.MAX_VALUE;
	static int[][] C, dist; // dist[home][chicken];
	static Pair[] home = new Pair[100], chicken = new Pair[13];
	static int totalHome, totalChicken;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				C[i][j] = Integer.parseInt(st.nextToken());
				if (C[i][j] == 1) {
					home[totalHome++] = new Pair(i, j);
				}
				if (C[i][j] == 2) {
					chicken[totalChicken++] = new Pair(i, j);
				}
			}
		}

		dist = new int[totalHome][totalChicken];
		for (int i = 0; i < totalHome; i++) {
			for (int j = 0; j < totalChicken; j++) {
				dist[i][j] = abs(home[i].x - chicken[j].x) + abs(home[i].y - chicken[j].y);
			}
		}

		visited = new boolean[totalChicken];
		choosePlace(0, 0);
		System.out.println(answer);

	}

	static void choosePlace(int start, int total) {

		if (total == M) {
			int sum = 0;
			for (int i = 0; i < totalHome; i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < totalChicken; j++) {
					if (visited[j]) {
						min = Math.min(min, dist[i][j]);
					}
				}
				sum += min;
			}
			if (sum < answer) {
				answer = sum;
			}
			return;
		}

		for (int i = start; i < totalChicken; i++) {
			if (!visited[i]) {
				visited[i] = true;
				choosePlace(start + 1, total + 1);
				visited[i] = false;
			}
		}

	}

	static int abs(int a) {

		if (a >= 0) {
			return a;
		} else {
			return -a;
		}

	}

	static class Pair {

		int x, y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}
