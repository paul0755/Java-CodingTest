import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	
	static FastScanner fs = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	

	public static void main(String args[]) throws Exception {
		
		int N = fs.nextInt(); // 회의의 수
		int[][] conf = new int[N][2];
		for(int i=0; i < N; i++ ) { 
			// 각 회의 시작시간과 끝나는 시간
			int start_time = fs.nextInt();
			int end_time = fs.nextInt();
			conf[i][0] = start_time;
			conf[i][1] = end_time;
		}
		
		// 정렬을 진행 
		// 끝나는 시간끼리 비교해서 정렬
		Arrays.sort(conf, (a,b)->{ 
			if(a[1]==b[1]) return Integer.compare(a[0], b[0]);
			return Integer.compare(a[1], b[1]);
					});
		
		// 최대한 많은 회의를 선택해야함.
		int count = 0;
		int lastEnd = 0;
		
		for(int i=0; i<N; i++) {
			if(conf[i][0]>= lastEnd) {
				count ++;
				lastEnd = conf[i][1];
			}
		}
		System.out.println(count);
		
		
		
		
		
		
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
