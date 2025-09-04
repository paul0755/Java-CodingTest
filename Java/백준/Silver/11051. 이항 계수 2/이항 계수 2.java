import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	
	static FastScanner fs = new FastScanner();
	
	public static void main(String args[]) throws Exception {
		
		int N = fs.nextInt(); 
		int K = fs.nextInt();
		int[][] dp = new int[N + 1][K + 1];
		
		int result = solution(dp, N,K);
		System.out.println(result);
		
	}
	
	private static int solution(int[][] dp, int N, int K) {
			
			// 이미 풀었던 sub문제일 경우 값을 재활용
			if(dp[N][K] > 0) {
				return dp[N][K];
			}
			// 2번 성질
			if(N == K || K == 0) {
				 return dp[N][K] = 1;
			}
		    // 1번 성질
			return dp[N][K] = (solution(dp,N - 1, K - 1) + solution(dp,N - 1, K)) % 10007;
		}
	
	
	
	static class FastScanner{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		String next() throws Exception{
			while(st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}
		
	}
}
