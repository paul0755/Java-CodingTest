import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	// 상,우,하,좌
	static int[]dy = {-1,0,1,0};
	static int[]dx = { 0,1,0,-1}; 

	static int N, L, R, count =0;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int days = 0;
        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<int[]> union = bfs(i, j); // 연합 찾기
                        if (union.size() > 1) {
                            int sum = 0;
                            for (int[] u : union) sum += map[u[0]][u[1]];
                            int avg = sum / union.size();
                            for (int[] u : union) map[u[0]][u[1]] = avg;
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) break;
            days++;
        }

        System.out.println(days);

		
	}

	private static List<int[]> bfs(int sy, int sx) {
		Queue<int[]> q = new LinkedList<>();
		List<int[]> union = new ArrayList<>();
		q.add(new int[] {sy,sx});
		visited[sy][sx] = true;
		union.add(new int[] {sy,sx});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0], x=cur[1];
			
			for(int d=0; d< 4 ; d++) {
				int ny = y+dy[d];
				int nx = x+dx[d];
				
				if(ny <0 || nx <0 || ny >= N || nx >= N)continue;
				if(visited[ny][nx]) continue;
				
				int diff = Math.abs(map[y][x] - map[ny][nx]);
				
				if(diff >= L && diff<= R) {
					visited[ny][nx] = true;
					q.add(new int[] {ny,nx});
					union.add(new int[] {ny,nx});
				}
			}
		}
		return union;
		
	}

}
