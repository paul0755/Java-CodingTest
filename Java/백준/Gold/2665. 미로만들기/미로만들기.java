import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
/**
 * 이 문제의 핵심은 “벽을 부순 개수(=비용)”을 최소화하면서 도착점에 가는 최단경로를 구하는 거예요.

 */

public class Main {

    static int n, cnt=0;
    static int[][] map;
    static int[][] dist;
    //static List<List<int[]>> graph = new ArrayList<>();

    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    
    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dist = new int[n][n];
        
        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++){
                dist[i][j] = 100;
            }
        }

        for(int i=0; i<n; i++){
            String tmp = br.readLine();
            for(int j=0; j<n ; j++){
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        bfs(0,0,0);

        System.out.println(dist[n-1][n-1]);
        
    }

    private static void bfs(int sy, int sx, int b_cnt) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[2]));
        dist[sy][sx] = 0;
        pq.offer(new int[]{sy,sx, b_cnt}); // y,x, 벽 부순 횟수

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int y = cur[0];
            int x = cur[1];
            int cost = cur[2];

            // 이미 더 짧은 경로로 방문했다면 skip
            if(cost > dist[y][x]) continue;
            
            for(int d=0; d<4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];

                if(ny < 0 || nx <0 || ny>=n || nx>=n) continue;

                // 다음 칸의 비용 계산
                int nextCost = cost + (map[ny][nx] == 0 ? 1 : 0);

                // 더 적은 비용으로 갈 수 있으면 갱신
                if(nextCost < dist[ny][nx]){
                    dist[ny][nx] = nextCost;
                    //System.out.println("dist[ny][nx] : " + dist[ny][nx]) ;
                    pq.offer(new int[]{ny,nx, nextCost});
                }
            }
        }

    }

    

}
