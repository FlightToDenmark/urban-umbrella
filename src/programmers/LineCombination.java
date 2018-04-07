package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class LineCombination {

	public static ArrayList<Integer> list;
	public static int N;

	public static void main(String[] args) {

		LineCombination lc = new LineCombination();
		System.out.println(Arrays.toString(lc.setAlign(3, 4)));
		System.out.println(Arrays.toString(lc.setAlign(3, 5)));
		System.out.println(Arrays.toString(lc.setAlign(3, 6)));
		System.out.println(Arrays.toString(lc.setAlign(13, 5679239048L)));
		System.out.println(Arrays.toString(lc.setAlign(4, 14)));

	}

	public int[] setAlign(int n, long k) {

		list = new ArrayList<>();
		
		int[] answer = new int[n];

		N = n;
		getWay(n, k);

		for (int i = 0; i < n; i++) {
			answer[i] = list.get(i);
		}

		return answer;

	}

	public static void getWay(int n, long k) {

		if (n == 1) {
			for (int i = 1; i <= N; i++) if (!list.contains(i)) list.add(i);
			return;
		}

		long facto = 1;
		for (int i = 1; i < n; i++) {
			facto *= i;
		}

		if (k % facto == 0) {
			list.add(Math.toIntExact(k / facto));
			for (int i = N; i > 0; i--) if (!list.contains(i)) list.add(i);
		} else {
			list.add((Math.toIntExact(k / facto) + 1));
			getWay(n - 1, k % facto);
		}

	}

}
