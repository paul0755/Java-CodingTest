import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N ,H, cnt =0;
	static int[][][] visited;
	static int[][][] map;
	static int[] dx = {1, -1, 0, 0, 0, 0};
	static int[] dy = {0, 0, 1, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 열
		N = Integer.parseInt(st.nextToken()); // 행
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		visited= new int[H][N][M];
		Queue<int[]> q= new ArrayDeque<>();
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M ; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		// 1인 위치를 큐에 모두 저장
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M ; k++) {
					if(map[i][j][k] == 1) {q.offer(new int[] {i,j,k});
						visited[i][j][k] =1 ;
					}
				}
			}
		}
		
		bfs(q);
		
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M ; k++) {
					if(map[i][j][k] == -1) visited[i][j][k] = -1;
					
					if(visited[i][j][k] == 0) cnt = -1;					
					
					}
				}
			}
		
		
		System.out.println(cnt);
		
		}
		
		

	

	private static void bfs(Queue<int[]> q) {
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int z = cur[0]; int y = cur[1]; int x = cur[2];
				for(int d=0; d<6 ; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d]; //dy로 오타표기
					int nz = z + dz[d];
					
					if(ny<0 || nx<0|| nz<0 || ny>= N || nx>= M || nz >= H) continue;
					
					
					if(visited[nz][ny][nx] == 0 && map[nz][ny][nx] == 0) {
						q.offer(new int[] {nz, ny, nx});
						visited[nz][ny][nx] = visited[z][y][x] +1;
						cnt = visited[nz][ny][nx]-1;
					}
				}
				
			}
		} // bfs
	}

