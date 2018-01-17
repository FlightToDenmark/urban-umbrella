package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class INSERTION {

	public static int N;
	public static int[] shifted, A;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {

			N = Integer.parseInt(br.readLine());
			shifted = new int[N];
			A = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) shifted[n] = Integer.parseInt(st.nextToken());
					
			solve();

		}

	}

	public static void solve() {

		List<Integer> list = new ArrayList<Integer>();
		for (int n = 1; n <= N; n++) list.add(n);

		for (int i = N - 1; i >= 0; i--) {
			int index = i - shifted[i];
			A[i] = list.get(index);
			list.remove(index);
		}

		for (int n = 0; n < N; n++)	System.out.print(A[n] + " ");
		System.out.println();

	}

}
