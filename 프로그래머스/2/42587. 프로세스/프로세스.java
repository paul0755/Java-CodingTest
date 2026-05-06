import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        
        // 실행순서를 알아야함
        List<int[]> list = new ArrayList<>();
        
        Queue<int[]> q = new ArrayDeque<>();
        
        for(int i=0; i<priorities.length; i++){
            q.offer(new int[]{i,priorities[i]});
        }
        
        while(!q.isEmpty()){
    
            int[] cur = q.poll();
            int cp = cur[1];

            boolean hasHigher = false;

            for(int[] other : q){
                if(other[1] > cp){
                    hasHigher = true;
                    break;
                }
            }

            if(hasHigher){
                q.offer(cur); // 뒤로 보내기
            } else {
                list.add(cur); // 실행
            }
        }
        
        // cl에 해당하는 location이 실행되는 idx가 답
        
        for(int i=0; i<list.size(); i++){
            int[] c = list.get(i);
            
            int cl = c[0];
            
            if(cl == location) return i+1;
        }
      
        return -1;
    }
}