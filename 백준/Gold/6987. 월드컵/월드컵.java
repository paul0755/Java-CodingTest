import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean possible;
 
    static class Team{
        
        int win;
        int draw;
        int lose;

        Team(int win, int draw, int lose){
            this.win = win;
            this.draw = draw;
            this.lose = lose;
        }
    }

    static List<Team> ls ;
    static List<int[]> matches;

    public static void main(String[] args) throws Exception {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int a=0; a<4; a++){
            st = new StringTokenizer(br.readLine());
            ls = new ArrayList<>();
            possible = false;
            matches = new ArrayList<>();
            // 각팀의 승,패 저장
            for(int i=0; i<6; i++){
                int win = Integer.parseInt(st.nextToken());
                int draw = Integer.parseInt(st.nextToken());
                int lose = Integer.parseInt(st.nextToken());
                ls.add(new Team(win, draw, lose));            
            }
            // 경기 목록 구하기
            for(int i=0; i<6; i++){
                for(int j=i+1; j<6; j++){
                    matches.add(new int[]{i,j});
                }
            }

            boolean valid = true;
            // 사전 검증 
            for(Team t : ls){
                if(t.win + t.draw + t.lose != 5){
                    valid =false;
                    break;
                }
            }
            if(!valid){
                System.out.println(0);
                continue;
            }
    
            dfs(0);
            
            if(possible){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }


    }

    private static void dfs(int idx) {
        if(possible) return;
        
        if(idx == 15){
            for(Team x : ls){
                if(x.win != 0 || x.draw != 0 || x.lose !=0) return;
            }
            possible = true;
            return;
        }

        int [] match = matches.get(idx);
        int a = match[0];
        int b = match[1];


        // A승, B패
        if(ls.get(a).win >0 && ls.get(b).lose>0){
            ls.get(a).win --;
            ls.get(b).lose --;
            dfs(idx + 1);
            ls.get(a).win ++;
            ls.get(b).lose ++;
        }
        
        // 무승부
        if(ls.get(a).draw >0 && ls.get(b).draw>0){
            ls.get(a).draw --;
            ls.get(b).draw --;
            dfs(idx + 1);
            ls.get(a).draw ++;
            ls.get(b).draw ++;
        }

        // A패 B승
        if(ls.get(a).lose >0 && ls.get(b).win>0){
            ls.get(a).lose --;
            ls.get(b).win --;
            dfs(idx + 1);
            ls.get(a).lose ++;
            ls.get(b).win ++;
        }
        
    }
}
