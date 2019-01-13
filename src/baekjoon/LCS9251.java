package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LCS9251 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();
		int a = A.length;
		int b = B.length;
		int[][] L = new int[a + 1][b + 1];
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				if (i == 0 || j == 0) {
					L[i][j] = 0;
				} else if (A[i - 1] == B[j - 1]) {
					L[i][j] = L[i - 1][j - 1] + 1;
				} else {
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
				}
			}
		}
		bw.write(L[a][b] + "\n");
		bw.flush();
		bw.close();

	}

}
