import java.util.*;

public class Main {

	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static int max_num =0;
	
	static int n, m, count = 0;
	static int[][]map;
	static int[][] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // y
		m = sc.nextInt(); // x
		
		map = new int[n][m];
		visit = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<n ; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1 && visit[i][j] == 0) {
					bfs(i,j);
				}
			}
		}
		
		System.out.println(count);
		System.out.print(max_num);
		

		
		
	}// main

	private static void bfs(int sy, int sx) {
		Queue<int[]> q = new ArrayDeque<>();
		visit[sy][sx] = 1;
		q.offer(new int[] {sy, sx});
		int cnt = 1;
	
		
		while(!q.isEmpty()) {
			int[]cur = q.poll();
			int y = cur[0], x = cur[1];
			for(int d=0; d<4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(ny<0 || nx<0 || ny>=n || nx>=m) continue;
				
				if(map[ny][nx] == 1 && visit[ny][nx] == 0) {
					cnt ++;
					visit[ny][nx] = cnt;
					q.offer(new int[] {ny,nx});
				}
			}
			
		}// while	
		max_num = Math.max(cnt, max_num);
		count ++;
	}//bfs

} // class
