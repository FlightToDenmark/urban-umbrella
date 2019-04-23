import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] A = new long[N];
		long[] B = new long[N];
		long[] C = new long[M];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			A[n] = Long.parseLong(st.nextToken());
		}
		for (int n = 1; n < N; n++) {
			B[n - 1] = A[n] - A[n - 1];
		}
		for (int n = 1; n < N - 1; n++) {
			B[n] = gcd(B[n], B[n - 1]);
		}
		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			C[m] = Long.parseLong(st.nextToken());
		}
		for (int m = 0; m < M; m++) {
			if (B[N - 2] % C[m] == 0) {
				System.out.println("YES");
				System.out.println(A[0] + " " + (m + 1));
				return;
			}
		}
		System.out.println("NO");

	}

	static long gcd(long a, long b) {

		if (a % b == 0) {
			return b;
		} else {
			return gcd(b, a % b);
		}

	}

}
