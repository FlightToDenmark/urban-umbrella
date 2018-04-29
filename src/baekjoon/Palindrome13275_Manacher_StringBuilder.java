package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome13275_Manacher_StringBuilder {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		int orgLength = origin.length();
		StringBuilder converted = new StringBuilder();
		char[] O = origin.toCharArray();
		for (int i = 0; i < orgLength; i++) {
			converted.append("#");
			converted.append(O[i]);
		}
		converted.append("#");
		int length = converted.length();
		char[] S = converted.toString().toCharArray();

		int[] A = new int[length];

		int R = -1;
		int p = -1;
		for (int i = 0; i < length; i++) {
			if (i <= R) {
				A[i] = Math.min(A[2 * p - i], R - i);
			} else {
				A[i] = 0;
			}
			while (i - A[i] - 1 >= 0 && i + A[i] + 1 < length && S[i - A[i] - 1] == S[i + A[i] + 1]) {
				A[i]++;
			}
			if (i + A[i] > R) {
				R = i + A[i];
				p = i;
			}
		}

		int max = -1;
		for (int a : A) {
			if (a > max) max = a;
		}
		System.out.println(max);

	}

}
