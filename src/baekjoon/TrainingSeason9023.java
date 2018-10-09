package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TrainingSeason9023 {

	static int T, C, D, d, cityX, cityY;
	static int[] X = new int[101];
	static int[] Y = new int[101];
	static int[][][] memo = new int[101][101][4];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			for (int i = 0; i < 101; i++) {
				for (int j = 0; j < 101; j++) {
					for (int k = 0; k < 4; k++) {
						memo[i][j][k] = -1;
					}
				}
			}
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int city = 1; city <= 100; city++) {
				X[city] = Integer.parseInt(st.nextToken());
				if (X[city] == 0) {
					cityX = city - 1;
					break;
				}
			}
			st = new StringTokenizer(br.readLine());
			for (int city = 1; city <= 100; city++) {
				Y[city] = Integer.parseInt(st.nextToken());
				if (Y[city] == 0) {
					cityY = city - 1;
					break;
				}
			}
			System.out.println(solve(0, 0, 0));
		}

	}

	static int solve(int x, int y, int S) {

		if (x == cityX && y == cityY) return 0;

		if (memo[x][y][S] != -1) return memo[x][y][S];

		int ret = Integer.MAX_VALUE;

		if (x < cityX && y < cityY)
			ret = Math.min(ret, solve(x + 1, y + 1, 3) + ((X[x + 1] == Y[y + 1]) ? C : C * 2));
		
		if (x < cityX)
			ret = Math.min(ret, solve(x + 1, y, 1) + C + D * (S / 2) + d + ((x == 0 && y == 0) ? D : 0));
		
		if (y < cityY)
			ret = Math.min(ret, solve(x, y + 1, 2) + C + D * (S % 2) + d + ((x == 0 && y == 0) ? D : 0));

		return memo[x][y][S] = ret;

	}

}
