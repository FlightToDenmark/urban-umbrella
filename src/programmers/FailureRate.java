package programmers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FailureRate {

	public static void main(String[] args) {

		int[] stages1 = { 2, 1, 2, 6, 2, 4, 3, 3 };
		int[] answer1 = solution(7, stages1);
		for (int n : answer1) {
			System.out.print(n + " ");
		}
		System.out.println();
		int[] stages2 = { 4, 4, 4, 4, 4 };
		int[] answer2 = solution(4, stages2);
		for (int n : answer2) {
			System.out.print(n + " ");
		}

	}

	public static int[] solution(int N, int[] stages) {

		Map<Integer, Double> map = new HashMap<>();

		int a, b;
		double failureRate;
		for (int n = 1; n <= N; n++) {
			a = 0;
			b = 0;
			for (int x : stages) {
				if (x > n) {
					a++;
				}
				if (x >= n) {
					b++;
				}
			}
			failureRate = (b != 0) ? (double) (b - a) / b : 0;
			map.put(n, failureRate);			
		}

		map = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		return map.keySet().stream().mapToInt(i -> i).toArray();

	}

}
