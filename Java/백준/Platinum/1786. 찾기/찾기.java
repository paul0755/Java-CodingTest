import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	static char [] T, P;
	static int [] skip;
	static List<Integer> answer = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextLine().toCharArray(); 
		// 문자배열을 받기위한 입력
		P = scan.nextLine().toCharArray();
		skip = new int[P.length];

		for(int t=1, p=0; t<P.length; t++) { // skip 만들기 -> 패턴에서 패턴이 있는지를 찾아서 테이블에 기록
			// 패턴[1]과 패턴[0]부터 비교시작 (skip테이블에 첫번째 인덱스는 무조건 0)
			// 불일치시 t의 위치만 달라짐

			while( p > 0 && P[t] != P[p]) p = skip[p-1];
			// 패턴이 발생하다 틀릴경우 p의 위치 조정
			// p의 값을 조정한후에 다시 p[t]와 p[p]를 비교

			if( P[t] == P[p] ) skip[t] = ++p;
			// 패턴이 보일경우 p와t의 위치 전부 조정

			
		} // for
//		System.out.println( Arrays.toString( skip ) );

		for(int pt=0, pp=0; pt<T.length; pt++) { // kmp match

			while( pp > 0 && T[pt] != P[pp]) pp = skip[pp-1];
			// skip 테이블 생성과 같음. 
			// 패턴이 발생하다 틀릴경우 p의 위치를 조정

			if( T[pt] == P[pp] ) {
				if( pp == P.length-1 ) { // 일치하면서 모든 비교가 끝났을경우 -> 모든 패턴일치 구간 찾음
					answer.add(pt-pp+1);
					pp = skip[pp];
				} else {
					// 일치할경우
					++pp;
				} // if
			} // if

		} // for

		System.out.println( answer.size() );
		for (int i : answer) System.out.print( i + " " );

		scan.close();
	} // main

} // main
