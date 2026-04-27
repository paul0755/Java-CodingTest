import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : nums){
            set.add(num);
        }
        
        int maxPick = nums.length / 2;
        
        return Math.min(set.size(), maxPick);
    }
}

// set으로 종류수를 줄이고 
// 최대로 뽑을 수 있는 수를 구해서
// 둘중에 최소값을 구하면 가장 많은 종류의 수가 나옴.....