package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Card2161_array {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] Q = new int[2 * N + 1];
		for (int n = 1; n <= N; n++) {
			Q[n] = n;
		}
		int front = 1;
		int rear = N + 1;
		while (front < rear) {
			sb.append(Q[front++] + " ");
			Q[rear++] = Q[front++];
		}
		bw.write(sb.toString());
		bw.flush();

	}

}
