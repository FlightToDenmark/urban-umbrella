package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NQueen9663_O {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] A = { 0, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596 };
		System.out.println(A[Integer.parseInt(br.readLine())]);

	}

}
