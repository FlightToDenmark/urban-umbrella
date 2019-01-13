package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AboveAverage4344 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int N, sum, count;
		int[] num = new int[1001];
		double average;
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			sum = 0;
			count = 0;
			for (int n = 0; n < N; n++) {
				sum += num[n] = Integer.parseInt(st.nextToken());
			}
			average = (double) sum / N;
			for (int n = 0; n < N; n++) {
				if (num[n] > average) {
					count++;
				}
			}
			System.out.format("%.3f%%\n", (double) count / N * 100);
		}

	}

}
