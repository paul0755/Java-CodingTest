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

    static int N, E, v1, v2;
    static int[] dist1;
    static int[] distA;
    static int[] distB;
    static List<List<int[]>> graph = new ArrayList<>();
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        dist1 = new int[N+1];
        distA = new int[N+1];
        distB = new int[N+1];
        Arrays.fill(dist1, INF);
        Arrays.fill(distA, INF);
        Arrays.fill(distB, INF);

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[]{b,c});
            graph.get(b).add(new int[]{a,c});
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());


        dist1 = dij(1, dist1);
        distA = dij(v1, distA);
        distB = dij(v2, distB);

        //printDist(dist1);
        //printDist(distA);
        //printDist(distB);

        long path1 = (long)dist1[v1] + distA[v2] + distB[N];
        long path2 = (long)dist1[v2] + distB[v1] + distA[N];

        //System.out.println("path1:" + path1 + " " + "path2:" + path2);

        if (dist1[v1] == INF || distA[v2] == INF || distB[N] == INF) path1 = Long.MAX_VALUE;
        if (dist1[v2] == INF || distB[v1] == INF || distA[N] == INF) path2 = Long.MAX_VALUE;
        
        long answer = Math.min(path1, path2);

        System.out.println(answer == Long.MAX_VALUE ? -1 : answer);

    }

    private static void printDist(int[] dist) {
        for(int i=0; i<=N; i++){
            System.out.print(dist[i] + " ");
        }   
        System.out.println();
    }

    private static int[] dij(int start, int[] dist) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        dist[start] = 0;
        pq.offer(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int nowNode = cur[0];
            int nowCost = cur[1];

            if(nowCost > dist[nowNode]) continue;

            for(int[] next : graph.get(nowNode)){

                int nextNode = next[0];
                int nextCost = nowCost + next[1];

                if(nextCost < dist[nextNode]){
                    dist[nextNode] = nextCost;
                    pq.offer(new int[]{nextNode, nextCost});
                }
            }

        }

        return dist;
    }
}
