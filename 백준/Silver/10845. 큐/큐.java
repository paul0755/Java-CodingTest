import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){

            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();

            if(cmd.equals("push")){
                int x = Integer.parseInt(st.nextToken());

                list.add(x);
            }

            if(cmd.equals("pop")){
                if(list.isEmpty()){
                    System.out.println(-1);
                }
                else{
                    System.out.println(list.get(0));
                    list.remove(0);
                }
                
            }

            if(cmd.equals("size")){
                System.out.println(list.size());
            }

            if(cmd.equals("empty")){
                if(list.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }

            if(cmd.equals("front")){
                if(list.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(list.get(0));
                }
            }

            if(cmd.equals("back")){
                if(list.isEmpty()){
                    System.out.println(-1);
                }
                else{
                    System.out.println(list.get(list.size()-1));
                }
            }
            
            

        }


    }
}
