package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Card2161 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> Q = new LinkedList<>();
		for (int n = 1; n <= N; n++) {
			Q.add(n);
		}
		int index = 1;
		while (!Q.isEmpty()) {
			if (index % 2 == 1) {
				bw.write(Q.poll() + " ");
			} else {
				Q.add(Q.poll());
			}
			index++;
		}
		bw.flush();

	}

}
