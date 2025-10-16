import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int T, L;
    static long[] dp;
    static final int MOD = 1_000_000_007;
    public static void main(String args[]) throws Exception, IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());

        dp = new long[2501]; // L/2 = 2500이기에 2501크기.
        dp[0] = 1;
        for(int i=1 ; i<= 2500; i++){ // 괄호쌍 1~2500까지
            for(int j=0; j<i ; j++){ // (A)의 쌍 개수 j
                dp[i] = (dp[i]+dp[j] * dp[i-1-j]) % MOD;
            }
        }

        for(int i=0; i<T; i++){
            L = Integer.parseInt(br.readLine());
            galho(L);
        }
        
    }
    private static void galho(int l) {

        if(l%2 == 1){
            System.out.println(0);
        }else{
            System.out.println(dp[L/2]);
        }
    }
    
}
