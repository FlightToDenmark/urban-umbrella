package cf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class WaterBuying {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int Q = Integer.parseInt(br.readLine());
		long n, a, b;
		StringTokenizer st;
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Long.parseLong(st.nextToken());
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			double two = (double) b / 2;
			if ((double) a < two) {
				bw.write(n * a + "\n");
			} else {
				bw.write((n / 2) * b + (n % 2) * a + "\n");
			}
		}
		bw.close();

	}

}
