import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int N, K;
    static Queue<Integer> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            q.offer(i);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        while(!q.isEmpty()){
            for(int i=0; i<K-1; i++){
                q.offer(q.poll());
            }
            answer.add(q.poll());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i=0; i<answer.size(); i++){
            sb.append(answer.get(i));
            if(i != answer.size()-1){
                sb.append(", ");
            }
        }
        sb.append(">");
        
        System.out.println(sb);
    }
}
