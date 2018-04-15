package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pool {

	public static final int MAX = 987654321;
	public static int[] price = new int[4];
	public static int[] plan = new int[12];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
		
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st1.nextToken());
			}
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st2.nextToken());
			}

			int ret = MAX;
			for (int i = 0; i < 4; i++) {
				ret = Math.min(ret, minCost(0, i));
			}
			System.out.println("#" + t + " " + ret);
		
		}

	}

	public static int minCost(int index, int choice) {

		if (index >= 12) return 0;

		int cost = 0;
		if (choice == 0) {
			cost = plan[index++] * price[choice];
		}
		if (choice == 1) {
			index++;
			cost = price[choice];
		}
		if (choice == 2) {
			index += 3;
			cost = price[choice];
		}
		if (choice == 3) {
			if (index != 0)	return MAX;
			return price[choice];
		}

		int totalCost = MAX;
		for (int c = 0; c < 3; c++) {
			totalCost = Math.min(totalCost, minCost(index, c));
		}

		return totalCost += cost;

	}

}
