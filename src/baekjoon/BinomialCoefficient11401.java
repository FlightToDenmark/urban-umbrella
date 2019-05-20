import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		long P = 1000000007;
		long A = 1, B = 1;
		for (int i = 1; i <= N; i++) {
			A *= i;
			A %= P;
		}
		for (int i = 1; i <= K; i++) {
			B *= i;
			B %= P;
		}
		for (int i = 1; i <= N - K; i++) {
			B *= i;
			B %= P;
		}
		bw.write(power(B, P - 2, P) * A % P + "\n");
		bw.close();

	}

	static long power(long a, long b, long c) {

		if (b == 0) {
			return 1;
		}

		long ret = power(a, b / 2, c);
		ret *= ret;
		ret %= c;
		if (b % 2 == 1) {
			ret *= a;
			ret %= c;
		}
		return ret;

	}

}
