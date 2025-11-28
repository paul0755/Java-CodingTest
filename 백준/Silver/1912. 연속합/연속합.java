import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        dp = new int[N+1];

        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[1] = arr[1];
        if(N == 1){
            System.out.println(dp[1]);
            return;
        }
        for(int i=2; i<=N; i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
            //System.out.println("dp:" + dp[i]);
        }

        int answer = -1000;
        for(int i=1; i<=N; i++){
            answer = Math.max(answer,dp[i]);
        }

        System.out.println(answer);
        
        
    }
}
