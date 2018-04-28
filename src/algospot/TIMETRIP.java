package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class TIMETRIP {

	public static final int MAX = 987654321;
	public static int V, W;
	public static int[] D;
	public static List<List<P>> adjacent;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			D = new int[V + 1];
			Arrays.fill(D, MAX);
			D[0] = 0;
			adjacent = new ArrayList<>();

			for (int v = 0; v < V; v++) {
				adjacent.add(new ArrayList<>());
			}

			for (int w = 0; w < W; w++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int distance = Integer.parseInt(st.nextToken());
				adjacent.get(from).add(new P(to, distance));
			}

			BellmanFord();

		}

		br.close();

	}

	public static void BellmanFord() {

		boolean relax = false;
		for (int i = 0; i < V; i++) {
			relax = false;
			for (int j = 0; j < V; j++) {
				List<P> adj = adjacent.get(j);
				for (int k = 0; k < adj.size(); k++) {
					P pair = adj.get(k);
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

		System.out.println(D[1]);
		
		if (relax) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		return;

	}

}

class P {

	int to;
	int dist;

	public P(int to, int dist) {
		super();
		this.to = to;
		this.dist = dist;
	}

}
