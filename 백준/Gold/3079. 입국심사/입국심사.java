import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] times;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        times = new int[N];

        for(int i=0; i<N; i++){
            times[i] = Integer.parseInt(br.readLine());
        }

        int maxTime = 0;
        for(int i=0; i<N; i++){
            if(maxTime < times[i]){
                maxTime = times[i];
            }
        }

        long left = 1;
        long right = (long) maxTime * M;
        long answer = right;

        while(left <= right){
            long  mid = (left + right) / 2;

            long total=0;
            for(int time : times){
                total += mid / time;
                if(total > M) break;
            }

            if(total >= M){
                answer = mid;
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(answer);


    }
}