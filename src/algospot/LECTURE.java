package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LECTURE {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {

			String input = br.readLine();
			List<String> list = new ArrayList<>();

			for (int i = 0; i < input.length() / 2; i++) {
				list.add(input.substring(2 * i, 2 * i + 2));
			}

			Collections.sort(list);

			String output = "";
			for (String s : list) output += s;
			System.out.println(output);

		}

	}

}
