package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class LIS11053 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		TreeSet<Integer> lis = new TreeSet<>();
		lis.add(-1);

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());
			if (num > lis.last()) lis.add(num);
			else {
				lis.remove(lis.ceiling(num));
				lis.add(num);
			}
		}
		System.out.println(lis.size()-1);

	}

}
