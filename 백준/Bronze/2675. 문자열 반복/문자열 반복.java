import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static int T, R;
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        
        for(int i=0; i<T ; i++){
            List<Character> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            String tmp = st.nextToken();

            for(char c : tmp.toCharArray()){
                for(int j=0; j<R; j++){
                    list.add(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            for(char c: list){
                sb.append(c);
            }
            // sb.append("\n");

            System.out.println(sb);
        }
        

    }
}
