import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int t = 0; t < N; t++) {
            String input = sc.next();
            
            LinkedList<Character> pw = new LinkedList<>();
            ListIterator<Character> cursor = pw.listIterator(); 
            // 처음에는 빈 리스트, 커서는 맨 앞을 가리킴

            for (char c : input.toCharArray()) {
                switch (c) {
                    case '<': // 커서 왼쪽 이동
                        if (cursor.hasPrevious()) cursor.previous();
                        break;
                    case '>': // 커서 오른쪽 이동
                        if (cursor.hasNext()) cursor.next();
                        break;
                    case '-': // 백스페이스
                        if (cursor.hasPrevious()) {
                            cursor.previous();
                            cursor.remove();
                        }
                        break;
                    default: // 문자 입력
                        cursor.add(c);
                }
            }

            // 최종 비밀번호 출력
            StringBuilder sb = new StringBuilder();
            for (char c : pw) sb.append(c);
            System.out.println(sb.toString());
        }
	}

}

// 백스페이스 누를때, 커서앞의 글자가있다면 글자 삭제
// 