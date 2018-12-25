package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RoomNumber1475 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] count = new int[10];
		for (char c : br.readLine().toCharArray()) {
			count[(int) (c - 48)]++;
		}
		count[9] += count[6];
		if (count[9] % 2 == 1) {
			++count[9];
		}
		count[9] /= 2;
		count[6] = 0;

		int max = -1;
		for (int c = 0; c < 10; c++) {
			if (count[c] > max) {
				max = count[c];
			}
		}
		System.out.println(max);

	}

}
