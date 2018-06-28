package algospot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SUSHI {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		int N, M;
		int[] price, prefer;
		int[] cache = new int[201];
		StringTokenizer st;
		while (testCase-- > 0) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(cache, 0);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken()) / 100;
			price = new int[N];
			prefer = new int[N];
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				price[n] = Integer.parseInt(st.nextToken()) / 100;
				prefer[n] = Integer.parseInt(st.nextToken());
			}

			int ret = 0;
			for (int m = 1; m <= M; m++) {
				ret = 0;
				for (int n = 0; n < N; n++) {
					if (m >= price[n])
						ret = Math.max(ret, cache[(m - price[n]) % 201] + prefer[n]);
				}
				cache[m % 201] = ret;
			}

			bw.write(ret + "\n");
			bw.flush();
		}

	}

}
