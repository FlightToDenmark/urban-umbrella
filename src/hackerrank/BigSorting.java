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

		list.stream()
		 	.sorted((a, b) -> a.compareTo(b))
		 	.sorted((a, b) -> a.length() - b.length())
			.forEach(System.out::println);

		sc.close();

	}

}
