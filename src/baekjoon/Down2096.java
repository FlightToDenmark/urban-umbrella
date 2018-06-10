package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Down2096 {

	static int[] beforeMin, beforeMax;
	static int[] currentMin, currentMax;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		beforeMin = new int[3];
		beforeMax = new int[3];
		currentMin = new int[3];
		currentMax = new int[3];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				currentMin[j] = Integer.parseInt(st.nextToken());
				currentMax[j] = currentMin[j];
				currentMin[j] += Math.min(beforeMin[1], (j == 1) ? Math.min(beforeMin[0], beforeMin[2]) : beforeMin[j]);
				currentMax[j] += Math.max(beforeMax[1], (j == 1) ? Math.max(beforeMax[0], beforeMax[2]) : beforeMax[j]);
			}
			beforeMin = Arrays.copyOf(currentMin, 3);
			beforeMax = Arrays.copyOf(currentMax, 3);
		}

		Arrays.sort(currentMin);
		Arrays.sort(currentMax);

		System.out.print(currentMax[2] + " " + currentMin[0]);

	}

}
