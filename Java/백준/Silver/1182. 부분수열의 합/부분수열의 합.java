import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static int N, S, cnt=0;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        System.out.println(cnt);
    }
    private static void dfs(int start, int depth) {
        
        if(!list.isEmpty() && check()){
            // 공집합은 세지않게 해야함.
            cnt ++;
            //return;
        }

        for(int i = start; i<N; i++){
            if(!visited[i]){
                list.add(arr[i]);
                //System.out.println("before:"+list);
                visited[i] = true;
                dfs(i+1,depth+1);
                visited[i] = false;
                list.remove(list.size()-1);
                //System.out.println("after:"+list);
            }

        }
    }
    private static boolean check() {
        
        int result = 0;
        for(int n : list){
            result += n;
        }
        // 중간합 비교가 아닌 전체합 비교로 변경
        if(result == S) return true;
        return false;
    }
}
