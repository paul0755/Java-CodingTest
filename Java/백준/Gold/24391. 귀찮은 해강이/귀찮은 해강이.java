import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] nodes;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 강의수
		M = Integer.parseInt(st.nextToken()); // 연결된 건물의 수
		nodes = new int[N+1];
		int[] class_time = new int[N];
		int answer = 0;
		 
		
		for(int i=1 ; i<N+1; i++) {
			nodes[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1, n2;
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			union(n1,n2);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++ ) {
			class_time[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N-1; i++) {
			if(find(class_time[i]) != find(class_time[i+1])) answer ++;
		}
		
		System.out.println(answer);
		
		
		

	}


	private static void union(int n1, int n2) {
		int root1 = find(n1);
		int root2 = find(n2);
		if(root1 == root2) return;
		nodes[root2] = nodes[root1];
	}


	private static int find(int x) {
		if(nodes[x] == x) return x;
		return nodes[x] = find(nodes[x]);
	}
	
	

}
