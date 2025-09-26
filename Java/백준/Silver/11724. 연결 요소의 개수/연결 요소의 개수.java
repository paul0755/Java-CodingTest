import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M, cnt=0;
	static int[] visited;
	static ArrayList<Integer> arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		visited = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}
		
//		for(int i=0; i<N+1; i++) {
//			System.out.print(i + ":");
//			for(int n: arr[i]) {
//				System.out.print(n+ " ");
//			}
//			System.out.println();
//		}
		
		for(int i=1 ; i<N+1 ; i++) {
			if(visited[i]!=1) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
		
		
	}

	private static void dfs(int x) {
		visited[x] = 1;
		for(int v : arr[x]) {
			if(visited[v] == 1) continue;
			dfs(v);
		}
		
	}

}
