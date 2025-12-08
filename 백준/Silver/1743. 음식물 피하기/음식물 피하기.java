import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N, M, K, cnt;
    static int[][] map;
    static int[][] visited;

    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int maxCnt = 0;

        map = new int[N][M];
        visited = new int[N][M];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r-1][c-1] = 1;
        }

        for(int i=0 ;i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 1 && visited[i][j] == 0){
                    cnt = 0;
                    dfs(i,j);
                    maxCnt = Math.max(maxCnt, cnt);
                }
            }
        }
        System.out.println(maxCnt);
    }

    private static void dfs(int i, int j) {
        
        visited[i][j] = 1;

        if(map[i][j] == 1) cnt++;

        for(int d=0; d<4; d++){
            int ny = i + dy[d];
            int nx = j + dx[d];

            if(ny < 0 || nx < 0 || ny >=N || nx >= M) continue;

            if(map[ny][nx] == 1 && visited[ny][nx] == 0){
                dfs(ny, nx);
            }
        }

    }
}
