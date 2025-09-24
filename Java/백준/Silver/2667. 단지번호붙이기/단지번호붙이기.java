import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	
	static int N;
	static int[][] map;
	static int[][] visited;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new int [N][N];
		List<Integer> num = new LinkedList<>(); 
		
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			for(int j=0; j<N ; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N ; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N ; j++) {
				if(map[i][j] == 1 && visited[i][j] == 0 ) {
					num.add(bfs(i,j));
				}
			}
		}
		
		System.out.println(num.size());
		Collections.sort(num);
		
		for(int n : num) {
			System.out.println(n);
		}
		
		
		

	}

	private static int bfs(int sy, int sx) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[sy][sx] = 1;
		
		int area = 1;
		
		q.offer(new int[] {sy,sx});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0], x = cur[1];
			for(int d=0; d<4 ; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny <0 || nx < 0 || ny>=N || nx>=N) continue;
				
				if(visited[ny][nx] == 0 && map[ny][nx] == 1 ) {
					visited[ny][nx] = 1;
					q.offer(new int[] {ny,nx});
					area++;
				}
			}
		}
		
		return area;
	}

}
