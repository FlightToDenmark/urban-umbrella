package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Hunter15953 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T, a, b;

	public static void main(String[] args) throws Exception {

		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			sb.append((moneyA(a) + moneyB(b)) + "\n"); 
		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}
	
	private static int moneyA(final int a) {
		
		if (a == 0) return 0;
		if (a == 1)	return 5000000;
		if (a > 1 && a <= 3) return 3000000;
		if (a > 3 && a <= 6) return 2000000;
		if (a > 6 && a <= 10) return 500000;
		if (a > 10 && a <= 15) return 300000;
		if (a > 15 && a <= 21) return 100000;
		return 0;
		
	}
	
	private static int moneyB(final int b) {
		
		if (b == 0) return 0;
		if (b == 1)	return 5120000;
		if (b > 1 && b <= 3) return 2560000;
		if (b > 3 && b <= 7) return 1280000;
		if (b > 7 && b <= 15) return 640000;
		if (b > 15 && b <= 31) return 320000;
		return 0;
		
	}

}
