import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] number;
	static int [] input; // 입력 값
	static boolean [] isSelected; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N]; // 추출된 수인지 여부
		number = new int[N]; // 추출된 수를 저장
		
		for(int i=0; i<N ; i++) input[i] = i+1;
		
		permutation(0); // 0: number 배열의 처음 idx 번호
		
		sc.close();

	}

	private static void permutation(int idx) {
		if(idx >=N) {
			for(int i =0; i < N; i++) {
				System.out.print(number[i] + " ");
			}
			System.out.println();
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			number[idx] = input[i];
			permutation(idx + 1);
			isSelected[i] = false;
		}
		
	}

}
