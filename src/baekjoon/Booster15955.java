package baekjoon;

import java.io.*;
import java.util.*;

public class Booster15955 {

	static int[] rank, parent;
	static final int QUERY = 0, EDGE = -1;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		rank = new int[N + 1];
		Arrays.fill(rank, 1);
		parent = new int[N + 1];
		for (int n = 0; n <= N; n++)
			parent[n] = n;

		List<P> pointList = new ArrayList<>();
		List<Input> inputList = new ArrayList<>();
		List<Answer> answerList = new ArrayList<>();

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			pointList.add(new P(n, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		int queryNum = 1;
		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			inputList.add(new Input(queryNum++, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		Collections.sort(pointList, Comparator.comparing(P::getX));
		for (int n = 1; n < N; n++) {
			P from = pointList.get(n - 1);
			P to = pointList.get(n);
			if (to.x - from.x == 0) {
				union(from.index, to.index);
				continue;
			}
			inputList.add(new Input(EDGE, from.index, to.index, to.x - from.x));
		}

		Collections.sort(pointList, Comparator.comparing(P::getY));
		for (int n = 1; n < N; n++) {
			P from = pointList.get(n - 1);
			P to = pointList.get(n);
			if (to.y - from.y == 0) {
				union(from.index, to.index);
				continue;
			}
			inputList.add(new Input(EDGE, from.index, to.index, to.y - from.y));
		}

		Collections.sort(inputList, Comparator.comparing(Input::getDist).thenComparing(Input::getIndex));
		for (Input input : inputList) {
			if (input.index == EDGE) { // is Edge
				union(input.from, input.to);
			} else { // is Query
				if (find(input.from) == find(input.to)) {
					answerList.add(new Answer(input.index, "YES"));
				} else {
					answerList.add(new Answer(input.index, "NO"));
				}
			}
		}

		Collections.sort(answerList, Comparator.comparing(Answer::getIndex));
		for (Answer answer : answerList) {
			bw.write(answer.answer + "\n");
		}
		bw.flush();
		bw.close();

	}

	static void union(int x, int y) {

		x = find(x);
		y = find(y);

		if (x == y)
			return;

		if (rank[y] > rank[x]) { // x > y
			int tmp = x;
			x = y;
			y = tmp;
		}

		parent[y] = x;
		if (rank[x] == rank[y])
			rank[x]++;

	}

	static int find(int x) {

		while (x != parent[x])
			x = parent[x];
		return x;

	}

}

class P {

	int index, x, y;

	public P(int index, int x, int y) {
		super();
		this.index = index;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}

class Input {

	int index; // -1: Edge, 0: Query
	int from, to, dist;

	public Input(int index, int from, int to, int dist) {
		super();
		this.index = index;
		this.from = from;
		this.to = to;
		this.dist = dist;
	}

	public int getDist() {
		return dist;
	}

	public int getIndex() {
		return index;
	}

}

class Answer {

	int index;
	String answer;

	public Answer(int index, String answer) {
		super();
		this.index = index;
		this.answer = answer;
	}

	public int getIndex() {
		return index;
	}

}