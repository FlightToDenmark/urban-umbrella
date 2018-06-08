import java.util.LinkedList;
import java.util.Queue;

public class Test2 {

	static int[] capacity;
	static boolean[][][] visited;
	static Queue<int[]> q;

	public static void main(String[] args) {

	}

	public static int solution(int a, int b, int c, int d) {

		capacity = new int[] { 0, a, b, c };
		visited = new boolean[101][101][101];

		q = new LinkedList<>();
		q.add(new int[] { 0, 0, 0, 0 });
		visited[0][0][0] = true;

		while (!q.isEmpty()) {

			int[] status = q.poll();

			for (int i = 1; i <= 3; i++) {
				if (status[i] == d) {
					return status[0];
				}
			}

			// fill or remove
			for (int i = 1; i <= 3; i++) {
				int[] newStatus = { status[0] + 1, status[1], status[2], status[3] };
				if (status[i] < capacity[i]) {
					newStatus[i] = capacity[i];
				}
				if (status[i] > 0) {
					newStatus[i] = 0;
				}
				if (!visited[newStatus[1]][newStatus[2]][newStatus[3]]) {
					visited[newStatus[1]][newStatus[2]][newStatus[3]] = true;
					q.add(newStatus);
				}
			}

			// move
			for (int i = 1; i <= 3; i++) {
				for (int j = 1; j <= 3; j++) {
					if (i == j)	continue;
					if (status[i] != 0 && capacity[j] > status[j]) {
						int[] newStatus = { status[0] + 1, status[1], status[2], status[3] };
						if (capacity[j] - newStatus[j] >= newStatus[i]) {
							newStatus[j] += newStatus[i];
							newStatus[i] = 0;
						} else {
							newStatus[i] -= (capacity[j] - newStatus[j]);
							newStatus[j] = capacity[j];
						}
						if (!visited[newStatus[1]][newStatus[2]][newStatus[3]]) {
							visited[newStatus[1]][newStatus[2]][newStatus[3]] = true;
							q.add(newStatus);
						}
					}
				}
			}

		}

		return -1;

	}

}
