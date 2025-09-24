import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int F,S,G,U,D;
	static int[] visited;
	static int[] floor;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		floor = new int[F+1];
		visited = new int[F+1];
		

        if (S == G) {   // 시작과 목표가 같을 때 예외처리
            System.out.println(0);
            return;
        }
		
		bfs(S);
		
	}

	private static void bfs(int sx) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[sx] = 1;
		q.offer(sx);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			int[] moves = {U, -D};
			for(int d=0; d<2; d++) {
				int nx = x + moves[d];
				
				if(nx <= 0 || nx > F) continue;
				
				
				if(nx == G) {
					visited[nx] = visited[x]+1;
					System.out.println(visited[nx]-1);
					return;
				}
				
				if(visited[nx] == 0) {
					visited[nx] = visited[x] + 1;
					q.offer(nx);
				}
			}
		}// while
		
		System.out.println("use the stairs");
		return;
	}

}
