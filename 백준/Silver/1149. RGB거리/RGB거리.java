import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] R, G, B;
    static int [][] arr;
    static int [][] dp;
    
    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][3];
        dp = new int[N+1][3];

        for(int i=0; i<N; i++ ){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        R = new int[N+1];
        G = new int[N+1];
        B = new int[N+1];
        
        for(int i=1; i<=N; i++ ){
            R[i] = arr[i-1][0];
        }
        for(int i=1; i<=N; i++ ){
            G[i] = arr[i-1][1];
        }
        for(int i=1; i<=N; i++ ){
            B[i] = arr[i-1][2];
        }

        dp[1][0] = R[1];
        dp[1][1] = G[1];
        dp[1][2] = B[1];

        for(int i=2; i<=N; i++){

            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + R[i];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + G[i];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + B[i]; 
        }

        int result = Math.min(dp[N][0], dp[N][1]);
        result = Math.min(result, dp[N][2]);

        System.out.println(result);

    }
}
