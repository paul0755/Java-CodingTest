import java.util.*;

// 연속적으로 나타나는 숫자 -> 하나만 남기기

public class Solution {
    public int[] solution(int []arr) {
        
        int N = arr.length;
        
        List<Integer> list = new ArrayList<>();
        
        list.add(arr[0]);
        
        for(int i=1; i<N; i++){
            // 연속되지 않는다면 add
            
            if(arr[i-1] != arr[i]) list.add(arr[i]);
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        

        return answer;
    }
}