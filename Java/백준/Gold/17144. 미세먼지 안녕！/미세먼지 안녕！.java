import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C, T;
    static int[][] map;
    
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 공기 청정기 위치 확인
        List<Integer> pl = new ArrayList<>();
        for(int i=0; i<R; i++){
            if(map[i][0] == -1){
                pl.add(i);
            }
        }

        int top = pl.get(0);
        int bottom = pl.get(1);

        for(int k=0; k<T; k++){
            int[][] temp = new int[R][C];

            temp[top][0] = -1;
            temp[bottom][0] = -1;
    
            for(int y=0 ; y<R ; y++){
                for(int x=0 ; x<C ; x++){
                    if(map[y][x] > 0){ // 미세먼지 있는 칸
                        int amount = map[y][x] /5;
                        int cnt =0;
    
                        for (int d = 0; d < 4; d++) {
                            int ny = y + dy[d];
                            int nx = x + dx[d];
    
                            if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
                            if (map[ny][nx] == -1) continue; // 공기청정기에는 확산 불가
    
                            temp[ny][nx] += amount;
                            cnt++;
                        }
    
                        temp[y][x] += map[y][x] - amount *cnt;
                    }
                }
            }
    
            map = temp;
    
            // 반시계 바람 순환하기
            // 왼쪽 : 위 -> 아래
            for(int i=top-1; i>0 ; i--){
                map[i][0] = map[i-1][0];
            }
            // 위쪽 : 오른쪽 -> 왼쪽
            for(int i=0; i<C-1; i++){
                map[0][i] = map[0][i+1];
            }
            // 오른쪽 : 아래 -> 위
            for(int i=0; i<top; i++){
                map[i][C-1] = map[i+1][C-1];
            }
            // 밑 : 왼쪽 -> 오른쪽
            for(int i=C-1; i>1 ; i--){
                map[top][i] = map[top][i-1];
            }
            map[top][1] = 0; // ✅ 추가
    
            
            // 시계 바람 순환하기
            // 왼쪽 : 아래 -> 위
            for(int i=bottom+1; i<R-1; i++ ){
                map[i][0] = map[i+1][0];
            } 
            // 아래쪽 : 오른쪽 -> 왼쪽
            for(int i=0; i<C-1; i++){
                map[R-1][i] = map[R-1][i+1]; 
            }
            // 오른쪽 : 위 -> 아래
            for(int i=R-1; i>bottom; i--){
                map[i][C-1] = map[i-1][C-1];
            }
            // 위쪽 : 왼쪽 -> 오른쪽
            for(int i= C-1; i>1 ; i--){
                map[bottom][i] = map[bottom][i-1];
            }
            map[bottom][1] = 0; // ✅ 추가
        }

        int sum = 0;
        for(int y=0; y<R; y++){
            for(int x=0 ;x<C; x++){
                if(map[y][x] > 0) sum += map[y][x];
            }
        }

        System.out.println(sum);
    }


}
