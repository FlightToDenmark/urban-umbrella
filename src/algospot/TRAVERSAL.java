package algospot;

import java.util.Arrays;
import java.util.Scanner;

public class TRAVERSAL {

	public static int node;
	public static int[] preorder, inorder;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		while (testCase-- > 0) {
			node = sc.nextInt();
			preorder = new int[node];
			inorder = new int[node];
			for (int n = 0; n < node; n++) preorder[n] = sc.nextInt();
			for (int n = 0; n < node; n++) inorder[n] = sc.nextInt();
			printPostOrder(preorder, inorder);
			System.out.println();
		}

		sc.close();

	}

	public static void printPostOrder(int[] pre, int[] in) {

		int size = pre.length;
		if (size == 0) return;
		
		int root = pre[0];
		
		int m = 0;
		for (int n = 0; n < size; n++) if (in[n] == root) m = n;

		printPostOrder(Arrays.copyOfRange(pre, 1, m + 1), Arrays.copyOfRange(in, 0, m));
		printPostOrder(Arrays.copyOfRange(pre, m + 1, size), Arrays.copyOfRange(in, m + 1, size));

		System.out.print(root+ " ");

	}

}
