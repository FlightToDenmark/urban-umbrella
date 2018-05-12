package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Polyomino1343_ {

	static int occ;
	static StringBuilder stream = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] input = br.readLine().toCharArray();

		for (char c : input) {
			if (c == 'X') occ++;
			else { // (c == '.')
				if (occ != 0) process();
				stream.append(c);
			}
		}
		process();

		System.out.println(stream);

	}

	private static void process() {

		if (occ % 2 == 1) {
			System.out.println(-1);
			System.exit(0);
		}
		for (int i = 0; i < occ / 4; i++) stream.append("AAAA");
		for (int i = 0; i < occ % 4 / 2; i++) stream.append("BB");

		occ = 0;

	}

}
