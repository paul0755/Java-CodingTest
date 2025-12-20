import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    
    static int[][] map = new int[5][5];
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};

    static Set<List<Integer>> set = new HashSet<>();
    static List<Integer> list;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                list = new ArrayList<>();
                list.add(map[i][j]);
                dfs(i,j,1);
            }
        }

        System.out.println(set.size());
        
    }

    static private void dfs(int y, int x, int depth){

        if(depth == 6){
            //System.out.println("list :" + list);
            set.add(new ArrayList<>(list));
            return;
        }


        for(int d = 0 ; d<4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];

            if(ny <0 || nx <0 || ny>=5 || nx >= 5) continue;

            list.add(map[ny][nx]);
            dfs(ny, nx, depth+1);
            list.remove(list.size()-1);
        }


    }
}
