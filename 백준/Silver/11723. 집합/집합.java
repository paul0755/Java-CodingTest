import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    
    static int M;
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        M = Integer.parseInt(br.readLine());


        for(int i=0; i<M; i++){

            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("add")){
                int x = Integer.parseInt(st.nextToken());
                add(x);
                }
            else if(command.equals("remove")){
                int x = Integer.parseInt(st.nextToken());
                remove(x);
            }
            else if(command.equals("check")){
                int x = Integer.parseInt(st.nextToken());
                check(x);
            }
            else if(command.equals("toggle")){
                int x = Integer.parseInt(st.nextToken());
                toggle(x);

            }
            else if(command.equals("all")){
                all();
            }
            else if(command.equals("empty")){
                empty();
            }
                
        }

        System.out.println(sb);
                
                        
                
    }
                    private static void add(int x) {
                        set.add(x);
                    }
                    private static void remove(int x){
                        set.remove(x);
                    }
                    private static void toggle(int x){
                        if(set.contains(x)){
                            set.remove(x);
                        }else{
                            set.add(x);
                        }
                    }
                    private static void check(int x){
                        if(set.contains(x)){
                            sb.append(1).append("\n");
                        }else{
                            sb.append(0).append("\n");
                        }
                    }
                    private static void all(){
                        
                        Set<Integer> temp = new HashSet<>();
                        for(int i=1; i<=20; i++){
                            set.add(i);
                        }

                        set.addAll(temp);
                    }
                    private static void empty(){
                        set.clear();
                    }

}
