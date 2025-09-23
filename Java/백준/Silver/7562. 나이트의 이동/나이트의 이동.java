import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int T, L, sy, sx, ly, lx;
	static int[][] map;
	static int[][] visited;
	static int[] dy = {2,1,-1,-2,-2,-1,1,2};
	static int[] dx = {1,2,2,1,-1,-2,-2,-1};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception, IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			L = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			sy = Integer.parseInt(st.nextToken());
			sx = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			ly = Integer.parseInt(st.nextToken());
			lx = Integer.parseInt(st.nextToken());
			
			map = new int[L][L];
			visited = new int[L][L];
			
			
			sb.append(bfs(sy,sx)).append("\n");
			
			
//			for(int j=0; j<L; j++) {
//				for(int k=0; k<L ; k++) {
//					System.out.print(visited[j][k] + " ");
//				}
//				System.out.println();
//			}
			
			
		}
		System.out.print(sb);
		
		

	}

	private static int bfs(int sy1, int sx1) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[sy1][sx1] =1 ;
		q.offer(new int[] {sy1, sx1});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0]; int x = cur[1];
			if(ly == y && lx ==x) return visited[y][x]-1;
			for(int d=0; d<8; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny <0 || nx<0 || ny>=L || nx >=L) continue;
				
				if(visited[ny][nx] == 0) {
					visited[ny][nx] = visited[y][x] +1;
					q.offer(new int[]{ny, nx});
				}
			}
			
		}
		return -1;
		
	}

}


/*
 * 1
8
0 0
7 0*/

