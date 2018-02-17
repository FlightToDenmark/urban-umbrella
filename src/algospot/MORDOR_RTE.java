package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MORDOR_RTE {
	
	public static int[] h;
	public static int[][] min, max;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		while(testCase-->0) {
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st1.nextToken());
			int way = Integer.parseInt(st1.nextToken());
			
			h = new int[height];
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i=0; i<height; i++) h[i] = Integer.parseInt(st2.nextToken());
			
			min = new int[height][height];
			max = new int[height][height];
			
			for(int i=0; i<height; i++) {
				min[i][i] = h[i];
				max[i][i] = h[i];
				for(int j=i+1; j<height; j++) {
					min[i][j] = Math.min(min[i][j-1], h[j]);
					max[i][j] = Math.max(max[i][j-1], h[j]);
				}
			}
						
			for(int i=0; i<way; i++) {
				StringTokenizer st3 = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st3.nextToken());
				int to = Integer.parseInt(st3.nextToken());
				System.out.println(max[from][to] - min[from][to]);
			}
			
		}
		
		br.close();
		
	}

}
