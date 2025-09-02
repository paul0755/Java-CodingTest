class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        for (char c : my_string.toCharArray()) { // 문자열을 char 배열로 변환
            answer += String.valueOf(c).repeat(n); // char -> String 변환 후 repeat
        }
        return answer;
    }
}
