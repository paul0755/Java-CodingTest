import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        bfs(N);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = 0; // 시작 지점 거리 = 0

        while (!q.isEmpty()) {
            int x = q.poll();

            // 도착하면 즉시 종료
            if (x == K) {
                System.out.println(visited[x]);
                return;
            }

            int[] moves = {x - 1, x + 1, x * 2};
            for (int nx : moves) {
                if (nx < 0 || nx >= 100001) continue;

                if (visited[nx] == 0 && nx != start) {
                    visited[nx] = visited[x] + 1;
                    q.offer(nx);
                }
            }
        }
    }
}
