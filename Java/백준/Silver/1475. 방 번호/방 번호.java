import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	
	static FastScanner fs = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	
	
	// 입력 : 방번호
	// 출력 : 필요한 세트의 개수의 최솟값을 출력
	// * 6과 9은 서로 대체가능

	public static void main(String args[]) throws Exception {
		
		int N = fs.nextInt(); // 방번호
		int[] count = new int[10];
		String num = String.valueOf(N);
		
		for(char c: num.toCharArray()) {
			int digit = c -'0';
			count[digit]++;
		}
		
		count[6] = (count[6]+count[9]+1) /2;
		count[9] = 0;
		
		int result = 0;
		for(int i=0 ; i<10; i++) {
			result = Math.max(result, count[i]);
		}
		
		System.out.println(result);
		
		
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
