package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Knight7562 {

	static int size;
	static int startX, startY, endX, endY;
	static int[][] dist;
	static int[] moveX = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] moveY = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static Queue<Point> Q;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {

			size = Integer.parseInt(br.readLine());
			Q = new LinkedList<>();
			dist = new int[size][size];
			StringTokenizer st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());

			dist[startX][startY] = 0;
			Q.add(new Point(startX, startY));
			bfs();

		}

	}

	static void bfs() {

		while (true) {

			Point point = Q.poll();
			int x = point.x;
			int y = point.y;

			if (x == endX && y == endY) {
				System.out.println(dist[x][y]);
				break;
			}

			for (int i = 0; i < 8; i++) {
				int newX = x + moveX[i];
				int newY = y + moveY[i];
				if (newX >= 0 && newY >= 0 && newX < size && newY < size && dist[newX][newY] == 0) {
					dist[newX][newY] = dist[x][y] + 1;
					Q.add(new Point(newX, newY));
				}
			}

		}

	}

}

class Point {

	int x, y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

