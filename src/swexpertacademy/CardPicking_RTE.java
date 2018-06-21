package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class CardPicking_RTE {

	static List<Integer> list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int N;
		long p, K;
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Long.parseLong(st.nextToken());

			list = new LinkedList<>();
			for (int n = 1; n <= N; n++) {
				list.add(n);
			}

			p = 0;
			long k;
			while (N > 1) {
				k = K % N;
				p += k;
				while (p >= N) {
					p -= N;
				}
				list.remove((int) p);
				N--;
			}
			System.out.println("#" + t + " " + list.get(0));
		}

	}

}
