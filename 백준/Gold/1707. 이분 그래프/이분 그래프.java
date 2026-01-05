import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> adj[];
    static int[] visited;
    static int K, V, E;
    static boolean isPossible;
    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        for(int i=0; i<K; i++){

            isPossible = true;
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            adj = new ArrayList[V+1];
            visited = new int[V+1];

            for(int j=1; j<=V; j++){
                adj[j] = new ArrayList<>();
                visited[j] = -1;
            }

            for(int j=0; j<E; j++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                adj[u].add(v);
                adj[v].add(u);
            }

            for(int j=1; j<=V; j++){
                if(visited[j] == -1){
                    visited[j] = 0;
                    dfs(j);
                }
            }

            System.out.println(isPossible ? "YES" : "NO");
        }

    }
    private static void dfs(int i) {
        for(int next : adj[i]){

            // 방문 안했으면 다른 색으로 칠하기
            if(visited[next] == -1){
                visited[next] = 1 - visited[i];
                dfs(next);
            }

            // 색이 같으면 이분 그래프 x
            else if(visited[next] == visited[i]){
                isPossible = false;
                return;
            }
        }
    }
}