package hackerrank;

import java.util.Scanner;

public class BigSortingSelection {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] array = new String[n];
		for (int i = 0; i < n; i++)
			array[i] = sc.next();

		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (array[minIndex].length() > array[j].length())
					minIndex = j;
				if (array[minIndex].length() == array[j].length() && array[minIndex].compareTo(array[j]) > 0)
					minIndex = j;
			}
			String temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
			
		}

		for (int i = 0; i < n; i++)
			System.out.println(array[i]);

		sc.close();

	}

}
