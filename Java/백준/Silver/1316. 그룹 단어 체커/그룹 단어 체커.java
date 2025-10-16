import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, cnt=0;
    static String word;
    static boolean[] appear;
    
    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            appear = new boolean[26];
            word = br.readLine();
            char prev = ' ';
            boolean isGroup = true;

            for(char c : word.toCharArray()){
                if(c != prev){
                    if(appear[c-'a']){
                        isGroup = false;
                        break;
                    }
                    
                }
                if(!appear[c-'a']) appear[c - 'a'] = true; // 등장시 true
                prev = c;
            }

            if(isGroup) cnt++;
            
        }
        System.out.println(cnt);   

    }
}
