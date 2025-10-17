import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /*
     * 💥첫시도 실패
     * 단순히 선생님 위치에서 상,하,좌,우에 학생이 있는지보고
     * 장애물 갯수가 3개이면서 바로 붙어있지않으면 가능이라 봤는데
     * 그렇게하면 안된다고함ㅠ
     * 
     * 
     * 
     */


    static int N;
    static char[][] map;
    static List<int[]> empty;
    static List<int[]> teachers; 
    
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        empty = new ArrayList<>();
        teachers = new ArrayList<>(); 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        // for(int i=0; i<N; i++){
        //     for(int j=0; j<N; j++){
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 'T'){
                    teachers.add(new int[]{i,j});
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 'X'){
                    empty.add(new int[]{i,j});
                }
            }
        }

        dfs(0,0);
        if(!checkAllTeacher()) System.out.println("NO");

        
    }
    private static void dfs(int start, int depth) {
        if(depth == 3){
            if(checkAllTeacher()){
                System.out.println("YES");
                System.exit(0);
            }
            return;    
        }

        for(int i = start ; i < empty.size(); i++){
            int[] pos = empty.get(i);
            map[pos[0]][pos[1]] = 'O';
            dfs(i+1, depth+1);
            map[pos[0]][pos[1]] = 'X';
        }
    }
    private static boolean checkAllTeacher() {
        for(int[] t : teachers){
            int y = t[0], x = t[1];
            for(int d=0; d<4; d++){
                int ny = y;
                int nx = x;

                while(true){ // 장애물 만나거나 범위 벗어날 때까지 직진
                    ny += dy[d];
                    nx += dx[d];

                    if(ny < 0 || nx <0 || ny >=N || nx >=N ) break;
                    if(map[ny][nx] == 'O') break;
                    if(map[ny][nx] == 'S') return false;
                }


            }
        }
        return true;
    }
    
}


/*
 * 
 * private static void check_student(int y, int x) {
        
        if(y < 0 || y >= N || x < 0 || x >= N ) return;
        

        // 상
        for(int i=y ; i<N; i++){
            if(map[i][x] == 'S') {
                if(map[i-1][x] == 'T') {
                    isPossible = false;
                    return;}
                empyt.add(new int[]{i-1,x});
            }
        }
        // 하
        for(int i=y ; i>0; i--){
            if(map[i][x] == 'S') {
                if(map[i+1][x] == 'T') {
                    isPossible = false;
                    return;}
                empyt.add(new int[]{i+1,x});
            }
        }
        // 우
        for(int i=x; i<N; i++){
            if(map[y][i] == 'S') {
                if(map[y][i-1] == 'T') {
                    isPossible = false;
                    return;}
                empyt.add(new int[]{y,i-1});
            }
        }
        // 좌
        for(int i=x; i>0; i--){
            if(map[y][i] == 'S'){
                if(map[y][i+1] == 'T') {
                    isPossible = false;
                    return;}
                empyt.add(new int[]{y,i+1});  
            } 
        }
        
        
    }
 */