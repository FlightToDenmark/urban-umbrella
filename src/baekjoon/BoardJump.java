package baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BoardJump {

	public static final int length = 5;
	public static int[][] board = new int[5][5];
	public static int[][] d = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	public static Set<String> set = new HashSet<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < length; i++)
			for (int j = 0; j < length; j++)
				board[i][j] = sc.nextInt();

		sc.close();

		for (int i = 0; i < length; i++)
			for (int j = 0; j < length; j++)
				jump(i, j, "");

		System.out.println(set.size());
		
	}

	public static void jump(int x, int y, String str) {

		if (str.length() == 6){
			set.add(str);
			return;
		}
			
		for (int i = 0; i < 4; i++) 
			if (x+d[i][0]>=0 && x+d[i][0]<length && y+d[i][1]>=0 && y+d[i][1]<length)
				jump(x + d[i][0], y + d[i][1], str + board[x][y]);

	}

}
