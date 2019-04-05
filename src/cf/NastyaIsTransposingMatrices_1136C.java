import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] A = new ArrayList[N + M];
		ArrayList<Integer>[] B = new ArrayList[N + M];
		for (int i = 0; i < N + M; i++) {
			A[i] = new ArrayList<>();
			B[i] = new ArrayList<>();
		}
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				A[n + m].add(Integer.parseInt(st.nextToken()));
			}
		}
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				B[n + m].add(Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 0; i < N + M; i++) {
			Collections.sort(A[i]);
			Collections.sort(B[i]);
		}
		for (int i = 0; i < N + M; i++) {
			if (!A[i].equals(B[i])) {
				bw.write("NO\n");
				bw.close();
				return;
			}
		}
		bw.write("YES\n");
		bw.close();

	}

}
