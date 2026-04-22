import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        
        List<Integer> answer = new ArrayList<>();
        
        for(int[] c : commands){
            
            List<Integer> list = new ArrayList<>();
            
            int start = c[0];
            int end = c[1];
            int k = c[2];
            
            for(int i = start-1; i< end ; i++){
                list.add(array[i]);
            }
            
            Collections.sort(list);
            
            answer.add(list.get(k-1));
        }
        
        
        return answer;
    }
}