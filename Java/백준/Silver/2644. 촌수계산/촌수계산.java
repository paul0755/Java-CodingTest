import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N, a,b,m, cnt =0, state;
	static int[] visited;
	static ArrayList<Integer> arr[];

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		visited = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}
		
		dfs(a);
		
		if(state == 1) {
			System.out.println(cnt);			
		}else {
			System.out.println(-1);
		}
		

	}

	private static void dfs(int x) {
			visited[x] = 1;
			if(x == b){
				state=1;
				return;
			}
			for(int v : arr[x]) {
				if(state==1) break;
				if(visited[v] == 1) continue;
				cnt++;
				dfs(v);
				if(state!=1)cnt --;

			}// for
		
	}

}
