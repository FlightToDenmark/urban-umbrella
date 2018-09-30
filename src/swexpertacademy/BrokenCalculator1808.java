package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BrokenCalculator1808 {

	static int N, answer;
	static boolean[] possible = new boolean[10];
	static LinkedList<Pair> list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < 10; n++) {
				possible[n] = (Integer.parseInt(st.nextToken()) == 1) ? true : false;
			}
			N = Integer.parseInt(br.readLine());

			if (N == 0) {
				if (possible[0]) {
					System.out.format("#%d %d\n", t, 2);
				} else {
					System.out.format("#%d %d\n", t, -1);
				}
				continue;
			}

			if (N == 1) {
				if (possible[1]) {
					System.out.format("#%d %d\n", t, 2);
				} else {
					System.out.format("#%d %d\n", t, -1);
				}
				continue;
			}

			list = new LinkedList<>();
			answer = Integer.MAX_VALUE;

			for (int i = 1; i < 10; i++) {
				if (possible[i]) {
					makeNumbers(i, 1);
				}
			}

			for (Pair p : list) {
				solve(N, p.number, p.digits + 1);
			}

			System.out.format("#%d %d\n", t, answer != Integer.MAX_VALUE ? answer : -1);

		}
	}

	static void solve(int dividend, int divisor, int count) {

		int newDividend = dividend / divisor;

		if (newDividend == 1) {
			if (count < answer) {
				answer = count;
			}
		}

		for (Pair p : list) {
			if (newDividend % p.number == 0) {
				solve(newDividend, p.number, count + p.digits + 1);
			}
		}

	}

	static void makeNumbers(int num, int digits) {

		if (digits > 7 || num > N) {
			return;
		}

		if (N % num == 0 && num != 1) {
			list.add(new Pair(num, digits));
		}

		for (int i = 0; i < 10; i++) {
			if (possible[i]) {
				makeNumbers(num * 10 + i, digits + 1);
			}
		}

	}

}

class Pair {

	int number;
	int digits;

	public Pair(int number, int digits) {
		super();
		this.number = number;
		this.digits = digits;
	}

}