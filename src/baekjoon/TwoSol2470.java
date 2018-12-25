package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoSol2470 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for (int n = 0; n < N; n++) {
			A[n] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		int start = 0, end = N - 1;
		int minDiff = Integer.MAX_VALUE;
		int sample = 0, temp = 0;
		int i1 = 0, i2 = 0;
		while (start < end) {
			sample = A[start] + A[end];
			temp = abs(sample);
			if (temp < minDiff) {
				minDiff = temp;
				i1 = start;
				i2 = end;
			}
			if (sample > 0) {
				end--;
			} else if (sample < 0) {
				start++;
			} else {
				break;
			}
		}
		System.out.format("%d %d", A[i1], A[i2]);

	}

	static int abs(int a) {

		if (a > 0) {
			return a;
		} else {
			return -a;
		}

	}

}
