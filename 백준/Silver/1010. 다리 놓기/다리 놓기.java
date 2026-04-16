import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 서쪽 -> 동쪽 (연결을 다 따져야하나 ?  => 복잡함)
 * 동쪽에서 N개를 고른다고 생각 (생각의 전환)
 * 왜냐?
 * 서쪽은 순서가 고정됨
 * 예 ) 서쪽 1 -> 먼저 연결 / 서쪽 2 -> 그 다음 연결
 * 동쪽에서 고른 N개를 왼쪽부터 순서대로 연결하면 절대 안겹침
 *  
 * “파스칼 삼각형 만들어놓고 M C N 꺼내 쓰는 문제”
 * 
 * dp[4][2] = 6

      j →
    0 1 2 3 4
i  ----------
0 | 1
1 | 1 1
2 | 1 2 1
3 | 1 3 3 1
4 | 1 4 6 4 1

 * 
 * 
 */

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T,N, M;

    // 0 < N <=M < 30
    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws Exception, IOException {

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<= 30 ; i++){
            dp[i][0] = 1; 
            dp[i][i] = 1;
            for(int j=1; j<i; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        StringBuilder sb = new StringBuilder();

        while(T-- >0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            sb.append(dp[M][N]).append("\n");
        }

        System.out.println(sb);
        

    }
}