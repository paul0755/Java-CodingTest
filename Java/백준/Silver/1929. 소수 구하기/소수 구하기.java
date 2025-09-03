import java.util.Scanner;

public class Main {

    // 소수 판별 함수
    public static boolean isPrime(int num) {
        if (num < 2) return false; // 0, 1은 소수가 아님
        for (int i = 2; i * i <= num; i++) { // √num 까지만 확인
            if (num % i == 0) return false; // 나누어 떨어지면 소수 아님
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] arr1 = new int[2];
        
        for (int i = 0; i < 2; i++) {
            arr1[i] = sc.nextInt(); // 범위 입력
        }
        
        for (int i = arr1[0]; i <= arr1[1]; i++) {
        	if(isPrime(i)) {
        		System.out.println(i);
        	}
        }
  
    }
}