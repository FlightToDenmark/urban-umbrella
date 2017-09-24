package tryouts;

import java.util.Arrays;

public class Number6 {

	public int[] st;
	public int[] cache1, cache2;
	

	public int solution(int sticker[]) {

		int answer = 36;		

		st = sticker;
		cache1 = new int[st.length-1];
		cache2 = new int[st.length];
		
		Arrays.fill(cache1, -1);
		Arrays.fill(cache2, -1);
				
		answer = Math.max(solve0(0), solve1(1));

		return answer;

	}

	public int solve0(int index) {

		if (index >= st.length-1) return 0;

		if(cache1[index]!=-1) return cache1[index];
		
		return cache1[index] = Math.max(solve0(index + 1), st[index] + solve0(index + 2));

	}
	
	public int solve1(int index) {

		if (index >= st.length) return 0;

		if(cache2[index]!=-1) return cache2[index];
		
		return cache2[index] = Math.max(solve1(index + 1), st[index] + solve1(index + 2));

	}

}
