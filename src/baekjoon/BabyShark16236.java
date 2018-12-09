package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BabyShark16236 {

	static final int BABY = 9;
	static int N, eat, size = 2;
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Queue<S> queue = new LinkedList<>();
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == BABY) {
					queue.add(new S(i, j, 0));
					visited[i][j] = true;
					map[i][j] = 0;
				}
			}
		}
		findShark();

	}

	static void findShark() {

		int x, y, dist, eatX, eatY, eatDist, sizeQ;
		int answer = 0;
		while (!queue.isEmpty()) {
			eatX = 123;
			eatY = 123;
			eatDist = 123;
			sizeQ = queue.size();
			for (int s = 0; s < sizeQ; s++) {
				S here = queue.poll();
				x = here.x;
				y = here.y;
				dist = here.dist;
				for (int i = 0; i < 4; i++) {
					int newX = x + dx[i];
					int newY = y + dy[i];
					if (newX >= 0 && newX < N && newY >= 0 && newY < N && !visited[newX][newY] && map[newX][newY] <= size) {
						visited[newX][newY] = true;
						queue.add(new S(newX, newY, dist + 1));
						if (map[newX][newY] != 0 && map[newX][newY] < size) {
							if ((newX < eatX) || (newX == eatX && newY < eatY)) {
								eatX = newX;
								eatY = newY;
								eatDist = dist + 1;
							}
						}
					}
				}
			}

			if (eatX != 123) {
				answer += eatDist;
				eat++;
				if (eat == size) {
					size++;
					eat = 0;
				}
				for (boolean[] b : visited) {
					Arrays.fill(b, false);
				}
				queue.clear();
				map[eatX][eatY] = 0;
				visited[eatX][eatY] = true;
				queue.add(new S(eatX, eatY, 0));
			}

		}
		System.out.println(answer);

	}

}

class S {

	int x, y, dist;

	public S(int x, int y, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.dist = dist;
	}

}
