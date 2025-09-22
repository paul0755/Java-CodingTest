import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int T, N, M, K;
	static int[][] visited;
	static int[][] map;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int cnt =0;
			
			map = new int[N][M];
			visited = new int[N][M];
 			
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
//			for(int k=0; k<N; k++) {
//				for(int l=0; l<M; l++) {
//					System.out.print(map[k][l] + " ");  
//				}
//				System.out.println();
//			}
			for(int k=0; k<N; k++) {
				for(int l=0; l<M ; l++) {
					if(visited[k][l] == 0 && map[k][l] ==1) { // 방문안했을시
						cnt = bfs(k,l, cnt);
					}
				}
			}
			
			System.out.println(cnt);
		}
		
		
		
		
	}

	private static int bfs(int sy, int sx, int cnt) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[sy][sx] = 1;
		q.offer(new int[] {sy, sx});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0]; int x = cur[1];
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny <0 || nx < 0 || ny >=N || nx >=M) continue;
				
				if(visited[ny][nx] == 0 && map[ny][nx] ==1) {
					visited[ny][nx] = 1;
					q.offer(new int[] {ny,nx});
				}
			}
		} // while
		cnt++;
		return cnt;
	}

}
