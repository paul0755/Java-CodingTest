import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken()); // x
            points[i][1] = Integer.parseInt(st.nextToken()); // y
        }

        
        
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1]; // x가 같으면 y 비교
            return a[0] - b[0]; // x 비교
        });
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(points[i][0]).append(" ").append(points[i][1]).append("\n");
        }
        System.out.print(sb);
        
        
        
        
    }//main
    
    
    
}

