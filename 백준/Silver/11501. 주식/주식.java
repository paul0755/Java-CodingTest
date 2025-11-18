import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int T, N;
    static int[] price;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            price = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                price[j] = Integer.parseInt(st.nextToken());
            }

            int maxPrice = 0;
            long profit = 0;

            for(int j=N-1; j>=0; j--){

                if(price[j] > maxPrice){
                    maxPrice = price[j]; // 최고가 갱신
                }else{
                    profit += (maxPrice - price[j]);
                }
            }

            System.out.println(profit);

        }


    }
}
