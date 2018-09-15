package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Marathon10655 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1, y1, x2, y2, dist = 0, distBefore = 0, distLeap;
		int a = 0, b = 0, c = 0;
		int x0 = 0, y0 = 0;
		int total = 0, max = 0;
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		for (int n = 1; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			total += dist = Math.abs(x2 - x1) + Math.abs(y2 - y1);
			distLeap = Math.abs(x2 - x0) + Math.abs(y2 - y0);
			if (n != 1 && dist + distBefore - distLeap > max && n != N - 1) {
				max = dist + distBefore - distLeap;
				a = dist;
				b = distBefore;
				c = distLeap;
			}
			x0 = x1;
			y0 = y1;
			x1 = x2;
			y1 = y2;
			distBefore = dist;
		}
		System.out.println(total - a - b + c);

	}

}
