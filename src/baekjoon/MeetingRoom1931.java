package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MeetingRoom1931 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] time = new int[N][2];

		StringTokenizer st;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			time[n][0] = Integer.parseInt(st.nextToken());
			time[n][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(time, (a, b) -> (a[1] == b[1]) ? a[0] - b[0] : a[1] - b[1]);
		// Comparator<int[]> first = (a, b) -> a[1] - b[1];
		// Comparator<int[]> second = (a, b) -> a[0] - b[0];
		// Arrays.sort(time, first.thenComparing(second));

		int ans = 0;
		int end = 0;
		for (int n = 0; n < N; n++) {
			if (time[n][0] >= end) {
				ans++;
				end = time[n][1];
			}
		}
		System.out.println(ans);

	}

}
