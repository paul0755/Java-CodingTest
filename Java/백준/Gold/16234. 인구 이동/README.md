# 🚨 틀린 부분
- BFS 구조를 단순히 큐만 쓰는 형태로 외우면 다른 문제에 적용하기 어려움
- 방문 처리, 조건 검사, 거리 계산 등 BFS의 핵심 흐름을 빠뜨리면 구현 단계에서 막힘

# 📌 암기 포인트
- BFS는 **큐(Queue)** 로 구현하며, "시작점 → 큐 삽입 → while 루프 → 사방탐색" 순서
- 방문 처리(`visited`)는 **큐에 넣을 때** 해야 중복 삽입 방지
- 문제별 조건(`벽이 아님`, `diff 범위`, `값 == 1`)을 **경계/방문 검사 뒤에 추가**

```java
import java.util.*;

static int N, M;
static int[][] map;
static boolean[][] visited;

// 시계방향: 상, 우, 하, 좌
static int[] dy = { -1, 0, 1, 0 };
static int[] dx = {  0, 1, 0,-1 };

static void bfs(int sy, int sx) {
    Queue<int[]> q = new LinkedList<>();
    visited[sy][sx] = true;            // 시작점 방문 처리
    q.add(new int[]{sy, sx});          // 시작점 큐에 삽입

    while (!q.isEmpty()) {
        int[] cur = q.poll();
        int y = cur[0], x = cur[1];

        // 현재 좌표 처리 로직 (예: 카운트 증가, 합계 갱신 등)
        // ---- 문제에 따라 달라지는 부분 ----

        for (int d = 0; d < 4; d++) {  // 사방탐색
            int ny = y + dy[d];
            int nx = x + dx[d];

            // 1. 경계 조건
            if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;

            // 2. 방문 조건
            if (visited[ny][nx]) continue;

            // 3. 문제 조건 (여기에 맞춰 수정)
            // 예: 섬의 개수 → map[ny][nx] == 1
            // 예: 인구 이동 → diff >= L && diff <= R
            if (/* 조건 */) {
                visited[ny][nx] = true;
                q.add(new int[]{ny, nx});
            }
        }
    }
}
