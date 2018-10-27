package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA1969 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] DNA = new char[N][M];
		for (int n = 0; n < N; n++) {
			DNA[n] = br.readLine().toCharArray();
		}
		int A, C, G, T;
		int HD = 0;
		String answer = "";
		for (int m = 0; m < M; m++) {
			A = C = G = T = 0;
			for (int n = 0; n < N; n++) {
				if (DNA[n][m] == 'A') {
					A++;
				} else if (DNA[n][m] == 'C') {
					C++;
				} else if (DNA[n][m] == 'G') {
					G++;
				} else {
					T++;
				}
			}
			if (A >= C && A >= G && A >= T) {
				answer += 'A';
				HD += (C + G + T);
				continue;
			}
			if (C >= A && C >= G && C >= T) {
				answer += 'C';
				HD += (A + G + T);
				continue;
			}
			if (G >= A && G >= C && G >= T) {
				answer += 'G';
				HD += (A + C + T);
				continue;
			}
			if (T >= A && T >= C && T >= G) {
				answer += 'T';
				HD += (A + C + G);
				continue;
			}

		}
		System.out.println(answer);
		System.out.println(HD);

	}

}
