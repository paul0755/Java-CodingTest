import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static int[][] visited;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			for(int j=0; j<M ; j++) {
				map[i][j] = tmp.charAt(j) - '0';
				// 문자 -> 숫자 변환
			}
		}
		
		
		
		bfs(0,0);
	
		System.out.println(visited[N-1][M-1]);
		//System.out.println(cnt);
		
	}


	private static void bfs(int sy, int sx) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[sy][sx] = 1;
		q.offer(new int[] {sy,sx});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y= cur[0]; int x=cur[1];
			for(int d=0; d<4 ; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny <0 || nx<0 || ny >=N || nx >= M) continue;
				
				if(visited[ny][nx] == 0 && map[ny][nx] == 1) {
					visited[ny][nx] = visited[y][x] + 1;
					q.offer(new int[] {ny,nx});
				}
			}
			
		}
		
		
	}// bfs

}
