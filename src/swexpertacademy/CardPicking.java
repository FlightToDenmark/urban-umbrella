package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CardPicking {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int N;
		long K, A = 0;
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Long.parseLong(st.nextToken());
			for (int n = 1; n <= N; n++) {
				A = (A + K) % n + 1;
			}
			System.out.println("#" + t + " " + A);
		}

	}

}
