package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Palindrome10988 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		System.out.println(isPalindrome(str));

	}

	public static int isPalindrome(String origin) {

		Stack<Character> stack = new Stack<>();

		char[] charArray = origin.toCharArray();

		for (char c : charArray) {
			stack.push(c);
		}
		
		String reverse = "";
		for (int i = 0; i < origin.length(); i++) {
			reverse += stack.pop();
		}

		if (origin.equals(reverse)) {
			return 1;
		}
		
		return 0;

	}

}
