package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

public class ChooseCity {

	public int chooseCity(int n, int[][] city) {
		
		Queue<Pair> queue = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			int totalDist = 0;
			for (int j = 0; j < n; j++) {
				if (j != i)
					totalDist += Math.abs(city[i][0] - city[j][0]) * city[j][1];
					
			}
			queue.add(new Pair(city[i][0], totalDist));
		}

		return queue.peek().cityNum;

	}

	public static void main(String[] args) {

		ChooseCity test = new ChooseCity();
		int tn = 3;
		int[][] tcity = { { 1, 5 }, { 2, 2 }, { 3, 3 } };
		System.out.println(test.chooseCity(tn, tcity));

	}

}

class Pair implements Comparable<Pair> {

	int cityNum, totalDist;

	public Pair(int cityNum, int totalDist) {
		super();
		this.cityNum = cityNum;
		this.totalDist = totalDist;
	}

	@Override
	public int compareTo(Pair pair) {
		return (this.totalDist - pair.totalDist) == 0 ? Math.abs(this.cityNum - pair.cityNum) : this.totalDist - pair.totalDist;
	}

}
