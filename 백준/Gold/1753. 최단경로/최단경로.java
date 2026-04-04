import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int V, E;
    static int start;
    static int[] dist;

    static class Node{
        int v, cost;
        Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V + 1];
        // dist를 INF로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        start = Integer.parseInt(br.readLine());
        // 시작점 초기화
        dist[start] = 0; 

        PriorityQueue<Node> pq  = new PriorityQueue<>(
            (a,b) -> a.cost - b.cost
        );

        ArrayList<Node> graph [] = new ArrayList[V+1];

        for(int i=1; i<=V; i++){
            graph[i] =  new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));

        }
        
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(dist[cur.v] < cur.cost) continue;

            for(Node next : graph[cur.v]){
                if(dist[next.v] > cur.cost + next.cost){
                    dist[next.v] = cur.cost + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        for(int i=1; i<=V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }
        
    }
}