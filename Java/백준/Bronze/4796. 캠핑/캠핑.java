import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	
	static FastScanner fs = new FastScanner();
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws Exception {
		
		List<int[]>cases = new ArrayList<>();
		
		while(true) {
			int L = fs.nextInt(); // 사용할수 있는 기간
			int P = fs.nextInt(); // 주기
			int V = fs.nextInt(); // 총 휴가일
			
			if(L==0 && P ==0 && V== 0) break;
			
			cases.add(new int[] {L,P,V});
		}
		
		int caseNum = 1;
		for (int[] c : cases) {
			int L = c[0], P = c[1], V= c[2];
			int answer = (V/P)*L + Math.min(V%P, L);
			System.out.printf("Case %d: %d\n",caseNum ++, answer );
		}
		
		                                                                                                                                                                                                                                            
		
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
