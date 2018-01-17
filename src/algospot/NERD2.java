package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class NERD2 {

	public static int N;
	public static int[] p, q;
	public static TreeMap<Integer, Integer> coords;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {
			N = Integer.parseInt(br.readLine());
			p = new int[N];
			q = new int[N];
			coords = new TreeMap<>();
			int total = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				p[i] = Integer.parseInt(st.nextToken());
				q[i] = Integer.parseInt(st.nextToken());
				total += registered(p[i], q[i]);
			}
			System.out.println(total);

		}

	}

	public static boolean isDominated(int x, int y) {

		Map.Entry<Integer, Integer> hE = coords.higherEntry(x);
		if (hE == null)	return false;
		return y < hE.getValue();

	}

	public static void removeDominated(int x, int y) {

		Map.Entry<Integer, Integer> lE = null;
		while (true) {
			lE = coords.lowerEntry(x);
			if (lE == null || y < lE.getValue()) return;
			coords.remove(lE.getKey());
		}

	}

	public static int registered(int x, int y) {

		if (isDominated(x, y)) return coords.size();
		removeDominated(x, y);
		coords.put(x, y);
		return coords.size();

	}

}
