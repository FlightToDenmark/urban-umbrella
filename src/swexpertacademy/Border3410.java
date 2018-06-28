package swexpertacademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Border3410 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int N, M;
		char[][] culture;
		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			culture = new char[M][N];
			int countW = 0;
			for (int m = 0; m < M; m++) {
				String input = br.readLine();
				Pattern pattern = Pattern.compile("W");
				Matcher matcher = pattern.matcher(input);
				while (matcher.find())
					countW++;
				culture[m] = input.toCharArray();
			}

			int min = countW;
			int border = 0;

			if (countW == 0) {
				border = 0;
				bw.write("#" + t + " " + border + " " + (border + 1) + "\n");
				continue;
			}

			if (countW == N * M) {
				border = N;
				bw.write("#" + t + " " + border + " " + (border + 1) + "\n");
				continue;
			}

			int EinW = 0;
			int WinE = 0;
			int WinW = 0;
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (culture[m][n] == 'E') {
						EinW++;
					} else {
						WinW++;
					}
				}
				WinE = countW - WinW;

				if (EinW + WinE < min) {
					border = n + 1;
					min = EinW + WinE;
				}
			}
			bw.write("#" + t + " " + border + " " + (border + 1) + "\n");
		}
		bw.flush();

	}

}
