import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] one = {1,2,3,4,5}; 
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        int one_count = 0;
        int two_count = 0;
        int three_count = 0;
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == one[i % one.length]) one_count++;
            if(answers[i] == two[i % two.length]) two_count++;
            if(answers[i] == three[i % three.length]) three_count++;
        }
        
        // max를 구하고 모두 비교를 진행
        int max = Math.max(one_count, Math.max(two_count, three_count));
        
        List<Integer> result = new ArrayList<>();
        
        if(one_count == max) result.add(1);
        if(two_count == max) result.add(2);
        if(three_count == max) result.add(3);
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}