import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;  // 666이 들어간 숫자 개수 카운트
        int num = 665;  // 시작점을 665로 두면, 바로 666부터 검사 가능

        while (true) {
            num++; // 숫자를 하나씩 증가시킴
            //System.out.println(num);
            if (String.valueOf(num).contains("666")) { // "666"이 포함되어 있다면
                count++; // 카운트 증가
            }

            if (count == n) { // n번째에 도달했으면
                System.out.println(num);
                break;
            }
        }
    }
}
