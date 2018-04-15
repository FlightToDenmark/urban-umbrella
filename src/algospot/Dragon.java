package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dragon {

	public static int n, p, l;
	public static long[] length;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());
		precalc();

		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			for (int i = p - 1; i < p + l - 1; i++) {
				System.out.print(expand("FX", n, i));
			}
			System.out.println();
		}

	}

	public static char expand(String dragonCurve, int generations, int skip) {

		if (generations == 0)
			return dragonCurve.charAt(skip);

		for (int i = 0; i < dragonCurve.length(); i++) {
			char c = dragonCurve.charAt(i);
			if (c == 'X' || c == 'Y') {
				if (skip >= length[generations])
					skip -= length[generations];
				else if (c == 'X')
					return expand("X+YF", generations - 1, skip);
				else
					return expand("FX-Y", generations - 1, skip);
			} else if (skip > 0) {
				skip--;
			} else {
				return c;
			}
		}

		return 'a';

	}

	public static void precalc() {

		length = new long[51];
		length[0] = 1;
		for (int i = 1; i <= 50; i++)
			length[i] = length[i - 1] * 2 + 2;

	}

}
