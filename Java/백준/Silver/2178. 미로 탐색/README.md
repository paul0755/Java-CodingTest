# 📌 백준 2178 (미로 탐색) 핵심 정리

## 1. 입력 처리
- 미로는 붙은 문자열로 주어짐 → `charAt` 사용  
```java
map = new int[N][M];
for (int i = 0; i < N; i++) {
    String line = br.readLine();
    for (int j = 0; j < M; j++) {
        map[i][j] = line.charAt(j) - '0'; // '1' → 1, '0' → 0
    }
}
```
👉 `StringTokenizer` ❌ (공백 없음)

---

## 2. BFS 탐색
- 시작점 `(0,0)` 큐에 넣고 방문 처리  
- 큐에서 꺼내며 4방향 탐색  
- 다음 칸은 이전 칸 값 + 1 → 최단거리 기록
```java
Queue<int[]> q = new LinkedList<>();
q.add(new int[]{0, 0});
visit[0][0] = true;

while (!q.isEmpty()) {
    int[] cur = q.poll();
    int x = cur[0];
    int y = cur[1];

    for (int d = 0; d < 4; d++) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
            if (!visit[nx][ny] && map[nx][ny] == 1) {
                visit[nx][ny] = true;
                map[nx][ny] = map[x][y] + 1; // 거리 갱신
                q.add(new int[]{nx, ny});
            }
        }
    }
}
System.out.println(map[N-1][M-1]);
```

---

## 3. 사방탐색 (필수 암기)
```java
int[] dx = {-1, 1, 0, 0}; // 위, 아래
int[] dy = {0, 0, -1, 1}; // 왼쪽, 오른쪽
```
- `x(행)` → 위/아래 이동  
- `y(열)` → 좌/우 이동  

---

# ✅ 암기 포인트
- 미로 입력은 `charAt(j) - '0'` 로 변환  
- BFS = 큐 활용 → 최단거리 구할 때 사용  
- 거리 기록: `map[nx][ny] = map[x][y] + 1`  
- 사방탐색은 `dx/dy` 배열 패턴 외워두기  
- 최종 답은 `map[N-1][M-1]`  
