📌 핵심 1: 빈칸이면 숫자 시도 → 재귀 → 원상복구
if (s[row][col] == 0) {              // 빈칸(0) 발견
    for (int num = 1; num <= 9; num++) {
        if (canPlace(row, col, num)) { // ★ 행/열/3x3 조건 검사
            s[row][col] = num;         // 조건 만족 → 숫자 배치
            solved(row, col + 1);      // 다음 칸 탐색 (재귀)
            s[row][col] = 0;           // ★ 백트래킹: 실패 시 원상복구
            /*
               → 여기서 중요한 포인트
               1) num 하나 넣고 다음 칸으로 진행
               2) 만약 재귀 끝에 규칙 위배되면 함수가 리턴됨
               3) 그러면 칸을 다시 0으로 돌려놓고
               4) 다른 num 후보를 넣어볼 수 있음
            */
        }
    }
} else {
    solved(row, col + 1); // 이미 숫자가 있는 칸은 그냥 패스
}

📌 핵심 2: 3×3 박스 조건 검사
int startRow = (row / 3) * 3;  // 현재 칸이 속한 3x3 박스의 시작 행
int startCol = (col / 3) * 3;  // 현재 칸이 속한 3x3 박스의 시작 열

for (int i = startRow; i < startRow + 3; i++) {
    for (int j = startCol; j < startCol + 3; j++) {
        if (s[i][j] == num) return false; // 이미 같은 숫자가 있으면 불가
    }
}
