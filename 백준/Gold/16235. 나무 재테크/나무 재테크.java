import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] A;       // 겨울에 추가될 양분
    static int[][] food;    // 현재 양분
    static ArrayList<Integer>[][] tree;

    static int[] dy = {-1,-1,-1,0,0,1,1,1};
    static int[] dx = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        food = new int[N][N];
        tree = new ArrayList[N][N];

        // 초기 양분 = 5
        for(int i=0;i<N;i++){
            Arrays.fill(food[i], 5);
        }

        // A 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
                tree[i][j] = new ArrayList<>();
            }
        }

        // 나무 입력
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());

            tree[y][x].add(age);
        }

        // K년 반복
        for(int year=0; year<K; year++){
            spring_summer();
            fall();
            winter();
        }

        // 나무 개수 세기
        int answer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                answer += tree[i][j].size();
            }
        }

        System.out.println(answer);
    }

    // 봄 + 여름
    static void spring_summer(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(tree[i][j].isEmpty()) continue;

                Collections.sort(tree[i][j]); // 어린 나무부터

                ArrayList<Integer> alive = new ArrayList<>();
                int deadFood = 0;

                for(int age : tree[i][j]){
                    if(food[i][j] >= age){
                        food[i][j] -= age;
                        alive.add(age + 1);
                    } else {
                        deadFood += age / 2;
                    }
                }

                food[i][j] += deadFood;
                tree[i][j] = alive;
            }
        }
    }

    // 가을
    static void fall(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(tree[i][j].isEmpty()) continue;

                for(int age : tree[i][j]){
                    if(age % 5 == 0){
                        for(int d=0; d<8; d++){
                            int ny = i + dy[d];
                            int nx = j + dx[d];

                            if(ny<0 || nx<0 || ny>=N || nx>=N) continue;

                            tree[ny][nx].add(0, 1); // 앞에 추가 (어린 나무)
                        }
                    }
                }
            }
        }
    }

    // 겨울
    static void winter(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                food[i][j] += A[i][j];
            }
        }
    }
}