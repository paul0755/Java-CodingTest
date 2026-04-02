import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[][] visited;
    static int[] dy = {1, 0, -1, 0}; //위 - 아래
    static int[] dx = {0, 1, 0, -1}; //오른 - 왼
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    public static void main(String[] args) throws Exception, IOException {
        
        StringTokenizer st  = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = line.charAt(j) - '0'; // 문자 -> 숫자 변환       
            }
        }

        bfs(0,0);

        System.out.println(visited[N-1][M-1]);

    }

    private static void bfs(int y, int x){
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{y,x});
        visited[y][x] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for(int d=0; d<4; d++){
                int ny = cy + dy[d];
                int nx = cx + dx[d];

                if(ny <0 || nx <0 || ny >= N || nx >= M) continue;
                if(map[ny][nx] == 0) continue;
                if(visited[ny][nx] != 0) continue;

                visited[ny][nx] = visited[cy][cx] + 1;
                q.offer(new int[]{ny,nx});
            }
        }
    }
}
