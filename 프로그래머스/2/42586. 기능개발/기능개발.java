import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new ArrayDeque<>();
        
        // 1. 각 작업 완료까지 걸리는 날짜 계산해서 큐에 넣기
        for(int i = 0; i < progresses.length; i++){
            int day = (int)Math.ceil((100 - progresses[i]) / (double)speeds[i]);
            q.offer(day);
        }
        
        List<Integer> result = new ArrayList<>();
        
        // 2. 배포 묶기
        while(!q.isEmpty()){
            int current = q.poll(); // 기준 작업
            int count = 1;
            
            // 뒤 작업들 확인
            while(!q.isEmpty() && q.peek() <= current){
                q.poll();
                count++;
            }
            
            result.add(count);
        }
        
        // 3. 배열 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}