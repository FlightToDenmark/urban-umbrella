package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Factory7578 {

	static int N;
	static int[] A, tree, map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		tree = new int[N + 1];
		map = new int[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			A[n] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			map[Integer.parseInt(st.nextToken())] = n;
		}

		long answer = 0;
		int B;
		for (int n = 1; n <= N; n++) {
			B = map[A[n]];
			answer += sum(N) - sum(B);
			update(B);
		}
		System.out.println(answer);

	}

	static int sum(int i) {

		int ans = 0;
		while (i > 0) {
			ans += tree[i];
			i -= (i & -i);
		}
		return ans;

	}

	static void update(int i) {

		while (i <= N) {
			tree[i] += 1;
			i += (i & -i);
		}

	}

}
