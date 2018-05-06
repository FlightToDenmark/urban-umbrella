package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoomNumber15668 {

	static int I;
	static int number;
	static boolean[] isUsed;
	static long num1, num2;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		number = Integer.parseInt(input);

		isUsed = new boolean[10];
		num1 = 0;
		num2 = 0;

		makeNumber1();
		System.out.println(-1);

	}

	public static boolean makeNumber1() {

		if (isAllUsed()) return false;

		for (int i = I; i < 10; i++) {
			if (!isUsed[i]) {
				num1 = num1 * 10 + i;
				isUsed[i] = true;
				if (makeNumber2() || makeNumber1())	return true;
				isUsed[i] = false;
				num1 = num1 / 10;
			}

		}
		return false;

	}

	public static boolean makeNumber2() {

		if (isAllUsed()) return false;

		for (int i = I; i < 10; i++) {
			if (!isUsed[i]) {
				num2 = num2 * 10 + i;
				isUsed[i] = true;
				if (checkSum() || makeNumber2()) return true;
				isUsed[i] = false;
				num2 = num2 / 10;
			}
		}
		return false;

	}

	public static boolean checkSum() {

		if (num1 != 0 && num2 != 0 && num1 + num2 == number) {
			System.out.println(num1 + " + " + num2);
			System.exit(0);
			return true;
		}
		return false;

	}

	public static boolean isAllUsed() {

		for (int i = 0; i < 10; i++) {
			if (!isUsed[i]) {
				I = i;
				return false;
			}
		}
		return true;

	}

}
