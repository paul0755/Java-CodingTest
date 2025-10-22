import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map = new int[10][10];
    static int[] paper = {0,5,5,5,5,5};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0,0);

        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }

    }
    private static void dfs(int y, int x, int cnt) {
        
        // 모든 칸을 다 돌았다면
        if(y>= 10){
            answer = Math.min(answer, cnt);
            return;
        }

        // 이미 현재까지 붙인 수가 최소보다 많으면 가지치기
        if(cnt>= answer) return;

        // 다음 행으로 넘어가기
        if(x >= 10){
            dfs(y+1, 0, cnt);
            return;
        }

        // 이미 0이라 덮을 필요 없으면 오른쪽으로
        if(map[y][x] == 0){
            dfs(y, x+1, cnt);
            return;
        }

        // 이 자리가 1이면 1~5 크기 색종이를 시도
        for(int size = 5; size >= 1; size--){
            if(paper[size] == 0) continue;
            if(canPlace(y, x, size)){
                attach(y,x, size, 0);
                paper[size] --;
                dfs(y, x+size, cnt+1); // 다음칸 탐색
                attach(y, x, size, 1); // 원상복구
                paper[size] ++ ;
            }
        }

    }

    // 붙이거나 되돌리기
    private static void attach(int y, int x, int size, int val) {
        for(int i=y; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                map[i][j] = val;
            }
        }
    }
    private static boolean canPlace(int y, int x, int size) {
        if(y+size > 10 || x+size > 10) return false;

        for(int i=y ; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                if(map[i][j] == 0) return false;
            }
        }

        return true;
        
    }
}
