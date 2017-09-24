package tryouts;

import java.util.Arrays;

public class Number7 {

	public String[] piece;
	public String str;
	public final int MAX = 999999999;
	public int[] cache;

	public int solution(String[] strs, String t) {

		int answer = 0;

		str = t;
		piece = strs;
		cache = new int[str.length()];
		Arrays.fill(cache, -1);
		
		answer = (solve(0)!=MAX) ? solve(0) : -1;

		return answer;

	}

	public int solve(int index) {

		if (index == str.length()) return 0;

		if(cache[index]!=-1) return cache[index];
		
		int ret = MAX;

		for (int i = 0; i < piece.length; i++) {
			if (index + piece[i].length() <= str.length()) {
				String a = str.substring(index, index + piece[i].length());
				if (a.equals(piece[i])) {
					ret = cache[index] = Math.min(ret, solve(index + piece[i].length()) + 1);
				}
			}
		}

		return ret;
	}

}
