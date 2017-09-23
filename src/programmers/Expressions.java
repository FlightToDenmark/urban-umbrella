package programmers;

public class Expressions {
	
	public int answer;
	
	public int expressions(int number) {
		
		answer = 0;

		for(int i=1; i<=number; i++) solve(i, number);
		
		return answer;
	}

	public static void main(String args[]) {

		Expressions expressions = new Expressions();
		System.out.println(expressions.expressions(15));

	}

	public void solve(int start, int number) {

		if(number==0) answer++;
		
		if(number<0) return;
		
		if(number>0) solve(start+1, number-start);
		
	}

}
