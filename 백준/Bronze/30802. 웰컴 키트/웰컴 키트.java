import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 티셔츠를 T장씩 최소 몇묶음, 펜을 P자루씩 최대 몇묶음 주문가능하고
    // 그때 펜을 한 자루씩 몇 개 주문하는지 구하시오

    // 입력 :N (참가자 수)
    // 티셔츠 사이즈 별 신청자 수 : S,M,L,XL,XXL,XXXL
    // T(티셔츠 묶음 수), P(펜 묶음 수)

    static int N, S, M, L, XL, XXL, XXXL, T, P, sum=0;


    public static void main(String[] args) throws Exception, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        XL = Integer.parseInt(st.nextToken());
        XXL = Integer.parseInt(st.nextToken());
        XXXL = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        cal_size(S);
        cal_size(M);
        cal_size(L);
        cal_size(XL);
        cal_size(XXL);
        cal_size(XXXL);

        int set = N / P;
        int spare = N % P;

        System.out.println(sum);
        System.out.println(set +" "+ spare);
                
                
                
                
                    }
                
                
    
        
                    private static void cal_size(int size) {
                if(size == 0 ) return;
                sum += (int)Math.ceil(size / (double) T);
                // 나눗셈 올림 연산
                // sum += (size+T-1) / T도 가능
            }
}