import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int S;
    static int[] arr;
    
    static Set<Integer> list = new HashSet<>();

    public static void main(String[] args) throws Exception, IOException {
        
        S = Integer.parseInt(br.readLine());

        arr = new int[S];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<S; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        for(int i=1; ; i++){
            if(!list.contains(i)){
                System.out.println(i);
                break;
            }
        }

    }

    private static void dfs(int idx, int sum) {
        
        if(idx == S){
            list.add(sum);
            return;
        }

        dfs(idx+1, sum + arr[idx]);

        dfs(idx+1, sum);
    }
}
