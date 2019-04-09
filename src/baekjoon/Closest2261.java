import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Point[] point = new Point[N];
		StringTokenizer st;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			point[n] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(point, (a, b) -> (a.x - b.x));
		TreeSet<Point> set = new TreeSet<>((a, b) -> ((a.y == b.y) ? a.x - b.x : a.y - b.y));
		set.add(point[0]);
		set.add(point[1]);
		int answer = dist(point[0], point[1]);
		int start = 0;
		for (int i = 2; i < N; i++) {
			Point here = point[i];
			while (start < i) {
				Point p = point[start];
				int x = here.x - p.x;
				if (x * x > answer) {
					set.remove(p);
					start += 1;
				} else {
					break;
				}
			}
			int d = (int) Math.sqrt((double) answer) + 1;
			for (Point p : set.subSet(new Point(-10001, here.y - d), new Point(10001, here.y + d))) {
				d = dist(here, p);
				answer = Math.min(answer, d);
			}
			set.add(here);
		}
		bw.write(answer + "\n");
		bw.close();

	}

	static int dist(Point A, Point B) {

		return (A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y);

	}

	static class Point {

		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}
