import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int M, N  ,num = 0;
	static int[][] visited;
	static int[][] map;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Queue<int []> q = new ArrayDeque<>();
		
		visited = new int[M][N];
		map = new int[M][N];
		
		for(int i=0; i<M ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N ; j++ ) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
//		for(int i=0; i<M ; i++) {
//			for(int j=0; j<N ; j++ ) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for(int i=0; i<M ; i++) {
			for(int j=0; j<N ; j++ ) {
				if(map[i][j] == 1) {
					q.offer(new int[] {i,j});
				}
			}
		}
		bfs(q);
		
		for(int i=0; i<M ; i++) {
			for(int j=0; j<N ; j++ ) {
				if(map[i][j] == -1 && visited[i][j]==0) {
					visited[i][j] = -1;
				}
				
				if(visited[i][j] == 0) {
					num = -1;
				}
				
				if(num == 0) {
					
				}
			}
		}
		
		
		
		System.out.println(num);
	}

	private static void bfs(Queue<int []> starts) {
		Queue<int []> q = new ArrayDeque<>();
		for (int[] start : starts) {
		    q.offer(start);
		    visited[start[0]][start[1]] = 1; // 초기 거리(또는 방문 표시)
			}

		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0]; int x = cur[1];
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny < 0 || nx < 0 || ny >= M || nx >= N) continue;
				
				if(visited[ny][nx] == 0 && map[ny][nx] != -1 ) {
					visited[ny][nx] = visited[y][x] + 1;
					q.offer(new int[] {ny,nx});
					num = visited[ny][nx] -1;
				}
			}
		}
		
		
		
	}
}
