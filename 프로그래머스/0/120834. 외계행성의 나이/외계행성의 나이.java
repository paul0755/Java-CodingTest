class Solution {
    public String solution(int age) {
        String temp = Integer.toString(age); // 숫자를 문자열로 변환
        char[] arr = temp.toCharArray();     // 문자열을 문자 배열로 변환
        String answer = "";

        for (char c : arr) {
            // 숫자 문자('0'~'9')를 0~9 정수로 변환 후 'a'를 더해 문자로 변환
            answer += (char)('a' + (c - '0'));
        }

        return answer;
    }
}
