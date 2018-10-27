package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CandidateKey_Optimize {

	public static void main(String[] args) {

		String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "1" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };

		System.out.println(solution(relation));

	}

	public static int solution(String[][] relation) {

		int col = relation[0].length;
		int row = relation.length;

		List<Integer> keySetList = new ArrayList<>();
		Set<String> set;
		for (int i = 1; i < (1 << col); i++) {
			set = new HashSet<>();
			for (int r = 0; r < row; r++) {
				String plus = "";
				for (int n = 0; n < col; n++) {
					if ((i & (1 << n)) != 0) {
						plus += relation[r][n];
					}
				}
				set.add(plus);
			}
			if (set.size() == row) {
				boolean candidateKey = true;
				int size = keySetList.size();
				for (int j = 0; j < size; j++) {
					if ((keySetList.get(j) & i) == keySetList.get(j)) {
						candidateKey = false;
					}
				}
				if (candidateKey) {
					keySetList.add(i);
				}
			}
		}
		return keySetList.size();

	}

}
