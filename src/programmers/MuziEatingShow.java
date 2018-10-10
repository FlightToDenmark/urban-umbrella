package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MuziEatingShow {

	public static void main(String[] args) {

		int[] food_times = { 3, 1, 2 };
		int k = 5;
		System.out.println(solution(food_times, k));

	}

	static int solution(int[] food_times, long k) {

		int length = food_times.length;
		List<Food> foodList = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			foodList.add(new Food(food_times[i], i + 1));
		}

		long sum = 0;
		long bTime = 0;
		long foodTime;
		Collections.sort(foodList, Comparator.comparing(Food::getTime));
		for (int i = 0; i < length; i++) {
			foodTime = foodList.get(i).time;
			if ((length - i) * (foodTime - bTime) <= k - sum) {
				sum += (length - i) * (foodTime - bTime);
				bTime = foodTime;
				continue;
			}
			k -= sum;
			foodList = foodList.subList(i, length);
			Collections.sort(foodList, Comparator.comparing(Food::getIndex));
			return foodList.get((int) (k % foodList.size())).index;
		}
		return -1;

	}

}

class Food {

	int time, index;

	public Food(int time, int index) {
		super();
		this.time = time;
		this.index = index;
	}

	public int getTime() {
		return time;
	}

	public int getIndex() {
		return index;
	}

}
