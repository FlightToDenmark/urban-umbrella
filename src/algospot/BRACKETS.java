package algospot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BRACKETS {

	static String open = "([";
	static String close = ")]";
	static char[] string;
	static int[][] memo = new int[101][101];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s = br.readLine()).equals("end")) {
			string = s.toCharArray();
			for (int[] a : memo) {
				Arrays.fill(a, -1);
			}
			System.out.println(findLongestSubsequence(0, string.length - 1));
		}

	}

	static int findLongestSubsequence(int start, int end) {

		if (start >= end) {
			return 0;
		}

		if (memo[start][end] != -1) {
			return memo[start][end];
		}

		if (end - start == 1 && open.indexOf(string[start]) == close.indexOf(string[end])) {
			return 2;
		}

		int candidate = 0;
		int answer = 0;

		for (int i = start; i < end; i++) {
			char charFront = string[i];
			if (open.indexOf(charFront) != -1) {
				for (int j = end; j > i; j--) {
					char charRear = string[j];
					if (open.indexOf(charFront) == close.indexOf(charRear)) {
						candidate = findLongestSubsequence(i + 1, j - 1) + findLongestSubsequence(j + 1, end) + 2;
						if (candidate > answer) {
							answer = candidate;
						}
					}
				}
			}
		}

		return memo[start][end] = answer;

	}

}
