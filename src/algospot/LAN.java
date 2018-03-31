package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LAN {

	public static int N;
	public static int[] x, y;
	public static double[] minDistance;
	public static boolean[] added;
	public static double[][] distance;
	public static final int INF = 987654321;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			x = new int[N];
			y = new int[N];
			StringTokenizer stX = new StringTokenizer(br.readLine());
			StringTokenizer stY = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				x[n] = Integer.parseInt(stX.nextToken());
				y[n] = Integer.parseInt(stY.nextToken());
			}

			init();

			for (int m = 0; m < M; m++) {
				StringTokenizer stE = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(stE.nextToken());
				int b = Integer.parseInt(stE.nextToken());

				distance[a][b] = distance[b][a] = 0;
			}

			System.out.println(prim());

		}

	}

	public static void init() {

		added = new boolean[N];
		minDistance = new double[N];
		Arrays.fill(minDistance, INF);

		distance = new double[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				distance[i][j] = distance[j][i] = Math.sqrt(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
			}
		}

	}

	public static double prim() {

		double ret = 0;

		minDistance[0] = 0;

		for (int i = 0; i < N; i++) {
			int u = -1;
			for (int v = 0; v < N; v++) {
				if (!added[v] && (u == -1 || minDistance[u] > minDistance[v])) u = v;
			}

			ret += minDistance[u];
			added[u] = true;

			for (int v = 0; v < N; v++) {
				double dist = distance[u][v];
				if (!added[v] && minDistance[v] > dist) minDistance[v] = dist;
			}

		}

		return ret;

	}

}
