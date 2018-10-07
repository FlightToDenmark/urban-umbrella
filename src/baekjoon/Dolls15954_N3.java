package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dolls15954_N3 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[] a = new long[N + 1];
		long[] b = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		long sum = 0;
		for (int n = 1; n <= N; n++) {
			b[n] = sum += a[n] = Long.parseLong(st.nextToken());
		}

		double min = Double.MAX_VALUE;
		double mean;
		double var;
		double sd;
		for (int i = 1; i <= N - K + 1; i++) {
			for (int j = K; j <= N - i + 1; j++) {
				mean = (double) (b[i + j - 1] - b[i - 1]) / j;
				var = 0;
				for (int k = i; k <= i + j - 1; k++) {
					var += Math.pow((a[k] - mean), 2);
				}
				sd = Math.sqrt(var/j);
				if (sd < min) {
					min = sd;
				}
			}
		}
		System.out.println(min);
//		System.out.format("%.11f", min);

	}

}
