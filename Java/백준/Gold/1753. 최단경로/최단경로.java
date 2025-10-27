import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

    static int V, E;
    static int start;
    static List<List<int[]>> graph = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<=V; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            addEdge(u,v,w);
        }

        dijkstra(start);

        for(int i=1; i<=V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{

                System.out.println(dist[i]);
            }
        }
    }

    private static void dijkstra(int i) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // 시작점 추가 {비용, 노드}
        pq.add(new int[]{0, start});
        dist[start] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int nowCost = cur[0];
            int nowNode = cur[1];

            if(dist[nowNode] < nowCost) continue;

            for(int[] next : graph.get(nowNode)){
                int nextNode = next[0];
                int nextCost = nowCost + next[1];

                if(nextCost < dist[nextNode]){
                    dist[nextNode] = nextCost;
                    pq.add(new int[]{nextCost, nextNode});
                }
            }

        }
    }

    private static void addEdge(int from, int to, int cost) {
        graph.get(from).add(new int[] {to, cost});
    }
}
