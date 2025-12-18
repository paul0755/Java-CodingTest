import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<int[]> customer;
    static PriorityQueue<Counter> counters;
    static List<Exit> exitList = new ArrayList<>();
    static int N, K;

    static class Counter {
        int idx;      // 계산대 번호
        int endTime;  // 이 계산대가 비는 시점

        Counter(int idx, int endTime){
            this.idx = idx;
            this.endTime = endTime;
        }
    }

    static class Exit{
        int endTime;
        int counterIdx;
        int customerId;

        Exit(int endTime, int counterIdx, int customerId){
            this.endTime = endTime;
            this.counterIdx = counterIdx;
            this.customerId = customerId;
        }
    }


    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        customer = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int item = Integer.parseInt(st.nextToken());

            customer.offer(new int[]{id, item});
        }

        counters = new PriorityQueue<>((a,b) -> {
            // 더 빨리 비는 계산대
            if(a.endTime != b.endTime) return a.endTime - b.endTime;
            return a.idx - b.idx; // 같으면 번호 작은 계산대
        });

        // 카운터 초기화
        for(int i=1; i<=K; i++){
            counters.offer(new Counter(i, 0));
        }

        // 고객 한명씩 배정
        while(!customer.isEmpty()){
            int[] cur = customer.poll();

            int id = cur[0];
            int item =cur[1];
            
            // 가장 빨리 비는 계산대 선택 -> 우선순위 큐 자료구조가 해줌
            Counter counter = counters.poll();

            int startTime = counter.endTime;
            int endTime = startTime + item;

            counter.endTime = endTime;

            counters.add(counter);

            
            exitList.add(new Exit(endTime, counter.idx, id));
        }
        
        Collections.sort(exitList, (a, b) -> {
            if (a.endTime != b.endTime)
                return a.endTime - b.endTime;      // 먼저 끝난 순
            return b.counterIdx - a.counterIdx;    // 같으면 계산대 번호 큰 순
        });

        long result = 0;
        for(int i=0; i<exitList.size(); i++){
            result += (long)(i+1) * exitList.get(i).customerId;
        }

        System.out.println(result);




    }
}
