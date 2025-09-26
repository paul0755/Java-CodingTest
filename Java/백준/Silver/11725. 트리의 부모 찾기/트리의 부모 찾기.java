import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parent;
	static int N;
	static int[] visited;
	static ArrayList<Integer> arr[];

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[N+1];
		visited = new int[N+1];
		parent = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x].add(y);
			arr[y].add(x);
		}
		
//		for(int i=1; i<N+1; i++) {
//			System.out.print(i+":");
//			for(int n: arr[i]) {
//				System.out.print(n + " ");
//			}
//			System.out.println();
//		}
		
		dfs(1,0);
		
		for(int i=2; i<N+1; i++) {
			System.out.println(parent[i]);
		}
		

	}

	private static void dfs(int cur, int p) {
		parent[cur] = p;
		visited[cur] = 1;
		for(int v: arr[cur]) {
			if(visited[v] == 1) continue;
			dfs(v, cur); // 자식에게 현재노드를 넘겨줌
		}
		
	}

}
