import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, result=0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        String tmp = br.readLine();
        for(char c : tmp.toCharArray()){
            result += c - '0';
        }

        System.out.println(result);

        
    }
}
