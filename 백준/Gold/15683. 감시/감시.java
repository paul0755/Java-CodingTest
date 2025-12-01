import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static int N, M, result = Integer.MAX_VALUE;

    static List<CCTV> cctvList = new ArrayList<>();

    static class CCTV{
        int y,x, type;
        CCTV(int y, int x, int type){
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }

    static int[][][] dirs = {
    {}, 
    {{0}, {1}, {2}, {3}},                 // 1번 CCTV
    {{0,2}, {1,3}},                       // 2번 CCTV
    {{0,1}, {1,2}, {2,3}, {3,0}},         // 3번 CCTV
    {{0,1,2}, {1,2,3}, {2,3,0}, {3,0,1}}, // 4번 CCTV
    {{0,1,2,3}}                           // 5번 CCTV
};

    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};


    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int [][] board = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] != 0 && board[i][j] != 6){
                    cctvList.add(new CCTV(i, j, board[i][j]));
                }
            }
        }

        dfs(0, board);

        System.out.println(result);
    }


    private static void dfs(int depth, int[][] map) {
        if(depth == cctvList.size()){
            result = Math.min(result, countZero(map));
            return;
        }

        CCTV c = cctvList.get(depth);

        for(int[] dset : dirs[c.type]){
            int[][] copy = copyMap(map);

            for(int d: dset){
                watch(copy, c.y, c.x, d);
            }

            dfs(depth+1, copy);
        }
    }


    private static void watch(int[][] map, int y, int x, int d) {
        
        int ny = y + dy[d];
        int nx = x + dx[d];

        while(ny >= 0 && nx >= 0 && ny < N && nx <M && map[ny][nx] != 6){
            if(map[ny][nx] == 0) map[ny][nx] = -1;
            ny += dy[d];
            nx += dx[d];
        }

    }


    private static int[][] copyMap(int[][] map) {
        
        int[][] copy = new int[N][M];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }


    private static int countZero(int[][] map) {
        
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    cnt++;
                }
            }
        }

        return cnt;

    }

    

}