import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        
        // 1. HashMap 구현
        HashMap<String, Boolean> map = new HashMap<>();
        
        // 2. 초기화
        for(String p : phone_book){
            map.put(p,true);
        }
        
//         // 핵심 : 접두사 비교
//         // 이중 for문으로 완탐 비교를 진행하니 문제가 되는듯 -> 시간문제
//         // + 비교가 다 안 이루어짐(1번 ->2,3 / 2번 -> 3 끝)
//         for(int i=0; i<phone_book.length; i++){
//             String A = phone_book[i];
//             for(int j=i+1; j<phone_book.length; j++){
//                 String B = phone_book[j];
//                 // i번째 요소가 j번째 요소에 접두사면?
//                 if(B.indexOf(A) == 0){
//                     map.put(B, false);
//                 }
//                 // 아니면 그냥 두기
                
//             }
//         }
        
//         // 2번째 시도 : 답은 맞음. But 시간 초과 -> 100만 x 100만 = 1조
//         // 그러면 이분탐색?
//         for(int i=0; i<phone_book.length; i++){
//             String A = phone_book[i];
//             for(String p : phone_book){
//                 // 자기자신은 비교 제외
//                 if(p == A) continue;
//                 if(A.indexOf(p) == 0){
//                     map.put(A, false);
//                 }
                
//             }
//         }
        
         // 2. 접두사 검사
        for(String number : phone_book){
            
            // prefix 하나씩 생성
            for(int i = 1; i < number.length(); i++){
                String prefix = number.substring(0, i);
                
                // map에 존재하면 접두사 관계
                if(map.containsKey(prefix)){
                    return false;
                }
            }
        }
        
        
        
        
        
        boolean answer = true;
        return answer;
    }
}