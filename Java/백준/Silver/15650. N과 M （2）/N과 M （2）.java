import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] output;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		output = new int[M];
		for(int i=0; i<N; i++) arr[i] = i+1;
		combination(0, 0);
		
		System.out.println(sb);
		
		sc.close();
	}

	private static void combination(int depth, int start) {
		if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
		
		for(int i=start; i<N; i++) {
			output[depth] = arr[i];
			combination(depth+1, i+1);
		}
		
		// output[0] = 1 -> c(1) : 2 -> c(2) (탈출)
		//                  i:2 -> 3
		//                  i:3 -> 4
		// output[0] = 2 ->
	}
}
