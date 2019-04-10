import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			A[n] = Integer.parseInt(st.nextToken());
		}
		int left = 0, right = N, mid = 0, answer = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			List<Integer> part = new ArrayList<>(mid);
			for (int i = 0; i < mid; i++) {
				part.add(A[i]);
			}
			Collections.sort(part, Collections.reverseOrder());
			long sum = 0;
			for (int i = 0; i < (mid + 1) / 2; i++) {
				sum += part.get(2 * i);
			}
			if (sum <= H) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		bw.write(answer + "\n");
		bw.close();

	}

}
