package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Frog5550_Optimize {

	static int[] frog = new int[6];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		char[] str;
		int totalFrog;
		frog[0] = Integer.MAX_VALUE;
		for (int t = 1; t <= T; t++) {
			totalFrog = -1;
			str = br.readLine().toCharArray();

			if (str.length % 5 != 0) {
				System.out.println("#" + t + " " + totalFrog);
				continue;
			}

			for (int i = 1; i < 6; i++) {
				frog[i] = 0;
			}

			int idx;
			int beforeFrog = 0;
			for (int c = 0; c < str.length; c++) {
				idx = index(str[c]);
				if (frog[idx - 1] > frog[idx]) {
					frog[idx]++;
					if (idx == 1 && beforeFrog > 0) {
						for (int i = 1; i < 6; i++) {
							frog[i]--;
						}
						beforeFrog--;
					}
					if (idx == 5) {
						if (frog[idx] > totalFrog) {
							totalFrog = frog[idx];
						}
						if (checkAllSame(frog)) {
							for (int i = 1; i < 6; i++) {
								frog[i] = 0;
							}
						} else {
							beforeFrog++;
						}
					}
				} else {
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

	static boolean checkAllSame(int[] in) {

		for (int i = 2; i < in.length; i++) {
			if (in[i] != in[i - 1]) {
				return false;
			}
		}
		return true;

	}

}
