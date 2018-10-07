package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dolls15954_N2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[] a = new long[N + 1];
		long[] b = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		long x;
		long sum = 0;
		long sqrSum = 0;
		for (int n = 1; n <= N; n++) {
			a[n] = sum += x = Long.parseLong(st.nextToken());
			b[n] = sqrSum += x * x;
		}

		double min = Double.MAX_VALUE;
		double meansqr;
		double sd;
		for (int i = 1; i <= N - K + 1; i++) {
			for (int j = K; j <= N - i + 1; j++) {
				meansqr = ((double) (a[i + j - 1] - a[i - 1])) * (a[i + j - 1] - a[i - 1]) / j / j;
				sd = Math.sqrt((((double) (b[i + j - 1] - b[i - 1])) / j) - (meansqr));
				if (sd < min) {
					min = sd;
				}
			}
		}
		System.out.println(min);
//		System.out.format("%.11f", min);

	}

}
