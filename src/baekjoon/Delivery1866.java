package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Delivery1866 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int costA, costB, costC;
		int[] spot = new int[N + 1];
		int[] cache = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			spot[n] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		costA = Integer.parseInt(st.nextToken());
		costB = Integer.parseInt(st.nextToken());
		Arrays.sort(spot);
		for (int i = 1; i <= N; i++) {
			cache[i] = spot[i] * costA + cache[i - 1];
			costC = costB;
			for (int j = i; j > 0; j--) {
				costC += (spot[(i + j + 1) / 2] - spot[j]) * costA;
				cache[i] = Math.min(cache[i], cache[j - 1] + costC);
			}
		}
		System.out.println(cache[N]);

	}

}
