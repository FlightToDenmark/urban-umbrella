package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Cow14468 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] cow = br.readLine().toCharArray();
		int[] outside = new int[26];
		int answer = 0;
		for (int i = 0; i < 52; i++) {
			if (outside[cow[i] - 65] > 0) {
				for (int a = outside[cow[i] - 65]; a < i; a++) {
					if (outside[cow[a] - 65] > 0) {
						answer++;
					}
				}
				outside[cow[i] - 65] = 0;
			} else {
				outside[cow[i] - 65] = i + 1;
			}
		}
		bw.write(answer + "\n");
		bw.flush();
		bw.close();

	}

}
