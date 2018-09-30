package algospot;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BRACKETS_String {

	static String open = "([";
	static String close = ")]";

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s = br.readLine()).equals("end")) {
			System.out.println(findLongestSubsequence(s));
		}

	}

	static int findLongestSubsequence(String str) {

		int length = str.length();

		if (str.equals("()") || str.equals("[]")) {
			return length;
		}
		if (length <= 2 || str.equals("")) {
			return 0;
		}

		int candidate = 0;
		int answer = 0;

		for (int i = 0; i < length; i++) {
			char charFront = str.charAt(i);
			if (open.indexOf(charFront) != -1) {
				for (int j = length - 1; j > i; j--) {
					char charRear = str.charAt(j);
					if (open.indexOf(charFront) == close.indexOf(charRear)) {
						candidate = findLongestSubsequence(str.substring(i + 1, j))
								+ findLongestSubsequence(str.substring(j, length)) + 2;
						if (candidate > answer) {
							answer = candidate;
						}
					}
				}
			}
		}

		return answer;

	}

}
