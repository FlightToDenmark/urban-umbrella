package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class TIMETRIP {

	static final int INF = 987654321;
	static int V, W;
	static int[] D1, D2;
	static boolean[][] D; // D for Floyd-Warshall
	static List<List<P>> adjacent1;
	static List<List<P>> adjacent2;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			D = new boolean[V][V];
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					D[i][j] = (i == j) ? true : false;
				}
			}
			D1 = new int[V];
			D2 = new int[V];
			Arrays.fill(D1, INF);
			D1[0] = 0;
			Arrays.fill(D2, INF);
			D2[0] = 0;
			adjacent1 = new ArrayList<>();
			adjacent2 = new ArrayList<>();

			for (int v = 0; v < V; v++) {
				adjacent1.add(new ArrayList<>());
				adjacent2.add(new ArrayList<>());
			}

			for (int w = 0; w < W; w++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int distance = Integer.parseInt(st.nextToken());
				D[from][to] = true;
				adjacent1.get(from).add(new P(to, distance));
				adjacent2.get(from).add(new P(to, -distance));
			}

			FloydWarshall();
			BellmanFord();

		}

		br.close();

	}

	public static void BellmanFord() {

		boolean relax1 = false;
		boolean relax2 = false;
		for (int i = 0; i < V - 1; i++) {
			relax1 = false;
			relax2 = false;
			for (int j = 0; j < V; j++) {
				List<P> adj1 = adjacent1.get(j);
				List<P> adj2 = adjacent2.get(j);
				for (int k = 0; k < adj1.size(); k++) {
					P p1 = adj1.get(k);
					int to1 = p1.to;
					int dist1 = p1.dist;
					if (D1[to1] > D1[j] + dist1) {
						D1[to1] = D1[j] + dist1;
						relax1 = true;
					}
					P p2 = adj2.get(k);
					int to2 = p2.to;
					int dist2 = p2.dist;
					if (D2[to2] > D2[j] + dist2) {
						D2[to2] = D2[j] + dist2;
						relax2 = true;
					}
				}

			}
			if (!relax1 && !relax2)	break;
		}

		relax1 = false;
		relax2 = false;
		for (int j = 0; j < V; j++) {
			List<P> adj1 = adjacent1.get(j);
			List<P> adj2 = adjacent2.get(j);
			for (int k = 0; k < adj1.size(); k++) {
				P p1 = adj1.get(k);
				P p2 = adj2.get(k);
				int to1 = p1.to;
				int dist1 = p1.dist;
				if (D1[to1] > D1[j] + dist1) {
					if (D[0][j] && D[j][1]) {
						relax1 = true;
					}
				}
				int to2 = p2.to;
				int dist2 = p2.dist;
				if (D2[to2] > D2[j] + dist2) {
					if (D[0][j] && D[j][1]) {
						relax2 = true;
					}
				}
			}

		}

		if (D1[1] == INF || D2[1] == INF) {
			System.out.println("UNREACHABLE");
			return;
		}

		System.out.println(((!relax1) ? D1[1] : "INFINITY") + " " + ((!relax2) ? -D2[1] : "INFINITY"));

	}

	public static void FloydWarshall() {

		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					D[i][j] = (D[i][j] || (D[i][k] && D[k][j]));
				}
			}
		}

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
