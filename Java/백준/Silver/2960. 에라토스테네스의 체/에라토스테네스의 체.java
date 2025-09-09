import java.util.Scanner;

public class Main {
	
	static boolean[] prime;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int remove_num = 0;
		remove_num = make_prime(N,K);
		System.out.println(remove_num);
		
	}
	
	// N이하의 소수 생성 메서드
	public static int make_prime(int N, int K) {
		prime = new boolean[N+1];
		int count = 0 ;
		
		if(N < 2) return 0;
		
		prime[0] = prime[1] = true;
		
		for(int i=2 ; i<= N; i++) {
			if(prime[i]== true) continue;
			
			// i의 배수들을 걸러주기 위한 반복문
			for(int j= i ; j<=N; j += i) {
				if(!prime[j]) {
					
					prime[j] = true;
					count ++;
					if(count == K) return j; 
				}
			}
		}
		return -1; // 못 찾았을 경우
	}

}
