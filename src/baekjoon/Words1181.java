package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Words1181 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new TreeSet<>(Comparator.comparing(String::length).thenComparing(String::compareTo));
		for (int n = 0; n < N; n++) {
			set.add(br.readLine());
		}
		for (String s : set) {
			bw.write(s + "\n");
		}
		bw.flush();
		bw.close();

	}

}
