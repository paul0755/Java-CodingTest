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
		
		int n1 = fs.nextInt();
		int n2 = fs.nextInt();
		int n3 = fs.nextInt();
		
		int result = n1*n2*n3;
		int[] arr = solution(result);
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]);
		}
		String result1 = sb.toString();
		for (int i = 0; i < result1.length(); i++) {
		    System.out.println(result1.charAt(i));
		}
		
		
		
	}
	
	private static int[] solution(int num) {
	    int[] numbers = new int[10];
	    // 형변환 int -> String
	    String s = String.valueOf(num);
	    for (int i = 0; i < s.length(); i++) {
	    	char c = s.charAt(i);
	        int digit = c - '0';
	    	numbers[digit]++;
	    }
	    return numbers;
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
