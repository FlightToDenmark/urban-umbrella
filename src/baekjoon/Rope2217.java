package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Rope2217 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] W = new int[N];
		for (int n = 0; n < N; n++) {
			W[n] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(W);
		int start = 0, end = N - 1, max = 0, weight;
		while (end >= 0) {
			weight = W[end] * (++start);
			if (weight >= max) {
				max = weight;
			}
			end--;
		}
		bw.write(max + "\n");
		bw.flush();
		bw.close();

	}

}
