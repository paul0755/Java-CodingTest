import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();

        // 다리를 0으로 초기화
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        int time = 0;
        int currentWeight = 0;
        int idx = 0;

        while (idx < truck_weights.length) {
            time++;

            // 다리 맨 앞 트럭 이동
            currentWeight -= bridge.poll();

            // 다음 트럭 진입 가능 여부
            if (currentWeight + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                currentWeight += truck_weights[idx];
                idx++;
            } else {
                bridge.offer(0);
            }
        }

        // 마지막 트럭이 다리를 빠져나가는 시간
        return time + bridge_length;
    }
}