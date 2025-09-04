import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	
	static FastScanner fs = new FastScanner();
	
	public static void main(String args[]) throws Exception {
		
		int N = fs.nextInt(); 
		int K = fs.nextInt();
		int result = solution(N,K);
		System.out.println(result);
		
	}
	
	private static int solution(int N, int K) {
			 
			// 2번 성질
			if(N == K || K == 0) {
				return 1;
			}
		    // 1번 성질
			return solution(N - 1, K - 1) + solution(N - 1, K);
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
