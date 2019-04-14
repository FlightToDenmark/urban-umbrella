import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		if (N % 2 == 1) {
			System.out.println(":(");
			return;
		}
		char[] in = input.toCharArray();
		int[] A = new int[N];
		int open = N / 2, close = N / 2;
		for (int n = 0; n < N; n++) {
			if (in[n] == '(') {
				A[n] = 1;
				--open;
			} else if (in[n] == ')') {
				A[n] = -1;
				--close;
			}
		}
		if (open < 0 || close < 0) {
			System.out.println(":(");
			return;
		}
		int sum = 0;
		for (int n = 0; n < N; n++) {
			if (in[n] == '?') {
				if (open >= 1) {
					A[n] = 1;
					--open;
					in[n] = '(';
				} else {
					A[n] = -1;
					--close;
					in[n] = ')';
				}
			}
			sum += A[n];
			if (n != N - 1 && sum <= 0) {
				System.out.println(":(");
				return;
			}
		}

		for (int n = 0; n < N; n++) {
			bw.write(in[n]);
		}
		bw.newLine();
		bw.close();

	}

}
