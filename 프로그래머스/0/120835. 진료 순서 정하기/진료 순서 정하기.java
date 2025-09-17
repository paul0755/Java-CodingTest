import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        // 숫자가 클수록 응급도가 높음
        // 응급도 배열안 요소끼리 비교를 해야함.
        int n = emergency.length;
        int[] answer = new int[n];

        int[] sorted = emergency.clone();
        Arrays.sort(sorted);

        // Map을 이용해 응급도 → 순위 저장
        Map<Integer, Integer> rank = new HashMap<>();
        for (int i = 0; i < n; i++) {
            rank.put(sorted[n - 1 - i], i + 1); // 큰 값부터 1등
        }

        // 원래 순서대로 순위 채우기
        for (int i = 0; i < n; i++) {
            answer[i] = rank.get(emergency[i]);
        }

        return answer;
    }
}