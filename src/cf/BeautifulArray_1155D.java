import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		long[] A = new long[N]; // input
		long[][] D = new long[N][3];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			A[n] = Long.parseLong(st.nextToken());
		}
		D[0][0] = A[0];
		D[0][1] = A[0] * X;
		D[0][2] = A[0];
		for (int n = 1; n < N; n++) {
			D[n][0] = Math.max(D[n - 1][0] + A[n], A[n]);
			D[n][1] = Math.max(D[n - 1][0] + A[n] * X, Math.max(D[n - 1][1] + A[n] * X, A[n] * X));
			D[n][2] = Math.max(D[n - 1][1] + A[n], Math.max(D[n - 1][2] + A[n], A[n]));
		}
		long answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				answer = Math.max(answer, D[i][j]);
			}
		}
		System.out.println(answer);

	}

}
