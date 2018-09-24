package swexpertacademy;

import java.util.Scanner;

public class Mountain4796 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N, a, b, c, increasing, decreasing, total;
		for (int t = 1; t <= T; t++) {
			increasing = 0;
			decreasing = 0;
			total = 0;
			N = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			if (a < b) {
				increasing++;
			} else {
				decreasing++;
			}
			for (int n = 2; n < N; n++) {
				c = sc.nextInt();
				if (a < b && b < c) {
					increasing++;
				}
				if (a > b && b > c) {
					decreasing++;
				}
				if (a < b && b > c) {
					decreasing = 1;
				}
				if (a > b && b < c) {
					total += increasing * decreasing;
					increasing = 1;
					decreasing = 0;
				}
				a = b;
				b = c;
			}
			total += increasing * decreasing;
			System.out.println("#" + t + " " + total);
		}
		sc.close();
	}

}
