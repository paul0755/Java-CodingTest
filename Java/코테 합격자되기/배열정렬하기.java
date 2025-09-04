package Ch0902;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class codingtest {
	
	static FastScanner fs = new FastScanner();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws Exception {
		
		int N = fs.nextInt(); // 배열의 크기 입력
		int[] arr = new int[N];
		for(int i=0; i<N ; i++) {
			arr[i] = fs.nextInt();
		}
		int[] arr1 = solution(arr);
		print(arr1);
		
	}
	
	static void print(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.print(sb);
	}
	
	private static int[] solution(int[] arr) {
		int[] clone = arr.clone();
		Arrays.sort(clone);
		return clone;
	}
	
	
	static class FastScanner{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		String next() throws Exception{
			while(st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}
		
	}
}
