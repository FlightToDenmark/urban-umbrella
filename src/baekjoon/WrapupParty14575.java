package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class WrapupParty14575 {

	static int N, T;
	static int[] L, R;
	static int sumL, sumR, newSumR;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		L = new int[N];
		R = new int[N];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			sumL += L[n] = Integer.parseInt(st.nextToken());
			sumR += R[n] = Integer.parseInt(st.nextToken());
		}

		if (sumL > T || sumR < T) {
			bw.write(-1 + "\n");
			bw.flush();
			System.exit(0);
		}

		int low = 0, mid = 0, high = (int) 1e6;
		for (int i = 0; i < 20; i++) {
			mid = (low + high) / 2;
			if (isPossible(mid)) high = mid;
			else low = mid;
		}
		bw.write(high + "\n");
		bw.flush();

	}

	static boolean isPossible(int S) {

		newSumR = 0;
		for (int n = 0; n < N; n++) {
			if (S < L[n]) return false;
			newSumR += Math.min(S, R[n]);
		}

		if (T <= newSumR) return true;
		return false;

	}

}
