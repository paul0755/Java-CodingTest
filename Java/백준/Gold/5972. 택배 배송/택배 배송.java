import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] dist;
    static List<List<int[]>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 양방향
            graph.get(a).add(new int[]{b,c});
            graph.get(b).add(new int[]{a,c});
        }

        dij(1);

        System.out.println(dist[N]);


        
    }

    private static void dij(int start) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        dist[start] = 0;
        pq.offer(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int nowNode = cur[0];
            int nowCost = cur[1];

            if(nowCost > dist[nowNode]) continue;

            for(int[] next : graph.get(nowNode)){
                int nextN = next[0];
                int nextC = nowCost + next[1];

                if(nextC < dist[nextN]){
                    dist[nextN] = nextC;
                    pq.offer(new int[]{nextN, nextC});
                }
            }
        }
    }
}
