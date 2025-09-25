import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, part, year;
	static int[][] visited;
	static int[][] map;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		while(true) {
			part = 0;
			visited = new int[N][M];
			int[][] temp = new int [N][M];
			
			int sum = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					sum += map[i][j];
				}
			}
			
			if (sum == 0) { 
				System.out.println(0);
				return;
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visited[i][j] == 0 && map[i][j] != 0) {
						bfs(i,j, temp);
						part++;
					}
				}
			}
			
			if(part >= 2) {
				System.out.println(year);
				return;
			}
			
			map = temp;
			year ++;
		}//while
		
			
			
	}
		


	private static void bfs(int sy, int sx, int[][] temp) {
		Queue<int []> q = new ArrayDeque<>();
		visited[sy][sx] = 1;
		q.offer(new int[] {sy,sx});
		
		while(!q.isEmpty()) {
			int[]cur = q.poll();
			int y= cur[0], x=cur[1];
			int zero_cnt = 0;
			for(int d=0 ; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny<0 || nx<0 || ny>=N || nx>= M) continue;
				
				if(map[ny][nx] == 0) zero_cnt ++;
								
				if(visited[ny][nx] == 0 && map[ny][nx] != 0) {
					visited[ny][nx] = 1;
					q.offer(new int[] {ny,nx});
				}
			} // for	
			temp[y][x] = Math.max(map[y][x] - zero_cnt, 0);  // 음수 방지
		}// while
	}

}
