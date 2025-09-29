import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int W, H, cnt;
	static int[][] visited;
	static int[][] map;
	static int[] dy = {-1,0,1,0,1,-1,-1,1};
	static int[] dx = {0,1,0,-1,1,1,-1,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		
		while(true) {
			
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken()); // 행
			H = Integer.parseInt(st.nextToken()); // 열

			if(W==0 && H==0) break;
			
			map = new int[H][W];
			visited = new int[H][W];
			
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			cnt = 0;
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(visited[i][j] == 0 && map[i][j] == 1) {
						bfs(i,j);
						cnt ++;
					}
				}
			}
			
			System.out.println(cnt);
			
		}
	}

	private static void bfs(int sy, int sx) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[sy][sx] = 1;
		q.offer(new int[] {sy,sx});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0], x= cur[1];
			
			for(int d=0; d<8; d++) {
				int ny = y+ dy[d];
				int nx = x+ dx[d];
				
				if(ny<0 || nx<0 || ny>= H || nx >=W) continue;
				
				if(visited[ny][nx]== 0 && map[ny][nx] == 1) {
					visited[ny][nx] = 1;
					q.offer(new int[] {ny, nx});
				}
			}
		}
		
		
	}

}
