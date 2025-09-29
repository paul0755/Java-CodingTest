import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K;
	static int[][][] visited;
	static int[][] map;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static int min_num = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[N][M][K+1];
		
		for(int i =0; i<N ; i++) {
			String tmp = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		
//		for(int i =0; i<N ; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		int result = bfs(0,0);
		System.out.println(result);
		

	}

	private static int bfs(int sy, int sx) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[sy][sx][0] = 1;
		q.offer(new int[] {sy,sx,0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0], x=cur[1], state=cur[2];
			if(y == N-1 && x == M-1) {
				return visited[y][x][state];
			}
			
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny<0 || nx<0|| ny>=N || nx>=M) continue;
				
				if(visited[ny][nx][state] == 0 && map[ny][nx] == 0) {
					visited[ny][nx][state] = visited[y][x][state]+ 1;
					q.offer(new int[] {ny,nx, state});
				}
				
				if (map[ny][nx] == 1 && state < K && visited[ny][nx][state+1] == 0) {
				    visited[ny][nx][state+1] = visited[y][x][state] + 1;
				    q.offer(new int[] {ny, nx, state+1});
				}
			}
		} // while
		
		return -1;
	}

}
