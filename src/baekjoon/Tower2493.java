package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Tower2493 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N + 1];
		int[] answer = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			T[n] = Integer.parseInt(st.nextToken());
			answer[n] = 0;
		}

		for (int n1 = N; n1 > 0; n1--) {
			for (int n2 = n1 - 1; n2 >= 0; n2--) {
				if (T[n2] > T[n1]) {
					answer[n1] = n2;
					break;
				}
			}
		}
		for (int n = 1; n <= N; n++) {
			bw.write(answer[n] + " ");
		}
		bw.flush();
		bw.close();

	}

}
