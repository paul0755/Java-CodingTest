import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {

        // strings 배열 자체를 정렬
        Arrays.sort(strings, (a, b) -> {
            // n번째 문자가 다르면 그 문자 기준으로 정렬
            if (a.charAt(n) != b.charAt(n)) {
                return a.charAt(n) - b.charAt(n);
            }

            // n번째 문자가 같으면 사전순 정렬
            return a.compareTo(b);
        });

        return strings;
    }
}