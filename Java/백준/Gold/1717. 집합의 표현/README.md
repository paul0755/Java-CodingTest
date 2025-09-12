# 📌 유니온-파인드(Union-Find) 알고리즘 요약 정리

## ✅ 핵심 코드
```java
// Find (경로 압축)
private static int find(int node) {	
    if(nodes[node] == node) return node;   
    nodes[node] = find(nodes[node]);       
    return nodes[node];
}

// Union (합집합)
private static boolean union(int n1, int n2) {
    int root1 = find(n1);
    int root2 = find(n2);
    if(root1 == root2) return false;      
    nodes[root2] = root1;                 
    return true;
}
```

---

## ✅ 개념 요약
- **정의**: 원소들을 여러 개의 상호 배타적 집합(Disjoint Set)으로 관리하는 자료구조  
- **주요 연산**
  - `find(x)` : 원소 x가 속한 집합의 대표(root) 찾기
  - `union(x, y)` : 두 원소가 속한 집합 합치기
- **최적화 기법**
  - 경로 압축(Path Compression)
  - Union by Rank/Size
- **시간 복잡도**: 사실상 O(1) (`α(N)`)

---

## ✅ 예시 (입출력 흐름)

### 입력
```
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
```

### 출력
```
NO
NO
YES
```

- `0 a b` → `a`와 `b` 집합을 합침 (`union`)  
- `1 a b` → `a`와 `b` 같은 집합인지 확인 (`find`)  
