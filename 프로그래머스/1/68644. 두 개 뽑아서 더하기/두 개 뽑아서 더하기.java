import java.util.*;

class Solution {
    
    static int[] arr = new int[2];
    static Set<Integer> set;
    
    public int[] solution(int[] numbers) {
        
        set = new HashSet<>();
        
        dfs(0,0, numbers);
        
        int [] answer = new int[set.size()];
        int idx = 0;
        
        for(int num : set){
            answer[idx++] = num;
        }
        Arrays.sort(answer);
        return answer;
    }
    
    private static void dfs(int depth, int start, int[] numbers){
        
        if(depth == 2){
            set.add(arr[0]+arr[1]);
            return;
        }
        
        for(int i = start; i< numbers.length; i++){
        arr[depth] = numbers[i];
        dfs(depth+1, i+1, numbers);
        }
        
        
    }
}