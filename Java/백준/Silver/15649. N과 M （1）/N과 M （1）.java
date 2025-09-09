import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int [] numbers; // 추출값
	static boolean [] isSelected; //추출 여부
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken()); // 첫 번째 숫자
	    M = Integer.parseInt(st.nextToken()); // 두 번째 숫자
	    
		isSelected = new boolean[N];
		numbers = new int[M];
		
		permutation(0);
		
		br.close();
		

	}

	static void permutation(int idx) {
		if(idx >= M) {
			for (int i = 0; i < M; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
			return;
		}
		
		for(int i=0; i<N ; i++) {
			if(isSelected[i]) continue;
			
			numbers[idx] = i+1;
			isSelected[i] = true;
			
			permutation(idx+1);
			
			isSelected[i] = false;
		}
	}
}
