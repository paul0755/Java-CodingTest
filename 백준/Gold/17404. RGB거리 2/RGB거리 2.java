import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int N;
    static int[][] cost;
    static int[][] dp;
    static int INF = 1000000000;

    
    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        N = Integer.parseInt(br.readLine());

        dp = new int[N+1][3];
        cost = new int[N+1][3]; 

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = INF;

        for(int first = 0; first<3; first++){

            for(int i=0; i<3; i++){
                dp[1][i] = (i==first) ? cost[1][i] : INF; 
            }

            // RGB 거리 1과 동일
            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
            }

            // 마지막 집은 첫 집과 같은 색 불가능!!
            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor != first) {
                    answer = Math.min(answer, dp[N][lastColor]);
                }
            }
        }

        System.out.println(answer);




    }
}
