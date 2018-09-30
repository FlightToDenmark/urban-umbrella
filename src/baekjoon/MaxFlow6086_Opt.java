package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MaxFlow6086_Opt {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		short[][] c = new short[52][52];
		short[][] f = new short[52][52];
		@SuppressWarnings("unchecked")
		LinkedList<Byte>[] adj = new LinkedList[52];
		for (int v = 0; v < 52; v++) {
			adj[v] = new LinkedList<>();
		}

		StringTokenizer st;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			char aa = st.nextToken().charAt(0);
			char bb = st.nextToken().charAt(0);
			byte a = (byte) ((aa <= 'Z') ? aa - 65 : aa - 71);
			byte b = (byte) ((bb <= 'Z') ? bb - 65 : bb - 71);
			c[a][b] = c[b][a] += Short.parseShort(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}

		int totalFlow = 0;
		while (true) {
			byte[] prev = new byte[52];
			Arrays.fill(prev, (byte) -1);
			Queue<Byte> Q = new LinkedList<>();
			Q.add((byte) 0);
			while (!Q.isEmpty()) {
				byte here = Q.poll();
				for (byte next : adj[here]) {
					if (c[here][next] - f[here][next] > 0 && prev[next] == -1) {
						Q.add(next);
						prev[next] = (byte) here;
						if (next == 25)
							break;
					}
				}
			}
			if (prev[25] == -1) {
				break;
			}
			int flow = Integer.MAX_VALUE;
			for (byte i = 25; i != 0; i = prev[i]) {
				flow = Math.min(flow, c[prev[i]][i] - f[prev[i]][i]);
			}
			for (byte i = 25; i != 0; i = prev[i]) {
				f[prev[i]][i] += flow;
				f[i][prev[i]] -= flow;
			}
			totalFlow += flow;

		}
		bw.write(totalFlow + "\n");
		bw.flush();
	}

}
