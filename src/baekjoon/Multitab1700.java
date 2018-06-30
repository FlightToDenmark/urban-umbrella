package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Multitab1700 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		byte N = Byte.parseByte(st.nextToken());
		byte K = Byte.parseByte(st.nextToken());

		byte answer = 0;
		byte[] plug = new byte[N];
		byte[] input = new byte[K];
		st = new StringTokenizer(br.readLine());
		for (int k = 0; k < K; k++) {
			input[k] = Byte.parseByte(st.nextToken());
		}

		if (N >= K) {
			bw.write(0 + "\n");
			bw.flush();
			System.exit(0);
		}

		Loop: for (byte k = 0; k < K; k++) {
			byte max = 0;
			byte index = 0;
			for (byte n = 0; n < N; n++) {
				if (plug[n] == 0 || plug[n] == input[k]) {
					plug[n] = input[k];
					continue Loop;
				}
			}
			for (byte n = 0; n < N; n++) {
				boolean unused = true;
				for (int i = k + 1; i < K; i++) {
					if (plug[n] == input[i]) {
						unused = false;
						if (i > max) {
							max = (byte) (i);
							index = n;
						}
						break;
					}
				}
				if (unused) {
					index = n;
					break;
				}
			}
			plug[index] = input[k];
			answer++;
		}
		bw.write(answer + "\n");
		bw.flush();
	}

}
