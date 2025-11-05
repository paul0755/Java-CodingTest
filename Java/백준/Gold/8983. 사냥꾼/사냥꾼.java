import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int M, N, L;
    static int[] shoot;
    static List<int[]> animal = new ArrayList<>();
    static Set<int[]> hunt = new HashSet<>();
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 사대의 수
        N = Integer.parseInt(st.nextToken()); // 동물의 수
        L = Integer.parseInt(st.nextToken()); // 사정거리

        shoot = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            shoot[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(shoot);

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            animal.add(new int[]{x,y});
        }
        
        for(int x : shoot){
            for(int[] l : animal){
                if(canHunt(x, l)){
                    hunt.add(l);
                }
            }
        }

        System.out.println(hunt.size());


        

    }
    private static boolean canHunt(int x, int[] l) {
        
        int distance = Math.abs(x - l[0]) + l[1];
        if(distance <= L){
            return true;
        }else{
            return false;
        }
    }
}
