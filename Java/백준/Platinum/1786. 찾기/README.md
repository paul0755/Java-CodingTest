# 📚 KMP 문자열 탐색 정리 (BOJ 1786)

## 1. 개요
- KMP 알고리즘은 **부분 일치 테이블(skip/LPS)** 을 활용해 불필요한 비교를 줄이는 문자열 탐색 알고리즘
- 시간 복잡도: `O(N+M)` (본문 N, 패턴 M)
- 장점: 패턴이 여러 번 등장하거나 겹치는 경우도 모두 탐지 가능

---

## 2. Skip(LPS) 테이블 예시
패턴: `ABCABD`

| 인덱스 | 문자 | skip 값 |
|--------|------|---------|
| 0      | A    | 0       |
| 1      | B    | 0       |
| 2      | C    | 0       |
| 3      | A    | 1       |
| 4      | B    | 2       |
| 5      | D    | 0       |

결과: `skip = [0, 0, 0, 1, 2, 0]`

---

## 3. 예제 실행
본문: `zabcabxabcabdef`  
패턴: `abcabd`

실행 결과:
```
1
8
```
- 패턴이 본문 **8번째 문자부터** 일치

---

## 📌 핵심 코드 정리

### 1. Skip(LPS) 테이블 생성
```java
for (int t=1, p=0; t<P.length; t++) { // skip 만들기 -> 패턴에서 패턴이 있는지를 찾아서 테이블에 기록
    // 패턴[1]과 패턴[0]부터 비교시작 (skip테이블에 첫번째 인덱스는 무조건 0)
    // 불일치시 t의 위치만 달라짐

    while (p > 0 && P[t] != P[p]) p = skip[p-1];
    // 패턴이 발생하다 틀릴경우 p의 위치 조정
    // p의 값을 조정한후에 다시 P[t]와 P[p]를 비교

    if (P[t] == P[p]) skip[t] = ++p;
    // 패턴이 보일경우 p와 t의 위치 전부 조정
}
```

---

### 2. 본문 탐색 (KMP Match)
```java
for (int pt=0, pp=0; pt<T.length; pt++) { // kmp match

    while (pp > 0 && T[pt] != P[pp]) pp = skip[pp-1];
    // skip 테이블 생성과 같음.
    // 패턴이 발생하다 틀릴경우 p의 위치를 조정

    if (T[pt] == P[pp]) {
        if (pp == P.length-1) { // 일치하면서 모든 비교가 끝났을경우 -> 모든 패턴일치 구간 찾음
            answer.add(pt-pp+1);
            pp = skip[pp];
        } else {
            // 일치할경우
            ++pp;
        } // if
    } // if
}
```

---

### 3. 출력부
```java
System.out.println(answer.size());
for (int i : answer) System.out.print(i + " ");
```
