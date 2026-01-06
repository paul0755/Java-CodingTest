import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    static List<Integer> adj[];
    static int[] visited;
    static boolean isPossible = false;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N];
        visited = new int[N];

        for(int i=0; i<N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        for(int i=0; i<N; i++){
            if(isPossible) break;
            dfs(i,0);
        }

        System.out.println(isPossible? 1 : 0);
        
    }
    private static void dfs(int i, int depth) {
        
        if(isPossible) return; // 이미 찾았으면 끝!

        if(depth >= 4){
            isPossible = true;
            return;
        }
        visited[i] = 1;
        for(int next : adj[i]){
            if(visited[next] == 0){
                dfs(next, depth+1);
            }
        }
        visited[i] = 0; // 원복
        
    }
}
