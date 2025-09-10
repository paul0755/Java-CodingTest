import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] flavors;
	static boolean[] selected;
	static int minFlavor = Integer.MAX_VALUE;
	
	static StringBuilder sb =new StringBuilder();
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		flavors = new int[N][2];
		selected = new boolean[N]; // ✅ selected 초기화
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				flavors[i][j] = Integer.parseInt(st.nextToken());
			}
		}// for i-j
		
		powerset(0);
		System.out.println(minFlavor);
		
	} // main
	
	static void powerset(int idx) {
	    if (idx == N) {
	        // 부분집합 추출
	        List<int[]> tmpList = new ArrayList<>();
	        for (int i = 0; i < N; i++) {
	            if (selected[i]) {
	                tmpList.add(flavors[i]); // 선택된 재료만 모음
	            }
	        }

	        if (!tmpList.isEmpty()) { // 공집합 제외
	            int[][] tmp = tmpList.toArray(new int[0][2]);
	            int sum = calFlavor(tmp);
	            minFlavor = Math.min(minFlavor, sum);
	        }
	        return;
	    }

	    // 현재 원소 선택
	    selected[idx] = true;
	    powerset(idx + 1);

	    // 현재 원소 비선택
	    selected[idx] = false;
	    powerset(idx + 1);
	}

	static int calFlavor(int[][] ing) {
	    int sour = 1;
	    int bitter = 0;
	    for (int i = 0; i < ing.length; i++) {
	        sour *= ing[i][0];   // 신맛 곱
	        bitter += ing[i][1]; // 쓴맛 합
	    }
	    return Math.abs(sour - bitter); // 문제 조건에 따라 보통 "차이"를 씀
	}
}
