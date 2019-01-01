package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack10828 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>();
		String mode;
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			mode = st.nextToken();
			if (mode.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if (mode.equals("pop")) {
				if (!stack.isEmpty()) {
					bw.write(stack.pop() + "\n");
				} else {
					bw.write(-1 + "\n");
				}
			} else if (mode.equals("size")) {
				bw.write(stack.size() + "\n");
			} else if (mode.equals("empty")) {
				if (!stack.isEmpty()) {
					bw.write(0 + "\n");
				} else {
					bw.write(1 + "\n");
				}
			} else if (mode.equals("top")) {
				if (!stack.isEmpty()) {
					bw.write(stack.peek() + "\n");
				} else {
					bw.write(-1 + "\n");
				}
			}
		}
		bw.flush();
		bw.close();

	}

}
