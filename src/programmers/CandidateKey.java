package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CandidateKey {

	static int N = 1;
	static int col, before;
	static boolean visited[] = new boolean[8];
	static List<Integer> keySetCandidate;
	static List<Integer> keySetList = new ArrayList<>();

	public static void main(String[] args) {

		String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "1" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };

		System.out.println(solution(relation));

	}

	public static int solution(String[][] relation) {

		int answer = 0;

		col = relation[0].length;
		int row = relation.length;

		Set<String> set;
		while (N <= col) {
			keySetCandidate = new ArrayList<>();
			before = -1;
			makeSet(0);

			for (int keySet : keySetCandidate) {
				set = new HashSet<>();
				for (int r = 0; r < row; r++) {
					String plus = "";
					for (int n = 0; n < col; n++) {
						if ((keySet & (1 << n)) != 0) {
							plus += relation[r][n];
						}
					}
					set.add(plus);
				}
				if (set.size() == row) {
					keySetList.add(keySet);
				}
			}

			N++;

		}

//		for (int s : keySetList) {
//			System.out.println(s + " " + Integer.toBinaryString(s));
//		}

		int size = keySetList.size();
		for (int i = 0; i < size; i++) {
			boolean candidateKey = true;
			for (int j = 0; j < i; j++) {
				if ((keySetList.get(i) & keySetList.get(j)) == keySetList.get(j)) {
					candidateKey = false;
				}
			}
			if (candidateKey) {
				answer++;
			}
		}
		return answer;

	}

	static void makeSet(int num) {

		if (Integer.bitCount(num) == N) {
			keySetCandidate.add(num);
		}

		for (int c = before + 1; c < col; c++) {
			if (!visited[c]) {
				visited[c] = true;
				before = c;
				makeSet(num + (1 << c));
				visited[c] = false;
			}
		}

	}

}
