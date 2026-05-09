// 가격이 떨어지지 않는 기간 출력

class Solution {
    public int[] solution(int[] prices) {
        
        // 1. prices에서 금액을 하나씩 뽑기
        // 2. 뽑은 금액과 후에 존재하는 금액들을 모두 비교
        int[] arr = new int[prices.length];
        
        int idx = 0;
        for(int j=0; j < prices.length; j++){
            int time = 0;
            for(int i = idx+1; i < prices.length; i++){
                
                // 기준 가격이 다음 가격보다 작거나 같으면
                if(prices[idx] <= prices[i]){
                    time++;
                }else{
                    time++;
                    break;   
                }
                
            }
            
            arr[j] = time;
            idx++;
            
        }
        
//         for(int i=0; i<arr.length; i++){
//             System.out.println(arr[i]);
//         }        
        
        
        
        return arr;
    }
}