package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BigSorting {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		List<String> list = new ArrayList<>();

		for (int i = 0; i < n; i++) list.add(sc.next());

		list.sort((a, b) -> a.compareTo(b));
		list.sort((a, b) -> a.length() - b.length());

		list.forEach(System.out::println);

		sc.close();

	}

}
