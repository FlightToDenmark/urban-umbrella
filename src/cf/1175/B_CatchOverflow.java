import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Stack<Long> stack = new Stack<>();
		stack.push(1L);
		long ret = 0, INF = (1L << 32);
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			if (input.equals("for")) {
				long next = Long.parseLong(st.nextToken());
				next *= stack.peek();
				stack.push(Math.min(INF, next));
			} else if (input.equals("add")) {
				ret += stack.peek();
			} else if (input.equals("end")) {
				stack.pop();
			}
		}
		System.out.println((ret >= INF) ? "OVERFLOW!!!" : ret);

	}

}
