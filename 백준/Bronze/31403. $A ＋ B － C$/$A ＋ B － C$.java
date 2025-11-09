import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static int A,B,C;
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        System.out.println((A+B)-C);
        
        String a = Integer.toString(A);
        String b = Integer.toString(B);
        String c = Integer.toString(C);
        
        int result = Integer.parseInt(a+b) - Integer.parseInt(c);

        System.out.println(result);

    }
}
