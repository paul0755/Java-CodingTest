import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int a,b;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        String line ;

        while((line = br.readLine()) != null){
            
            st = new StringTokenizer(line);
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            int sum = a+b;
            System.out.println(sum);
        }

    }
}