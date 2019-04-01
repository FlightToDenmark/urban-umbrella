package cf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static long[][] D;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		D = new long[N + 1][N + 1];
		bw.write(minCost(1, N) + "\n");
		bw.close();

	}

	static long minCost(int i, int j) {

		if (D[i][j] != 0) {
			return D[i][j];
		}

		if (j < i + 2) {
			return 0;
		} else {
			long ret = Long.MAX_VALUE;
			for (int k = i + 1; k < j; k++) {
				ret = Math.min(ret, minCost(i, k) + minCost(k, j) + i * k * j);
			}
			return D[i][j] = ret;
		}

	}

}
