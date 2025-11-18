import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] level;
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        level = new int[N];

        for(int i=0; i<N; i++){
            level[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for(int i=N-1; i>0; i--){
            while(level[i] <= level[i-1]){
                level[i-1] --;
                cnt ++;
            }
        }

        
        // for(int i=0; i<N; i++){
        //     System.out.print(level[i] + " ");
        // }
        
        //System.out.println();
        System.out.println(cnt);


    }
}
