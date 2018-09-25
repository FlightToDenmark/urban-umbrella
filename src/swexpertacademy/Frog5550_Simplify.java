package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Frog5550_Simplify {

	static final int maxFrog = 500;
	static boolean[][] frog = new boolean[500][6];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		char[] str = new char[2500];
		int totalFrog;
		boolean findRoom;
		for (int t = 1; t <= T; t++) {
			totalFrog = -1;
			str = br.readLine().toCharArray();

			if (str.length % 5 != 0) {
				System.out.println("#" + t + " " + totalFrog);
				continue;
			}
			
			for (boolean[] c : frog) {
				Arrays.fill(c, false);
			}
			for (int i = 0; i < maxFrog; i++) {
				frog[i][0] = true;
			}

			int idx;
			for (int c = 0; c < str.length; c++) {
				findRoom = false;
				idx = index(str[c]);
				for (int i = 0; i < maxFrog; i++) {
					if (!frog[i][idx] && frog[i][idx - 1]) {
						frog[i][idx] = findRoom = true;
						if (idx == 5) {
							Arrays.fill(frog[i], false);
							frog[i][0] = true;
							if (i + 1 > totalFrog) {
								totalFrog = i + 1;
							}
						}
						break;
					}
				}
				if (!findRoom) {
					totalFrog = -1;
					break;
				}

			}
			System.out.println("#" + t + " " + totalFrog);
		}

	}

	static int index(char c) {

		if (c == 'c') return 1;
		if (c == 'r') return 2;
		if (c == 'o') return 3;
		if (c == 'a') return 4;
		if (c == 'k') return 5;
		return 0;

	}

}
