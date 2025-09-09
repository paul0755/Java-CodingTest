import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] hat_num;
	static int[] output; 
	static StringBuilder sb = new StringBuilder();
	static boolean found = false;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		hat_num = new int[9];
		output = new int[7];
		
		for(int i=0 ; i<9; i++) {
			hat_num[i] = Integer.parseInt(br.readLine());
		}
		
		combination(0,0);
		System.out.println(sb);
		
	}

	private static void combination(int depth, int start) {
		if(found) return;
		
		if(depth == 7) {
			if(sum(output) == 100) {				
				for(int i=0; i<output.length; i++) {
					sb.append(output[i]).append("\n");
				}
				found = true;
			}
			return;
		}
		
		for(int i= start; i<hat_num.length; i++) {
			output[depth] = hat_num[i];
			combination(depth+1, i+1);
		}
		
	}

	private static int sum(int[] num) {
		int sum = 0;
		for(int i=0; i<num.length; i++) {
			sum += num[i];
		}
		
		return sum;
	}

}
