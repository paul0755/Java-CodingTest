import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int[] visited;
	static int[] map;
	static int mx = 100001;
	static int[] prev;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[mx];
		visited = new int[mx];
		
		bfs(N);
		
	}


	private static void bfs(int sx) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[sx] = 1;
		q.offer(sx);
		
		prev = new int[mx];
		Arrays.fill(prev, -1);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			if(x == K) {
				System.out.println(visited[x]-1);
				

				List<Integer> path = new ArrayList<>();
				for (int cur = K; cur != -1; cur = prev[cur]) {
				    path.add(cur);
				}
				Collections.reverse(path);
				
				// 경로 출력
				for (int p : path) {
				    System.out.print(p + " ");
				}
			}
			int[] dx = {x-1,x+1,x*2};
			
			for(int d=0; d<3; d++) {
				int nx = dx[d];
				
				if(nx<0 || nx>=mx) continue;
				
				if(visited[nx] == 0) {
					visited[nx] = visited[x] +1;
					prev[nx] = x;
					q.offer(nx);
				}
			}
		}
		
	}

}
