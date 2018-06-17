package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class StudyGroup14572 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int M, d, A;
		// Student[] student = new Student[N];
		List<Student> student = new ArrayList<>();
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			A = 0;
			for (int m = 0; m < M; m++) {
				A |= (1 << Integer.parseInt(br.readLine()));
			}
			student.add(new Student(d, A));
		}

		Collections.sort(student);
		// Arrays.sort(student);
		// Arrays.sort(student, Comparator.comparing(Student::getD, (s1, s2) -> {
		// return s1.compareTo(s2);
		// }));

		int max = 0;
		int start = 0, end = 0;
		while (end < N) {
			if (start < end && student.get(end).d - student.get(start).d > D) {

				int and = student.get(start).a;
				int or = 0;
				for (int i = start; i < end; i++) {
					int a = student.get(i).a;
					or |= a;
					and &= a;
				}
				// int ans = 0;
				// for (int i = 1; i <= K; i++) {
				// if ((or - and & (1 << i)) >= 1)
				// ans++;
				// }
				int answer = Integer.bitCount(or - and) * (end - start);
				// int answer = ans * (end - start);
				if (answer > max)
					max = answer;
				start++;
			} else
				end++;
		}
		System.out.println(max);

	}

}

class Student implements Comparable<Student> {

	int d, a;

	public Student(int d, int a) {
		super();
		this.d = d;
		this.a = a;
	}

	@Override
	public int compareTo(Student s) {
		return this.d - s.d;
	}

}
