import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	static FastScanner fs = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	
	// 제한시간 1초
	// 입력값: 문자열 < 100, 알파벳 소문자로만 이루어져 있다.
	// 출력 : 문자에 a~z가 몇개 포함되는지 공백을 통해 분류해서 출력
	
	public static void main(String args[]) throws Exception {
		
		String str = fs.next();
		int[] arr = solution(str);
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb.toString());
		
		
		
		
	}
	
	private static int[] solution(String s) {
	    int[] alpha = new int[26];
	    for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        alpha[c - 'a']++;  // 핵심 포인트
	    }
	    return alpha;
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
