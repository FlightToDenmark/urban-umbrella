package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Distributed1009 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int a, b, c;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = 1;
			for (int bb = 0; bb < b; bb++) {
				c *= a;
				c %= 10;
			}
			c = ((c == 0) ? 10 : c);
			bw.write(c + "\n");
		}
		bw.flush();
		bw.close();

	}

}
