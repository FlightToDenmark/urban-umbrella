package cf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TanyaAndCandies {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] C = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int odd = 0, even = 0;
		for (int n = 0; n < N; n++) {
			C[n] = Integer.parseInt(st.nextToken());
			if (n % 2 == 0) {
				even += C[n];
			} else {
				odd += C[n];
			}
		}
		int ret = 0;
		for (int n = 0; n < N; n++) {
			if (n % 2 == 0) {
				even -= C[n];
				if (even == odd) {
					ret++;
				}
				odd += C[n];
			} else {
				odd -= C[n];
				if (even == odd) {
					ret++;
				}
				even += C[n];
			}
		}
		bw.write(ret + "\n");
		bw.close();

	}

}