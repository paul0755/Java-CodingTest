# 🚨 틀린 부분
- 2차원 배열로 접근하려고 하면 복잡해짐 → 사실 퀸은 한 행에 하나만 오므로 **1차원 배열 pos[row] = col** 로 표현 가능
- 대각선 판정이 직관적으로 이해 안 됨 → 사실 "행 차이 == 열 차이"가 곧 대각선임을 놓치면 막힘

# 📌 암기 포인트
- **퀸은 한 행에 무조건 1개** → 탐색 방향을 "행"으로 정하고, 행 단위로 DFS 진행
- **탈출 조건**: row == N → 모든 행에 퀸 배치 성공 → count++
- **열 탐색**: for (col=0; col<N; col++) 시도
- **검사 범위**: 현재 row에 퀸을 두려 할 때, `i<row` (이전 행의 퀸만 비교)
- **충돌 조건**  
  1. 같은 열: `pos[i] == col`  
  2. 대각선: `Math.abs(row - i) == Math.abs(col - pos[i])`
- **배치 가능 시**: `pos[row] = col` 후 `dfs(row+1)` 재귀 호출 → 다음 행으로 이동
- **핵심 로직**
```java
static boolean isValid(int row, int col) {
    for (int i = 0; i < row; i++) {
        if (pos[i] == col) return false; // 같은 열
        if (Math.abs(row - i) == Math.abs(col - pos[i])) return false; // 대각선
    }
    return true;
}

static void dfs(int row) {
    if (row == N) { count++; return; } // 모든 행 성공 시
    for (int col = 0; col < N; col++) {
        if (isValid(row, col)) {
            pos[row] = col;
            dfs(row + 1);
        }
    }
}
