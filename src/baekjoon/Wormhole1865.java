package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Wormhole1865 {

	public static final int MAX = 987654321;
	public static int N, M, W;
	public static int[] D;
	public static List<List<Pair>> adjacent;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			D = new int[N + 1];
			Arrays.fill(D, MAX);
			D[1] = 0;
			adjacent = new ArrayList<>();

			for (int n = 0; n <= N; n++) {
				adjacent.add(new ArrayList<>());
			}

			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int distance = Integer.parseInt(st.nextToken());
				adjacent.get(from).add(new Pair(to, distance));
				adjacent.get(to).add(new Pair(from, distance));
			}

			for (int w = 0; w < W; w++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int distance = Integer.parseInt(st.nextToken());
				adjacent.get(from).add(new Pair(to, -distance));
			}

			BellmanFord();

		}

		br.close();

	}

	public static void BellmanFord() {

		boolean relax = false;
		for (int i = 0; i < N; i++) {
			relax = false;
			for (int j = 1; j <= N; j++) {
				List<Pair> adj = adjacent.get(j);
				for (int k = 0; k < adj.size(); k++) {
					Pair pair = adj.get(k);
					int to = pair.to;
					int dist = pair.dist;
					if (D[to] > D[j] + dist) {
						D[to] = D[j] + dist;
						relax = true;
					}
				}

			}
			if (!relax)
				break;
		}

		if (relax) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		return;

	}

}

class Pair {

	int to;
	int dist;

	public Pair(int to, int dist) {
		super();
		this.to = to;
		this.dist = dist;
	}

}
