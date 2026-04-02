import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] visited;
    static ArrayList<Integer> adj[] ;
        public static void main(String[] args) throws Exception, IOException {
    
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());     
         
        visited = new int[N+1];
        adj = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        dfs(1);

        int result = 0;
        for(int i=2;i<=N; i++){
            if(visited[i] == 1){
                result ++;
            }                    
        }

        System.out.println(result);
    }

    private static void dfs(int now){
        visited[now] = 1;

        for(int next : adj[now]){
            if(visited[next] == 0 ){
                dfs(next);
            }
        }
    }
}
