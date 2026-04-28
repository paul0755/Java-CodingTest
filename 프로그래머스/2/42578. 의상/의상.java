// /* 서로 다른 옷의 조합수 */
// class Solution {
    
//     static boolean[] selected;
//     static int answer = 0;
    
//     public int solution(String[][] clothes) {
        
//         // 부분집합 
//         // but, value가 같은것은 선택 안됨
//         int N = clothes.length;
//         selected = new boolean[N];
        
//         dfs(0, clothes);
        
         
        
//         return answer-1;
//     }
    
//     private static void dfs(int idx, String[][] clothes){
        
//         int N = clothes.length;
        
//         if(idx == N){
//             // 같은 종류가 있으면 그 조합은 안됨
//             if(isPossible(N, clothes)){
//                 answer++;
//             }
//             return;
//         }
        
//         // 선택
//         selected[idx] = true;
//         dfs(idx+1, clothes);
        
//         // 선택 안함
//         selected[idx] = false;
//         dfs(idx+1, clothes);
//     }
    
//     private static boolean isPossible(int N, String[][] clothes){
        
//         for(int i=0; i<N; i++){
//             for(int j=i+1; j<N; j++){
//                 if(selected[i] == true && selected[j] ==true && clothes[i][1].equals(clothes[j][1]) == true) return false;
//             }
//         }
        
//         return true;
        
        
//     }
// }


import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // 종류별 개수 세기
        for(String[] c : clothes){
            String type = c[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        
        // 경우의 수 계산
        for(int count : map.values()){
            answer *= (count + 1);
        }
        
        return answer - 1;
    }
}