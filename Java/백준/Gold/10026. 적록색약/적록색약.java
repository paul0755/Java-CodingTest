import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static int N;
	static int[][] visited;
	static char[][] map;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	private static int R_count;
	private static int G_count;
	private static int B_count;
	private static int RG_count;
	

	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new int[N][N];
		
		for(int i=0; i<N ; i++) {
			String tmp = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = tmp.charAt(j);
			}
		} // for
		
//		for(int i=0; i<N ; i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		} // for
		
		for(int i=0; i<N ; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j] == 0 && map[i][j] == 'R') {
					bfs(i,j, 'R');
					R_count ++;
				}
				else if(visited[i][j] == 0 && map[i][j] == 'G') {
					bfs(i,j, 'G');
					G_count ++;
				}
				else if(visited[i][j] == 0 && map[i][j] == 'B') {
					bfs(i,j, 'B');
					B_count ++;
				}
					
			}
		}// for
		int normal = R_count + G_count + B_count;
		System.out.print(normal + " ");
		
		visited = new int[N][N];
		B_count = 0;
		
		
		
		for(int i=0; i<N ; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j] == 0 && (map[i][j] == 'R' || map[i][j] == 'G')) {
					bfs_RG(i,j);
					RG_count ++;
				}
				else if(visited[i][j] == 0 && map[i][j] == 'B') {
					bfs(i,j, 'B');
					B_count ++;
				}
					
			}
		}// for
		int abnormal = RG_count + B_count;
		System.out.print(abnormal);
		

	}


	private static void bfs(int sy, int sx, char color) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[sy][sx] = 1;
		q.offer(new int[]{sy, sx});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0]; int x = cur[1];
			for(int d=0; d<4 ; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny<0 || nx <0 || ny>=N || nx>=N ) continue;
				
				if(visited[ny][nx] ==0 && map[ny][nx] == color) {
					visited[ny][nx] = 1;
					q.offer(new int[] {ny,nx});
				} 
			}
		}
		
	}
	
	private static void bfs_RG(int sy, int sx) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[sy][sx] = 1;
		q.offer(new int[]{sy, sx});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0]; int x = cur[1];
			for(int d=0; d<4 ; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny<0 || nx <0 || ny>=N || nx>=N ) continue;
				
				if(visited[ny][nx] ==0 && (map[ny][nx] == 'R' || map[ny][nx] == 'G') ) {
					visited[ny][nx] = 1;
					q.offer(new int[] {ny,nx});
				} 
			}
		}
		
	}

}
