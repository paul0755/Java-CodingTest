import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static LinkedList<Integer>[] graph;
	static boolean[] visit;
	static int count = 0;
	
	public static void main(String args[]) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new LinkedList[N+1];
		
		for(int i =1 ; i<N+1 ; i++) {
			graph[i] = new LinkedList<>();
		}
		
		visit = new boolean[N+1];
		
		for(int i=0; i<M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}// for
		
		dfs(1);
		System.out.println(count);
		
	}
	
	private static void dfs(int v) {
		visit[v] = true;
		for(int nextV : graph[v]) {
			if(!visit[nextV]) {dfs(nextV); count++;};
		}
		
	}
	
	
}
