import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	static FastScanner fs = new FastScanner();
	
	// 맨 마지막 정사각형 수를 입력하면, 둘레의 길이를 계산해주는 로직 구현
	// 제한시간 1초를 무시하지말것 
	// 제약조건을 잘볼것 1<=N<=10^9 (10,000,000,000) = 10억 2초를 초과함
	
	public static void main(String args[]) throws Exception {
		
		Long N = fs.nextLong(); 
		Long len = solution(N);
		System.out.println(len);
		
	}
	
	private static Long solution(Long N) {
			return N *= 4;
		
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
		
		Long nextLong() throws Exception{
			return Long.parseLong(next());
		}
		
	}
}
