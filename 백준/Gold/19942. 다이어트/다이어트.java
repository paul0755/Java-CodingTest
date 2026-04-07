import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static int[] costs = new int[4];

    static int[][] map;

    static int minCost = Integer.MAX_VALUE;

    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // 최소 영양소 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            costs[i] = Integer.parseInt(st.nextToken());
        }

        // 재료 정보 입력
        map = new int[N][5];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DFS 시작
        dfs(0, 0, 0, 0, 0, 0, new ArrayList<>());

        // 결과 출력
        if(minCost == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(minCost);
            for(int idx : answer){
                System.out.print((idx + 1) + " "); // 문제는 1-based
            }
        }
    }

    private static void dfs(int idx, int p, int g, int c, int v, int cost, List<Integer> list){

        // 가지치기 : 현재 비용이 이미 최소보다 크면 더 볼 필요 없음
        if(cost > minCost) return;

        // 모든 재료를 다 본 경우
        if(idx == N){

            // 공집합 제외 
            if(list.isEmpty()) return;

            // 최소 영양소 만족 여부 체크
            if(p >= costs[0] && g >= costs[1] 
               && c >= costs[2] && v >= costs[3]){

                // 더 작은 비용이면 무조건 갱신
                if(cost < minCost){
                    minCost = cost;
                    answer = new ArrayList<>(list); // 깊은 복사
                }
                // 비용 같으면 사전순 비교
                else if(cost == minCost){
                    if(isSmaller(list, answer)){
                        answer = new ArrayList<>(list);
                    }
                }
            }
            return;
        }


        list.add(idx); // 선택
        dfs(idx + 1,
            p + map[idx][0],
            g + map[idx][1],
            c + map[idx][2],
            v + map[idx][3],
            cost + map[idx][4],
            list);

        list.remove(list.size() - 1); // 복구 (백트래킹 핵심)

        dfs(idx + 1, p, g, c, v, cost, list);
    }


    private static boolean isSmaller(List<Integer> a, List<Integer> b){

        int len = Math.min(a.size(), b.size());

        for(int i=0; i<len; i++){
            if(!a.get(i).equals(b.get(i))){
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}