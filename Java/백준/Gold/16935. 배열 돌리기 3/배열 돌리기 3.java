import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static FastScanner fs = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		int N = fs.nextInt(); // 행
		int M = fs.nextInt(); // 열
		int R = fs.nextInt(); // 연산의 개수
		int[][]arr = new int[N][M];
		
		for(int i=0 ; i < N ; i++) {
			for(int j=0 ; j < M; j++) {
				arr[i][j] = fs.nextInt();
			}
		}
		
		int []arr2 = new int[R];
		for(int i=0 ; i < R; i++) {
			arr2[i] = fs.nextInt();
		}
		
		// 연산 실행
	    for (int k = 0; k < R; k++) {
	        int op = arr2[k];
	        switch (op) {
	            case 1: // 상하 반전
	                arr = op1(arr, N, M);
	                break;
	            case 2: // 좌우 반전
	                arr = op2(arr, N, M);
	                break;
	            case 3: // 오른쪽 90도 회전
	                arr = op3(arr, N, M);
	                // N, M 크기가 바뀌는 연산이므로 갱신 필요
	                int tmp = N;
	                N = M;
	                M = tmp;
	                break;
	            case 4: // 왼쪽 90도 회전
	                arr = op4(arr, N, M);
	                tmp = N;
	                N = M;
	                M = tmp;
	                break;
	            case 5: // 그룹 시계 방향 이동
	                arr = op5(arr, N, M);
	                break;
	            case 6: // 그룹 반시계 방향 이동
	                arr = op6(arr, N, M);
	                break;
	        }
	    }
	    
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++) {
	            sb.append(arr[i][j]).append(" ");
	        }
	        sb.append("\n");
	    }
	    System.out.print(sb);

		
	}
	
	static int[][] op1(int arr[][], int N, int M) {
		// 상하 반전 함수
		// 행의 중앙값을 기준으로 행의 값들을 바꿔준다.
			for(int i = 0; i < N/2; i++) {
				for(int j =0 ; j<M; j++) {
					int temp = arr[i][j];
					arr[i][j] = arr[N-1-i][j]; // 0행-5행, 1행-4행, 2행-3행
					arr[N-1-i][j] = temp;
				}
			}
			return arr;
	}
	
	static int[][] op2(int arr[][], int N, int M) {
		// 좌우 반전 함수
		
		for(int i=0 ; i< M/2 ; i++) { // M인 열을 기준
			for(int j=0 ; j<N ; j++) {
				int temp = arr[j][i];   
				arr[j][i] = arr[j][M-1-i];
				arr[j][M-1-i] = temp;
			}
		}
		return arr;
	}
	
	static int[][] op3(int arr[][], int N, int M) {
		// 오른쪽으로 90도 회전시키는연산
		int[][]rotated = new int[M][N];
		for(int i=0; i<N ; i++) { // 행 기준
			for(int j=0; j<M ; j++) {
				rotated[j][N-1-i] = arr[i][j];
				// (0,0) -> (0,5) / (1,0) -> (0,4)
			}
		}
		return rotated;
	}
	
	static int[][] op4(int arr[][], int N, int M){
		int[][]rotated = new int[M][N];
		for(int i=0; i<N; i++) { 
			for(int j=0; j<M; j++) {
				// (0,0)-> (5,0) / (0,1) -> (4,0)
				// (0,0)-> (7,0)
				// i,j -> M-1-i, 
				rotated[M-1-j][i] = arr[i][j];
			}
		}
		return rotated;
	}
	
	static int[][] op5(int arr[][], int N, int M){
		int [][]rotated = new int[N][M];
		int N_half = N/2;
		int M_half = M/2;
		
		// 1번 -> 2번
		for(int i=0; i<N_half; i++) {
			for(int j=0; j<M_half; j++) {
				rotated[i][j+M_half] = arr[i][j];
			}
		}
		
		// 2번 -> 3번
		for(int i=0; i<N_half; i++) {
			for(int j=M_half; j<M; j++) {
				rotated[i+N_half][j] = arr[i][j];
			}
		}
		
		// 3번 -> 4번
		for(int i=N_half; i<N; i++ ) {
			for(int j=M_half; j<M; j++) {
				rotated[i][j-M_half] = arr[i][j];
				}
		}
		
		// 4번 -> 1번
		for(int i=N_half; i<N; i++) {
			for(int j=0 ; j<M_half; j++) {
				rotated[i-N_half][j] = arr[i][j];
			}
		}
		return rotated;
	}
	
	static int[][] op6(int arr[][], int N, int M){
		int [][]rotated = new int[N][M];
		int N_half = N/2;
		int M_half = M/2;

	    // 1번 그룹 → 4번 그룹
	    for (int i = 0; i < N_half; i++) {
	        for (int j = 0; j < M_half; j++) {
	            rotated[i + N_half][j] = arr[i][j];
	        }
	    }

	    // 4번 그룹 → 3번 그룹
	    for (int i = N_half; i < N; i++) {
	        for (int j = 0; j < M_half; j++) {
	            rotated[i][j + M_half] = arr[i][j];
	        }
	    }

	    // 3번 그룹 → 2번 그룹
	    for (int i = N_half; i < N; i++) {
	        for (int j = M_half; j < M; j++) {
	            rotated[i - N_half][j] = arr[i][j];
	        }
	    }

	    // 2번 그룹 → 1번 그룹
	    for (int i = 0; i < N_half; i++) {
	        for (int j = M_half; j < M; j++) {
	            rotated[i][j - M_half] = arr[i][j];
	        }
	    }

	    return rotated;
	}
	
	
	static void print(int arr[][], int N, int M) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	static class FastScanner{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String next() throws Exception{
			while(st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}
		
		int nextInt() throws Exception{
			return Integer.parseInt(next());
		}
	}

}
