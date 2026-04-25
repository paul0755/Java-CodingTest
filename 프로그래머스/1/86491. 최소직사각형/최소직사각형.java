import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int maxW = 0;
        int maxH = 0;
        
        for(int[] size : sizes){
            int w = size[0];
            int h = size[1];
            
            int big = Math.max(w, h);
            int small = Math.min(w, h);
            
            maxW = Math.max(maxW, big);
            maxH = Math.max(maxH, small);
        }
        
        return maxW * maxH;
    }
}