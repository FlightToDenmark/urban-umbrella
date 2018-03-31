package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneNumber5052 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.valueOf(br.readLine());
		while (testCase--> 0) {

			int N = Integer.valueOf(br.readLine());
			List<String> whitePages = new ArrayList<>();
			for (int n = 0; n < N; n++)	whitePages.add(br.readLine());
			Collections.sort(whitePages);

			boolean ret = true;
			for (int n = 1; n < N; n++) {
				String prior = whitePages.get(n - 1);
				String str = whitePages.get(n);
				if (str.startsWith(prior)) {
					ret = false;
					break;
				}
			}
			System.out.println(ret ? "YES" : "NO");

		}

	}

}