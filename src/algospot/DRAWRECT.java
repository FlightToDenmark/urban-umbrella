package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DRAWRECT {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[] X = new int[3];
		int[] Y = new int[3];
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				X[i] = Integer.parseInt(st.nextToken());
				Y[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println((X[0] ^ X[1] ^ X[2]) + " " + (Y[0] ^ Y[1] ^ Y[2]));
		}

	}

}
