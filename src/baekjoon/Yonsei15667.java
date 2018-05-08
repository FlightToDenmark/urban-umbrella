package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Yonsei15667 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int number = Integer.parseInt(br.readLine());

		int k = 1;
		while (true) {
			if (k * k + k + 1 == number) {
				System.out.println(k);
				break;
			}
			k++;
		}

	}

}