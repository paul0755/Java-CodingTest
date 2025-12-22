import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static int sheep, wolf;
    static char[][] map;
    static int[][] visited;

    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new int[R][C];

        for(int i=0; i<R; i++){
            String tmp = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = tmp.charAt(j);
            }
        }

        int totalSheep = 0;
        int totalWolf = 0;

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] != '#' && visited[i][j] == 0 ){
                    sheep = 0;
                    wolf = 0;
                    dfs(i,j);
                    if(sheep > wolf) totalSheep += sheep;
                    else totalWolf += wolf;
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
        
    }


    static void dfs(int y, int x ){

        visited[y][x] = 1;
        //System.out.println("visit :" + y + "," + x);

        if(map[y][x] == 'o') sheep++;
        if(map[y][x] == 'v') wolf++;

        for(int d=0 ; d<4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];

            // 범위 제한
            if(ny<0 || nx <0 || ny >=R || nx >=C) continue;


            if(visited[ny][nx] == 0 && map[ny][nx] != '#'){
                dfs(ny, nx);
            }

        }
    }
}
