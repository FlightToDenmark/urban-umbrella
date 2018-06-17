package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GPSequence15712 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken());
		long r = Long.parseLong(st.nextToken());
		long n = Long.parseLong(st.nextToken());
		long mod = Long.parseLong(st.nextToken());

		if (r == 1)	System.out.println(n * a);
		else System.out.println((a * ((((long) Math.pow(r, n)) - 1) % mod) / (r - 1)));

	}

}
