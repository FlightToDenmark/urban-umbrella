package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Danzi2667 {

	static int size;
	static int[] moveX = { 1, -1, 0, 0 };
	static int[] moveY = { 0, 0, -1, 1 };
	static boolean[][] board;
	static List<Integer> list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		board = new boolean[size][size];
		list = new ArrayList<>();

		String input;
		for (int i = 0; i < size; i++) {
			input = br.readLine();
			for (int j = 0; j < size; j++) {
				if (input.charAt(j) == '1')	board[i][j] = true;
			}
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board[i][j]) list.add(dfs(i, j));
			}
		}

		Collections.sort(list);
		System.out.println(list.size());
		for (int ans : list) System.out.println(ans);
		
	}

	static int dfs(int x, int y) {

		board[x][y] = false;
		int house = 1;

		int newX, newY;
		for (int i = 0; i < 4; i++) {
			newX = x + moveX[i];
			newY = y + moveY[i];
			if (newX >= 0 && newY >= 0 && newX < size && newY < size && board[newX][newY]) {
				house += dfs(newX, newY);
			}
		}
		return house;
	}
}
