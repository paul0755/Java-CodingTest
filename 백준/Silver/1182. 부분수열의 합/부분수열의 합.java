import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N ,S;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] selected;
    static int[] arr;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        selected = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if(S == 0) count --;

        System.out.println(count);


    }
    private static void dfs(int idx, int sum) {
    
        if(idx == N){
            if(sum == S) count ++;
            return;
        }

        // 선택한 경우
        dfs(idx + 1, sum + arr[idx]);


        // 선택안한 경우
        dfs(idx + 1, sum);
    }
}
