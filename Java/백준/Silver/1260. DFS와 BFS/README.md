# 📌 DFS와 BFS 핵심 정리 (백준 1260)

## 1. 그래프 & 방문 배열 초기화
```java
graph = new LinkedList[N+1];
for (int i = 1; i <= N; i++) {
    graph[i] = new LinkedList<>();
}
visit = new boolean[N+1];
```

---

## 2. DFS (깊이 우선 탐색, 재귀)
- 현재 정점 방문 처리 & 출력
- 인접 정점 중 방문 안 한 곳 재귀 호출
```java
private static void dfs(int v) {
    visit[v] = true;
    System.out.print(v + " ");
    for (int nextV : graph[v]) {
        if (!visit[nextV]) dfs(nextV);
    }
}
```

---

## 3. BFS (너비 우선 탐색, 큐)
- 시작 정점 큐에 넣고 방문 처리
- 큐가 빌 때까지: poll → 출력 → 인접 정점 add
```java
private static void bfs(int v) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(v);
    visit[v] = true;

    while (!queue.isEmpty()) {
        int cur = queue.poll();
        System.out.print(cur + " ");
        for (int nextV : graph[cur]) {
            if (!visit[nextV]) {
                queue.add(nextV);
                visit[nextV] = true;
            }
        }
    }
}
```

---

## 4. 정렬
- 문제 조건: 번호가 작은 정점부터 방문  
```java
for (int i = 1; i <= N; i++) {
    graph[i].sort(null); // 오름차순 정렬
}
```

---

## 5. 주의사항
- DFS 끝난 후 → `visit = new boolean[N+1];` 로 다시 초기화 후 BFS 실행
- 출력: DFS 결과 한 줄, BFS 결과 한 줄  

---

# ✅ 최종 요약
- 그래프 & 방문 배열 초기화 필수  
- DFS → 재귀 (깊게 탐색)  
- BFS → 큐 (레벨 단위 탐색)  
- 작은 번호부터 방문 위해 정렬 필요  
- DFS와 BFS는 각각 별도의 방문 배열 사용  
- 출력 형식: DFS 결과, BFS 결과를 각 한 줄에 출력
