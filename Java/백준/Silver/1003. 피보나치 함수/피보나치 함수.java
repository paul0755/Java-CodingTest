import java.util.Scanner;

public class Main {
	static long[] arr = new long[41];
	
	public static void main(String args[]) {
		
		Scanner sc = new  Scanner(System.in);
		StringBuilder sb = new StringBuilder();
	

        int T = sc.nextInt(); // 테스트 케이스 개수

        // DP 배열
        int[][] dp = new int[41][2];
        dp[0][0] = 1; dp[0][1] = 0; // fibo(0) -> 0 출력 1번
        dp[1][0] = 0; dp[1][1] = 1; // fibo(1) -> 1 출력 1번

        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }

        System.out.print(sb);
		}
	
}
