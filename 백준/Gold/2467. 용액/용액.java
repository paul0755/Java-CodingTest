import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N-1;
        long bestsum = Long.MAX_VALUE;
        int ans1 = 0, ans2 =0;

        while(left < right){

           //System.out.println("left :" + left + " " + "right :" + right);
            long sum = arr[left] + arr[right];

            if(Math.abs(sum) < bestsum){

                bestsum = Math.abs(sum);
                //System.out.println("best:" + bestsum);
                ans1 = arr[left];
                ans2 = arr[right];
            }

            if(sum > 0) right --;
            else left ++;

        }

        if (ans1 > ans2)
            System.out.println(ans2 + " " + ans1);
        else
            System.out.println(ans1 + " " + ans2);



    }
}
