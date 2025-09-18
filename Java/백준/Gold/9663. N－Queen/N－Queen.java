import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N, count =0;
	static int[] pos;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		pos = new int[N];
		
		dfs(0);
		
		
		System.out.println(count);

	}
	
	private static void dfs(int row) {
		if(row == N) {
			count++;
			return;
		}
		
		for(int col=0; col<N; col++) {
			if(isValid(row, col)) {
				pos[row] = col;
				dfs(row+1);
			}
		}
		
	}

	private static boolean isValid(int row, int col) {
		for(int i=0; i<row; i++) {
			if(pos[i] == col) return false;
			if(Math.abs(row-i) == Math.abs(col-pos[i])) return false;
		}
		
		return true;
	}

	

}
