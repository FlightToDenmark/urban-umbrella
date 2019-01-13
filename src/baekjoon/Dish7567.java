package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Dish7567 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] dish = br.readLine().toCharArray();
		int h = 10;
		for (int i = 1; i < dish.length; i++) {
			if (dish[i] != dish[i - 1]) {
				h += 10;
			} else {
				h += 5;
			}
		}
		bw.write(h + "\n");
		bw.flush();

	}

}
