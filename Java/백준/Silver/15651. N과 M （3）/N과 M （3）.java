import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] arr;
	static int[] output;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		output = new int[M];
		
		for(int i=0; i<N; i++) arr[i] = i+1;
		repeatPermutation(0);
		
		System.out.println(sb);
		sc.close();

	}

	private static void repeatPermutation(int depth) {
		if(depth == M) {
			for(int i =0 ; i<M; i++) {
				sb.append(output[i]).append(" ");
			};
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N ; i++) {
			output[depth] = arr[i];
			repeatPermutation(depth+1);
		}
	}
	
	

}
