package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Box1493 {

	static boolean possible = true;
	static int total;
	static int[] cube = new int[20];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			cube[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		solve(a, b, c);
		System.out.println(possible ? total : -1);

	}

	static void solve(int a, int b, int c) {

		if (!possible || a == 0 || b == 0 || c == 0)
			return;

		int x;
		for (int i = 19; i >= 0; i--) {
			x = (1 << i);
			if (cube[i] > 0 && a >= x && b >= x && c >= x) {
				total++;
				cube[i]--;
				solve(a, b, c - x);
				solve(a - x, b, x);
				solve(x, b - x, x);
				return;
			}
		}
		possible = false;

		return;

	}

}
