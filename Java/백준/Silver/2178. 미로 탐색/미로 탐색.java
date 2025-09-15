import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int map[][];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visit;
	
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N][M];
		Queue<int[]>q = new LinkedList<>();
		
		// 미로를 입력받아야 함.
		map = new int[N][M];
		for(int i=0; i<N ; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		q.add(new int[] {0,0});
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
		int[] cur = q.poll();
		int x = cur[0];
		int y = cur[1];
		
		for(int d=0; d<4 ; d++) {
			int nx = x+ dx[d];
			int ny = y+ dy[d];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if(!visit[nx][ny] && map[nx][ny]==1) {
					visit[nx][ny] = true;
					map[nx][ny] = map[x][y] + 1;
					q.add(new int[] {nx,ny});
				}
			}
		}
		}
		
		System.out.println(map[N-1][M-1]);
		
		
		
		
		
	}
	
}
