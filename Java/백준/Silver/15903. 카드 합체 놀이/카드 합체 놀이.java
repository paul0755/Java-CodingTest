import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            pq.add(Long.parseLong(st.nextToken()));
        }

        for(int i=0; i<M; i++){
            Long card1 = pq.poll();
            Long card2 = pq.poll();

            long mix = card1 + card2;

            pq.add(mix);
            pq.add(mix);
        }

        long answer = 0;
        while(!pq.isEmpty()){
            answer += pq.poll();
        }

        System.out.println(answer);

    }
}
