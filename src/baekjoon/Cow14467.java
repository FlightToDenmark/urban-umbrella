package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Cow14467 {

	static final int LEFT = 1, RIGHT = 2;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] S = new int[11];
		int cow, dir, total = 0;
		StringTokenizer st;
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			cow = Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken());
			if (dir + 1 == LEFT && S[cow] == RIGHT) {
				total++;
			}
			if (dir + 1 == RIGHT && S[cow] == LEFT) {
				total++;
			}
			S[cow] = dir + 1;
		}
		bw.write(total + "\n");
		bw.flush();
		bw.close();

	}

}
