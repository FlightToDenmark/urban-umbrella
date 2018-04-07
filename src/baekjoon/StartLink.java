package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class StartLink {

	public static int N;
	public static int[][] S;
	public static boolean[] added;
	public static ArrayList<Integer> teamA, teamB;
	public static TreeSet<Integer> minimum;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.valueOf(br.readLine());
		added = new boolean[N + 1];
		S = new int[N + 1][N + 1];
		teamA = new ArrayList<>();
		minimum = new TreeSet<>();

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				S[i][j] = Integer.valueOf(st.nextToken());
			}
		}

		makeTeam(0);

		System.out.println(minimum.first());

	}

	public static void makeTeam(int num) {

		if (teamA.size() == N / 2) {
			makeOtherTeam();
			minimum.add(Math.abs(teamPoint(teamA) - teamPoint(teamB)));
			return;
		}

		for (int i = num + 1; i <= N; i++) {
			if (!added[i]) {
				teamA.add(i);
				added[i] = true;
				makeTeam(i);
				teamA.remove(teamA.indexOf(i));
				added[i] = false;
			}

		}

	}

	public static void makeOtherTeam() {

		teamB = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			if (!teamA.contains(i))	teamB.add(i);
		}

	}

	public static int teamPoint(ArrayList<Integer> list) {

		int sum = 0;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				int a = list.get(i);
				int b = list.get(j);
				sum += S[a][b] + S[b][a];
			}
		}
		return sum;

	}

}