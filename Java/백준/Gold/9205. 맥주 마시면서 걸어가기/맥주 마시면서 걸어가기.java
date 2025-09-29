import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T, n;
    static int[][] arr; // [0] = 집, [1..n] = 편의점, [n+1] = 페스티벌

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n+2][2]; // (x,y)

            for(int i=0; i<n+2; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken()); // x
                arr[i][1] = Integer.parseInt(st.nextToken()); // y
            }

            boolean result = bfs();
            System.out.println(result ? "happy" : "sad");
        }
    }

    static boolean bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+2];

        q.offer(0); // 집에서 시작
        visited[0] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur == n+1) return true; // 페스티벌 도착

            for(int next=0; next<n+2; next++) {
                if(!visited[next] && dist(arr[cur], arr[next]) <= 1000) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        return false;
    }

    static int dist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
