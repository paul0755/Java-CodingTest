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
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // i번째로 끝나는 부분수열의 최대합
        // 최솟값은 각 구간에서 하나만 택한
        // 즉, 자기자신을 초기값으로 가짐
        for(int i=0; i<N; i++){
            dp[i] = arr[i];
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){

                if(arr[j] < arr[i]){

                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);

                }
            }
        }

        int answer = 0;
        for(int i=0; i<N; i++){
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);


    }

}
