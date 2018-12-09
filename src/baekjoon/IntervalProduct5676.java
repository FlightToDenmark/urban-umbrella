package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class IntervalProduct5676 {

	static int N, K;
	static int[] tree = new int[100001];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x;
		for (int n = 1; n <= N; n++) {
			x = Integer.parseInt(st.nextToken());
			update(n, x);
		}
		String mode;
		int a, b, result, A, B;
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			mode = st.nextToken();
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if (mode.equals("C")) {
				update(a, b);
			} else {
				A = query(a);
				B = query(b - 1);
				if (A == 0 || B == 0) {
					bw.write('0');
					continue;
				}
				result = A * B;
				if (result > 0) {
					bw.write('+');
				} else if (result < 0) {
					bw.write('-');
				} else {
					bw.write('0');
				}
			}
		}
		bw.flush();
		System.out.println();
		for(int i=1; i<=4; i++) {
			System.out.println(tree[i]);
		}

	}

	static void update(int i, int value) {

		while (i <= N) {
			if (tree[i] == 0) {
				tree[i] = value;
			} else {
				tree[i] *= value;
			}
			i += (i & -i);
		}

	}

	static int query(int i) {

		int answer = 1;
		while (i > 0) {
			answer *= tree[i];
			i -= (i & -i);
		}
		return answer;

	}

}
