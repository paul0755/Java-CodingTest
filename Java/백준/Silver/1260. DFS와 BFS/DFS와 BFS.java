import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, V;
	static boolean[] visit;
	static LinkedList<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 시작정점
		
		graph = new LinkedList[N+1];
		for(int i=1; i<=N; i++) {
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
		
		for(int i=1 ; i<=N; i++) {
			graph[i].sort(null);
		}
		
		dfs(V);
		System.out.println();
		
		visit = new boolean[N+1];
		bfs(V);
		System.out.println();
		

	}// main
	

	
	private static void dfs(int v) {
		visit[v] = true;
		System.out.print(v + " ");
		for(int nextV : graph[v]) {
			if(!visit[nextV]) dfs(nextV);
		}
		
	}



	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visit[v] = true;
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			System.out.print(tmp + " ");
			
			for(int nextV : graph[tmp]) {
				if(!visit[nextV]) {
					queue.add(nextV);
					visit[nextV] = true;
				}
			}
		}
	}

}// class
