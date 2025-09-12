import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	
	static int N, M;
	static int[] nodes;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nodes = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			nodes[i] = i;
		}// for
		// System.out.println(Arrays.toString(nodes)); // 배열 입력 확인
		
		int cmd, n1, n2;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			cmd = Integer.parseInt(st.nextToken());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			
			switch(cmd) {
			case 0:
				union(n1, n2);
				break;
			case 1:
				sb.append(find(n1) == find(n2) ? "YES" : "NO").append("\n");
				break;
			}
		}// for
		
		System.out.println(sb);
		br.close();
		
	} // main


	private static int find(int node) {
		if(nodes[node] == node) return node;
		nodes[node] = find(nodes[node]);
		return nodes[node];
		
	}

	private static boolean union(int n1, int n2) {
		int root1 = find(n1);
		int root2 = find(n2);
		if(root1 == root2) return false;
		nodes[root2] = root1; // n2가 속한 집합을 n1이 속한 집합에 합침
		return true;
	} // union
	
	
} // class