class Solution {
    public String solution(String s) {
        int len = s.length();

        // 홀수 길이: 가운데 1글자
        // 짝수 길이: 가운데 2글자
        if (len % 2 == 1) {
            return s.substring(len / 2, len / 2 + 1);
        } else {
            return s.substring(len / 2 - 1, len / 2 + 1);
        }
    }
}