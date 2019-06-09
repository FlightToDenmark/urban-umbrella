import java.util.*;
import java.io.*;

public class Main {

	static long K;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			long N = Long.parseLong(st.nextToken());
			K = Long.parseLong(st.nextToken());
			bw.write(go(N) + "\n");
		}
		bw.close();

	}

	static long go(long n) {

		if (n == 0) {
			return 0;
		}
		if (n < 0) {
			return Integer.MAX_VALUE;
		}
		if (n / K == 0) {
			return n % K;
		} else {
			return go(n / K) + (n % K) + 1;
		}

	}

}
