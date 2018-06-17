package algospot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BlockGame {

	static final byte INIT = 0, LOSING = -1, WINNING = 1;
	static byte[] memo = new byte[(1 << 25)];
	static char[] B;
	static int[] block = new int[104];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		makeBlocks();

		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {

			int board = 0;
			Arrays.fill(memo, INIT);
			for (int r = 0; r < 5; r++) {
				B = br.readLine().toCharArray();
				for (int c = 0; c < 5; c++) {
					if (B[c] == '#') {
						board |= 1 << (r + 5 * c);
					}
				}
			}
			System.out.println(solve(board) == WINNING ? "WINNING" : "LOSING");

		}

	}

	static byte solve(int board) {

		if (memo[board] != INIT)
			return memo[board];

		for (int b : block) {
			if ((board & b) == 0) {
				if (solve(board | b) == LOSING) {
					return memo[board] = WINNING;
				}
			}
		}

		return memo[board] = LOSING;

	}

	static void makeBlocks() {

		int idx = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				block[idx++] = (1 << i + 5 * j) + (1 << (i + 1) + 5 * j) + (1 << i + 5 * (j + 1));
				block[idx++] = (1 << i + 5 * j) + (1 << (i + 1) + 5 * j) + (1 << (i + 1) + 5 * (j + 1));
				block[idx++] = (1 << i + 5 * j) + (1 << i + 5 * (j + 1)) + (1 << (i + 1) + 5 * (j + 1));
				block[idx++] = (1 << (i + 1) + 5 * j) + (1 << i + 5 * (j + 1)) + (1 << (i + 1) + 5 * (j + 1));
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				block[idx++] = (1 << i + 5 * j) + (1 << i + 5 * (j + 1));
				block[idx++] = (1 << j + 5 * i) + (1 << (j + 1) + 5 * i);
			}
		}

	}

}
