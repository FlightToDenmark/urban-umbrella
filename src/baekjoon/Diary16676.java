package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Diary16676 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int A = 1;
		for (int i = 1; i <= 9; i++) {
			A *= 10;
			A += 1;
			if (N < A) {
				System.out.println(i);
				break;
			}
		}

	}

}
