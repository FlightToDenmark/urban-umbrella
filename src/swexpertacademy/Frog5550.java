package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Frog5550 {

	static final int maxFrog = 500;
	static boolean[][] frog = new boolean[500][5];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		char[] str;
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

			for (int c = 0; c < str.length; c++) {
				findRoom = false;
				if (str[c] == 'c') {
					for (int i = 0; i < maxFrog; i++) {
						if (!frog[i][0]) {
							frog[i][0] = findRoom = true;
							break;
						}
					}
					if (!findRoom) {
						totalFrog = -1;
						break;
					}
				}
				if (str[c] == 'r') {
					for (int i = 0; i < maxFrog; i++) {
						if (!frog[i][1] && frog[i][0]) {
							frog[i][1] = findRoom = true;
							break;
						}
					}
					if (!findRoom) {
						totalFrog = -1;
						break;
					}
				}
				if (str[c] == 'o') {
					for (int i = 0; i < maxFrog; i++) {
						if (!frog[i][2] && frog[i][1]) {
							frog[i][2] = findRoom = true;
							break;
						}
					}
					if (!findRoom) {
						totalFrog = -1;
						break;
					}
				}
				if (str[c] == 'a') {
					for (int i = 0; i < maxFrog; i++) {
						if (!frog[i][3] && frog[i][2]) {
							frog[i][3] = findRoom = true;
							break;
						}
					}
					if (!findRoom) {
						totalFrog = -1;
						break;
					}
				}
				if (str[c] == 'k') {
					for (int i = 0; i < maxFrog; i++) {
						if (!frog[i][4] && frog[i][3]) {
							frog[i][4] = findRoom = true;
							Arrays.fill(frog[i], false);
							if (i + 1 > totalFrog) {
								totalFrog = i + 1;
							}
							break;
						}
					}
					if (!findRoom) {
						totalFrog = -1;
						break;
					}
				}

			}
			System.out.println("#" + t + " " + totalFrog);
		}

	}

}
