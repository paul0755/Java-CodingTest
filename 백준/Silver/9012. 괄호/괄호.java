import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            String s = br.readLine();
            int cnt = 0;
            boolean isValid = true;

            for(char c : s.toCharArray()){
                if(c == '(') cnt++;
                else cnt--;

                if(cnt < 0){  // 닫는괄호가 더 많아짐 → NO
                    isValid = false;
                    break;
                }
            }

            if(cnt != 0) isValid = false;

            System.out.println(isValid ? "YES" : "NO");
        }
    }
}
