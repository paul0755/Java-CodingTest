import java.util.*;

class Solution {

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public int solution(int[][] land) {

        int n = land.length;     // 세로
        int m = land[0].length;  // 가로

        boolean[][] visited = new boolean[n][m];

        // 각 열마다 얻을 수 있는 석유 총량
        int[] columnSum = new int[m];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {

                if (!visited[y][x] && land[y][x] == 1) {

                    // 🔥 BFS 시작
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{y, x});
                    visited[y][x] = true;

                    int size = 0;

                    // 이 석유 덩어리가 포함된 열들
                    Set<Integer> cols = new HashSet<>();

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int cy = cur[0];
                        int cx = cur[1];

                        size++;           // 석유 크기 증가
                        cols.add(cx);     // 현재 열 기록

                        for (int d = 0; d < 4; d++) {
                            int ny = cy + dy[d];
                            int nx = cx + dx[d];

                            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;

                            if (!visited[ny][nx] && land[ny][nx] == 1) {
                                visited[ny][nx] = true;
                                q.offer(new int[]{ny, nx});
                            }
                        }
                    }

                    // 🔥 해당 열들에 size 누적
                    for (int col : cols) {
                        columnSum[col] += size;
                    }
                }
            }
        }

        // 🔥 최대값 찾기
        int answer = 0;
        for (int i = 0; i < m; i++) {
            answer = Math.max(answer, columnSum[i]);
        }

        return answer;
    }
}