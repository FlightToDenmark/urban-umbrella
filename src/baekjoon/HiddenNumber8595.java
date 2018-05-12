package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HiddenNumber8595 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String[] input = br.readLine().split("[a-zA-Z]");

		long sum = 0;
		for (String s : input) {
			if (s.equals("") || s.length() > 6)	continue;
			sum += Long.parseLong(s);
		}
		System.out.println(sum);

	}

}
