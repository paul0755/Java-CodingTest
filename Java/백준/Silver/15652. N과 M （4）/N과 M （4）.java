import java.util.Scanner;

public class Main {
	
	static int N,M;
	static int[] arr;
	static int[] output;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		output = new int[M];
		
		for(int i=0; i<N ; i++) arr[i] = i+1;
		
		repeatCombination(0, 0);
		
		System.out.println(sb);
		

	}

	private static void repeatCombination(int depth, int start) {
		if(depth == M) {
			for(int i =0; i<M; i++) {
				sb.append(output[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for(int i=start; i<N; i++) {
			output[depth] = arr[i];
			repeatCombination(depth+1, i);
		}
		
	}

}
