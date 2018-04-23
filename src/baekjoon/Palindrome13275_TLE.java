package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome13275_TLE {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		int originLength = origin.length();

		Loop:
		for (int length = originLength; length > 0; length--) {
			for (int j = 0; j < originLength - length + 1; j++) {
				String substring = origin.substring(j, j + length);
				char[] charArray = substring.toCharArray();
				boolean isPalindrome = true;
				for (int k = 0; k < length / 2; k++) {
					if (charArray[k] != charArray[length - k - 1]) {
						isPalindrome = false;
						break;
					}
				}
				if (isPalindrome) {
					System.out.println(length);
					break Loop;
				}
			}
		}

	}

}
