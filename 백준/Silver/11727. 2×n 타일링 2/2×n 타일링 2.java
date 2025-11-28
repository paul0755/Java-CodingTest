import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static int N;
    static int[] dp;
    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        if(N == 1){
            System.out.println(1);
            return;
        }

        dp = new int[N+1];

        dp[1] = 1;
        dp[2] = 3;

        for(int i=3; i<=N; i++){
            dp[i] = (dp[i-1] + 2*dp[i-2] ) % 10007;
        }

        System.out.println(dp[N]);

    }
}
