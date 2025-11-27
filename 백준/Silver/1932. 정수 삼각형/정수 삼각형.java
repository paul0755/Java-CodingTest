import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] tree;
    static int[][] dp;
    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        tree = new int[N][N];
        dp = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++){
                tree[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(N == 1){
            System.out.println(tree[0][0]);
            return;
        }

        dp[0][0] = tree[0][0];

        for(int i=1; i<N; i++){
            for(int j=0; j<=i; j++){

                // 맨 왼쪽
                if(j==0){
                    dp[i][j] = dp[i-1][j] + tree[i][j];
                }
                // 맨 오른쪽
                else if(j==i){
                    dp[i][j] = dp[i-1][j-1] + tree[i][j];
                }
                
                // 중간
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + tree[i][j];
                }

            }
        }

        int answer = 0;
        for(int i=0; i<N; i++){
            answer = Math.max(answer, dp[N-1][i]);
        }

        System.out.println(answer);
        

    }
}
