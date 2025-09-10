import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();

		int line = 0;    // 몇 번째 대각선인지
		int count = 0;   // 대각선까지 몇 개의 원소가 있는지 누적합

		while (count < X) {
		    line++;
		    count += line;  // 1 + 2 + ... + line
		}

		// line번째 대각선에서의 위치
		int index = X - (count - line);

		// 분수 계산
		int numerator, denominator;
		if (line % 2 == 0) { // 짝수 라인
		    numerator = index;
		    denominator = line - index + 1;
		} else { // 홀수 라인
		    numerator = line - index + 1;
		    denominator = index;
		}

		System.out.println(numerator + "/" + denominator);

	}
}
