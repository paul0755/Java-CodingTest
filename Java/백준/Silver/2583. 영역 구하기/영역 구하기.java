import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N, K;
	static int[][] visited;
	static int[][] map;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new int[M][N];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// 직사각형 내부 방문 표시
			for(int j=y1 ; j<y2; j++) {
				for(int k=x1; k<x2; k++) {
					visited[j][k] = 1;
				}
			}
			
		}
		
		// 빈공간 넓이 측정
		List<Integer> areas = new LinkedList<>();
		for(int j=0 ; j<M; j++) {
			for(int k=0; k<N; k++) {
				if(visited[j][k] == 0) {
					areas.add(bfs(j,k));
				}
			}
		}
		
		Collections.sort(areas);
		System.out.println(areas.size());
		for(int num: areas) {
			System.out.print(num + " ");
		}

	}

	private static int bfs(int sy, int sx) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[sy][sx] = 1;
		q.offer(new int[] {sy,sx});
		
		int area = 1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y= cur[0], x=cur[1];
			for(int d=0; d<4; d++) {
				int ny= y+dy[d];
				int nx= x+dx[d];
				
				if(nx<0 || ny<0 || ny>= M || nx>= N) continue;
				
				if(visited[ny][nx] != 0) continue; 
				
				
				visited[ny][nx] =  1;
				q.offer(new int[] {ny,nx});
				area ++;
				
			} // for
		} // while

		return area;
	}

}
