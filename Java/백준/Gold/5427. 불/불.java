import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int T, W, H;
	static int[][] visited;
	static char[][] map;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		
		T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			Queue<int[]> fireQ = new ArrayDeque<>();
			Queue<int[]> personQ = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			visited = new int[H][W];
			
			for(int j=0; j<H; j++) {
				String tmp = br.readLine();
				for(int k=0; k<W; k++) {
					map[j][k] = tmp.charAt(k); 
				}
			}
			
			for(int j=0; j<H; j++) {
				for(int k=0; k<W; k++) {
					if(map[j][k] == '*' ) {
						visited[j][k] = 1;
						fireQ.offer(new int[] {j,k});
					}
					if(map[j][k] == '@') {
						visited[j][k] = 1;
						personQ.offer(new int[] {j,k});
					}
					 
				}
			}
			
			bfs(fireQ, personQ);
						
		}
		
//		for(int i=0; i<H ; i++) {
//			for(int j=0; j<W; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		

	}

	private static void bfs(Queue<int[]> fireq, Queue<int[]> personq ) {
		while(!personq.isEmpty()) {
			
			
			int fireSize = fireq.size();
			for(int i=0; i< fireSize; i++) {
				int [] cur = fireq.poll();
				int y= cur[0], x = cur[1];
				
				for(int d=0; d<4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					
					if(ny<0 || nx<0 || ny>=H || nx>=W) continue;
					
					if(map[ny][nx] == '@' || map[ny][nx] == '.') {
						map[ny][nx] = '*';
						fireq.offer(new int[] {ny,nx});
					}
				}
			}
			
			int personSize = personq.size();
			for(int i=0; i< personSize; i++) {
				int[] cur = personq.poll();
				int y=cur[0], x=cur[1];
				if (y==0 || x == 0 || y == (H-1) || x == (W-1)) {
					System.out.println(visited[y][x]);
					return;
				}
				for(int d=0; d<4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					
					if(ny<0 || nx<0 || ny>=H || nx>=W) continue;
					
					if(visited[ny][nx] == 0 && map[ny][nx] == '.') {
						visited[ny][nx] = visited[y][x] +1;
						map[ny][nx] = '@';
						personq.offer(new int[] {ny,nx});
					}
				}
				
			}
		} // while
		
		System.out.println("IMPOSSIBLE");
	}

}
