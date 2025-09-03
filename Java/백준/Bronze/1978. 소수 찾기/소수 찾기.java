import java.util.Scanner;

public class Main {
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        int prime_count = 0;
        for (int j = 0; j < arr1.length; j++) {
            if (isPrime(arr1[j])) {
                prime_count++;
            }
        }

        System.out.println(prime_count);
    }
}
