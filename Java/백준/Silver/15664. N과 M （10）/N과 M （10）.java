import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static int N, M;
    static List<Integer> list = new ArrayList<>();
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb =  new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0,0);

        System.out.println(sb);

    }

    private static void dfs(int start, int depth) {
        
        if(depth == M){
            for(int n : list){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for(int i=start; i<N; i++){
            if(!visited[i]){
                if(before != arr[i]){
                    list.add(arr[i]);
                    visited[i] = true;
                    before = arr[i];
                    dfs(i+1, depth+1);
                    visited[i] = false;
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
