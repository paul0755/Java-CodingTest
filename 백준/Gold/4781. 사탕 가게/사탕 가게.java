import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static double tmp_m;
    static StringBuilder sb  = new StringBuilder();
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            tmp_m = Double.parseDouble(st.nextToken());
            tmp_m *= 100; tmp_m += 0.5;
            int m = (int)tmp_m;
            
            if(n == 0 && m == 0) break;
            
            int dp[] = new int[m + 1];

            for(int i=0; i<n; i++){

                st = new StringTokenizer(br.readLine());
                int cal = Integer.parseInt(st.nextToken());
                double tmp = Double.parseDouble(st.nextToken());
                // 칼로리랑 돈도 따로 저장해 둘 필요없음.
                tmp *= 100; tmp += 0.5;
                int num = (int) tmp;

                if(num > m) continue;

                for(int j = num ; j < m+1 ; ++j){
                    dp[j] = Math.max(dp[j], dp[j-num] + cal);        
                }

            }

            sb.append(dp[m]).append("\n");
            
        }

        System.out.println(sb);

    }
}
