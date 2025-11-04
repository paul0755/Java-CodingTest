import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int K, N, count;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[K];

        for(int i=0 ; i<K ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);


        long lo = 1;
        long hi = arr[arr.length-1];
        long result = 0;
        //int i=0;

        while(lo<=hi){
            count = 0;
            long mid = (lo+hi)/2;

            for(int len : arr){
                count += len / mid;
            }

            if(count >= N){
                result = mid;
                //System.out.println(result);
                lo = mid +1;
            }else{
                //i++;
                //System.out.println(i);
                //System.out.println("mid:" + mid);
                hi = mid -1;
            }
        }


        System.out.println(result);
    }
}
