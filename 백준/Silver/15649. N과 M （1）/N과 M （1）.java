import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb  = new StringBuilder();

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        arr = new int[M];

        dfs(0);

        System.out.println(sb);

    }

    private static void dfs(int depth){

        if(depth == M){
            for(int n: arr){
                sb.append(n).append(' ');     
            }
            sb.append('\n');
            return;
        }

        for(int i=1; i<=N; i++){

            if(!visited[i]){
                arr[depth] = i;
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}