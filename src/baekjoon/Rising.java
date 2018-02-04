package baekjoon;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Rising {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {

			int N = sc.nextInt();

			TreeSet<Integer> lis = new TreeSet<>();
			lis.add(-1);

			for (int n = 0; n < N; n++) {
				int input = sc.nextInt();
				if (input > lis.last()) lis.add(input);
				else {
					lis.remove(lis.ceiling(input));
					lis.add(input);
				}

			}
			System.out.println(lis.size() - 1);

		}
		sc.close();
	
	}

}
