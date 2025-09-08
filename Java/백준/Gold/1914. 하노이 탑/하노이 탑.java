import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static boolean print;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        print = (N <= 20);

        // BigInteger로 2^N - 1 계산
        BigInteger moves = BigInteger.ONE.shiftLeft(N).subtract(BigInteger.ONE);
        System.out.println(moves);

        if (print) {
            recursion(N, 1, 3);
        }
    }

    static void recursion(int n, int from, int to) {
        if (n > 1) {
            recursion(n - 1, from, 6 - from - to);
        }

        System.out.println(from + " " + to);

        if (n > 1) {
            recursion(n - 1, 6 - from - to, to);
        }
    }
}
