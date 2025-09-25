import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K, teleport =0;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dist = new int[100001];
		
		bfs(N);

	}

	private static void bfs(int sx) {
		Deque<Integer> dq = new ArrayDeque<>();
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[sx] = 0;
		dq.add(sx);
		
		while(!dq.isEmpty()) {
			int x = dq.pollFirst();
			
			if(x == K) {
				System.out.println(dist[x]);
				return;
			}

			// *2 이동 (비용 0)
		    if (x*2 < 100001 && dist[x*2] > dist[x]) {
		        dist[x*2] = dist[x];
		        dq.addFirst(x*2);
		    }

		    // -1 이동 (비용 1)
		    if (x-1 >= 0 && dist[x-1] > dist[x] + 1) {
		        dist[x-1] = dist[x] + 1;
		        dq.addLast(x-1);
		    }

		    // +1 이동 (비용 1)
		    if (x+1 < 100001 && dist[x+1] > dist[x] + 1) {
		        dist[x+1] = dist[x] + 1;
		        dq.addLast(x+1);
		    }
		    
			
		} // while
		
	}

}
