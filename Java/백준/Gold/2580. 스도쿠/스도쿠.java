import java.util.Scanner;

public class Main {
	static int[][] s = new int[9][9];

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean[] used = new boolean[9];
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				s[i][j] = sc.nextInt();
			}
		}
		
		solved(0,0);
		
		
	}

	private static void solved(int row, int col) {
		
		if(col == 9) {
			solved(row+1 , 0);
			return;
		}
		
		if(row == 9) {
			printBoard();
			System.exit(0);
		}
		
		if(s[row][col] == 0) {
			for(int num=1; num <=9; num++) {
				if(canPlace(row, col, num)) {
					s[row][col] = num;
					solved(row, col+1);
					s[row][col] = 0;// 백트래킹
				}
			}
		}else {
			solved(row, col+1);
		}
		
	}

	private static boolean canPlace(int row, int col, int num) {
		
		for(int i=0; i<9; i++) {
			if(s[row][i] == num) return false;
		}
		
		for(int i=0; i<9; i++) {
			if(s[i][col] == num) return false;
		}
		
		int startRow = (row/3) * 3;
		int startCol = (col/3) * 3;
		
		for(int i=startRow ; i<startRow+3; i++) {
			for(int j=startCol; j<startCol+3; j++) {
				if(s[i][j] == num) return false;
			}
		}
		
		return true;
	}

	private static void printBoard() {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(s[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	

}
