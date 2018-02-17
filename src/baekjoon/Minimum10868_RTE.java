package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Minimum10868_RTE {
	
	public static long[] a;
	public static long[][] min;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int length = Integer.parseInt(st1.nextToken());
		int way = Integer.parseInt(st1.nextToken());

		a = new long[length+1];
		for (int i = 1; i <= length; i++)
			a[i] = Integer.parseInt(br.readLine());

		min = new long[length+1][length+1];

		for (int i = 1; i <= length; i++) {
			min[i][i] = a[i];
			for (int j = i + 1; j <= length; j++) {
				min[i][j] = Math.min(min[i][j - 1], a[j]);
			}
		}

		for (int i = 0; i < way; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st2.nextToken());
			int to = Integer.parseInt(st2.nextToken());
			System.out.println(min[from][to]);
		}

		br.close();

	}

}
