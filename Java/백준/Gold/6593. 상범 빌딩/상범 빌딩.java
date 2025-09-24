import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int L, R, C;
	static int[][][] visited;
	static char[][][] map;
	static int[] dy = {-1,0,1,0,0,0};
	static int[] dx = {0,1,0,-1,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {			
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new char[L][R][C];
			visited = new int[L][R][C];
			
			for(int i=0; i<L; i++) {
				for(int j=0; j<R; j++) {
					String tmp = br.readLine();
					for(int k=0; k<C; k++) {
						map[i][j][k] = tmp.charAt(k);
					}
				}
				 br.readLine(); // <-- 층과 층 사이의 빈 줄 처리
			}
			
//			for(int i=0; i<L; i++) {
//				for(int j=0; j<R; j++) {
//					for(int k=0; k<C; k++) {
//						System.out.print(map[i][j][k]);
//					}
//					System.out.println();
//				}
//				System.out.println();
//			}
			
			for(int i=0; i<L; i++) {
				for(int j=0; j<R; j++) {
					for(int k=0; k<C; k++) {
						if(map[i][j][k] == 'S') {
							bfs(i,j,k);
						}
					}
				}
			}
			
			
			
			if(L==0 && R==0&& C==0) break;
			
			
			
		} // while
		
		

	}

	private static void bfs(int sz, int sy, int sx) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[sz][sy][sx] = 1;
		q.offer(new int[] {sz,sy,sx});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int z =cur[0], y=cur[1], x=cur[2];
			if(map[z][y][x] == 'E') {System.out.printf("Escaped in %d minute(s).\n",visited[z][y][x]-1);
				return;
			} 
			
			for(int d=0; d<6; d++) {
				int nz = z + dz[d];
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				
				if(nz <0 || nx <0|| ny <0|| nz>=L || ny >= R|| nx>= C) continue;
				
				if(visited[nz][ny][nx] == 0 && (map[nz][ny][nx] == '.' || map[nz][ny][nx] == 'E' )) {
					visited[nz][ny][nx] = visited[z][y][x] + 1;
					q.offer(new int[] {nz,ny,nx});
				}
			}
		}// while
		System.out.println("Trapped!");
	}

}
