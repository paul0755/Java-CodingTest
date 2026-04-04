import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    
    static int[] start;
    static long[] dist;
    static int N, M, K;
    static PriorityQueue<Node> pq = new PriorityQueue<>(
        (a,b) -> Long.compare(a.cost, b.cost)
    );

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Node{
        int v; 
        long cost;
        Node(int v, long cost){
            this.v = v;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ArrayList<Node> graph[] = new ArrayList[N+1];
        for(int i=1; i<=N ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            // 방향을 뒤집어서 면접장을 기준으로 뻗게끔 진행 (단방향)
            graph[V].add(new Node(U, C));

        }

       // 면접장의 수
       start = new int[K];
       st = new StringTokenizer(br.readLine());
       for(int i=0; i<K; i++){
        start[i] = Integer.parseInt(st.nextToken());
       } 

        dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        
        // 시작점 위치는 초기화
        for(int s : start){
            dist[s] = 0;
        }

        // 모든 면접장 위치를 큐에 넣어둠
        for(int s : start){
            pq.add(new Node(s, 0));
        }
       
        // 이후에 다익스트라
        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(dist[cur.v] < cur.cost) continue;

            for(Node next: graph[cur.v]){
                if(dist[next.v] > cur.cost + next.cost){
                    dist[next.v] = cur.cost + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        int city = 0;
        long result = 0;

        for(int i=1; i<=N; i++ ){
            if(dist[i] == Long.MAX_VALUE) continue;

            if(result < dist[i]){
                result = dist[i];
                city = i;
            }
        }

        System.out.println(city);
        System.out.println(result);

    }
}
