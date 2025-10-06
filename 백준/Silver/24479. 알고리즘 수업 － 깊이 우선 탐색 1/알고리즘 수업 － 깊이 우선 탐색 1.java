import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R, cnt=0;
    static ArrayList<Integer> arr[];
    static int[] visited;

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        visited = new int[N+1];
        
        for(int i=1; i<N+1; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<M ;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arr[i]); // 인접 리스트 정렬
        }

        dfs(R);

        for(int i = 1; i<N+1 ; i++){
            System.out.println(visited[i]);
        }

        
            }
        
            private static void dfs(int x) {
                cnt++;
                visited[x] = cnt;
                for(int v: arr[x]){
                    if(visited[v] >= 1) continue;

                    dfs(v);
                }

                
            }
}