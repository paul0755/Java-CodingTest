import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	// 집 < 2N , M <= 치킨집 <= 13
	static int[][] map; // 입력시 주어지는 지도
	static int[][] output; // M개만 남기가 치킨집을 남겨놨을때
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> houses = new ArrayList<>();
    static int minDistance = Integer.MAX_VALUE;
    static boolean[] selected;
	
	public static void main(String args[]) throws Exception{
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i=0 ; i <N ; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) houses.add(new int[]{i,j});
				if(map[i][j] == 2) chickens.add(new int[]{i,j});
			}
		}
		
		selected = new boolean[chickens.size()];
		com(0,0);
		System.out.println(minDistance);
		
		
		// 출력 : 도시의 최킨 거리의 최솟값.
		
	}
	
	private static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	
	private static void com(int depth, int start) {
		sb = new StringBuilder();
		if(depth == M) {
			// 탈출조건 
			minDistance = Math.min(minDistance, calDistance());
		}
		
		for(int i=start; i<chickens.size(); i++) {
			selected[i] = true;
			com(depth+1, i+1);
			selected[i] = false;
		}
	}
	
	static int calDistance() {
		int sum = 0;
		for(int[] h : houses) {
			int min = Integer.MAX_VALUE;
			for(int i=0; i<chickens.size(); i++) {
				if(selected[i]) {
					int[]c = chickens.get(i);
					int dist = Math.abs(h[0]-c[0]) + Math.abs(h[1]-c[1]);
					min = Math.min(min, dist);
				}
			}
			sum += min;
		}
		return sum;
	}
}
