package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Find1786 {

	public static String T, P;
	public static int t, p;
	public static int[] f;
	public static ArrayList<Integer> match = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = br.readLine();
		P = br.readLine();
		t = T.length();
		p = P.length();

		failure();
		kmp();
		System.out.println(match.size());
		for (int index : match) {
			System.out.print(index + 1 + " ");
		}

	}

	public static void failure() {

		f = new int[p];

		int j = 0;
		for (int i = 1; i < p; i++) {
			while (j > 0 && P.charAt(i) != P.charAt(j)) {
				j = f[j - 1];
			}
			if (P.charAt(i) == P.charAt(j)) {
				f[i] = ++j;
			}
		}

	}

	public static void kmp() {

		int j = 0;
		for (int i = 0; i < t; i++) {
			while (j > 0 && T.charAt(i) != P.charAt(j)) {
				j = f[j - 1];
			}
			if (T.charAt(i) == P.charAt(j)) {
				if (j == p - 1) {
					match.add(i - p + 1);
					j = f[j];
				} else {
					j++;
				}
			}
		}

	}

}
