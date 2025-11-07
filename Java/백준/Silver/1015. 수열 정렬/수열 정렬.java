import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] A, sorted;

    public static void main(String[] args) throws Exception, IOException {
    
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] idxArr = new Integer[N];
        for(int i=0 ; i<N; i++) idxArr[i] = i;

        Arrays.sort(idxArr, (i,j) -> A[i] - A[j]);

        
        int[] P = new int[N];
        for(int i=0; i<N; i++){
            P[idxArr[i]] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int num: P){
            sb.append(num).append(" ");
        }


        System.out.println(sb);
    }
}
