import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] point;
    static int[] dp;
    // dp[i] = i번째 계단까지 왔을 때 얻을 수 있는 최대 점수
    
    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        point = new int[N+1];
        dp = new int[N+1];

        for(int i=1; i<=N; i++){
            point[i] = Integer.parseInt(br.readLine());
        }

        // i 번째 계단을 밝으려면 두 가지 경우뿐

        // 1) i-2 -> i
        // dp[i] = dp[i-2] + point[i]

        // 2) i-3 -> i-1 -> i
        // dp[i] = dp[i-3] + point[i-1] + point[i]

        if(N == 1){
            System.out.println(point[1]);
            return;
        }

        dp[1] = point[1];
        dp[2] = point[1] + point[2];
        

        for(int i=3; i<=N; i++){
            dp[i] = Math.max(dp[i-2] + point[i], dp[i-3] + point[i-1] + point[i]);
        }

        System.out.println(dp[N]);


    }
}
