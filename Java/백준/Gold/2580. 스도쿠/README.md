# 📌 백준 2580 (스도쿠) 핵심 요약

## 1. 입력
- 9×9 보드, `0`은 빈칸
```java
int[][] s = new int[9][9];
```

---

## 2. 백트래킹 구조
- 빈칸이면 `1~9` 시도
- 가능하면 → 채우고 재귀
- 실패 시 → 원상복구
```java
if (col == 9) { solve(row+1, 0); return; }
if (row == 9) { printBoard(); System.exit(0); }

if (s[row][col] == 0) {
    for (int num = 1; num <= 9; num++) {
        if (canPlace(row, col, num)) {
            s[row][col] = num;
            solve(row, col+1);
            s[row][col] = 0; // 백트래킹
        }
    }
} else {
    solve(row, col+1);
}
```

---

## 3. 조건 검사
- 같은 행, 같은 열, 같은 3×3 박스에 같은 수 있으면 불가
```java
static boolean canPlace(int row, int col, int num) {
    for (int i = 0; i < 9; i++) {
        if (s[row][i] == num) return false; // 행
        if (s[i][col] == num) return false; // 열
    }
    int sr = (row/3) * 3, sc = (col/3) * 3;
    for (int i = sr; i < sr+3; i++) {
        for (int j = sc; j < sc+3; j++) {
            if (s[i][j] == num) return false; // 박스
        }
    }
    return true;
}
```

---

# ✅ 암기 포인트
- `0` = 빈칸  
- 백트래킹 = 넣기 → 재귀 → 원상복구  
- 검사 = 행 + 열 + 3×3 박스  
- 종료 조건 = `row == 9` → 출력 후 종료
