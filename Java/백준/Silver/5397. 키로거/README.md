# 📌 BOJ 5397 키로거 — 암기 포인트 정리

## 1. 핵심 구현 아이디어
- `LinkedList<Character>` + `ListIterator<Character>` 사용
- 커서를 기준으로 문자 삽입(`add`), 삭제(`remove`), 이동(`previous`/`next`) 구현
- 각 테스트케이스마다 새로운 리스트와 커서 초기화 필요

---

## 2. ListIterator 동작 핵심
- `cursor = pw.listIterator()` : pw 리스트에 붙은 커서 생성 (맨 앞 위치)
- `cursor.add(c)` : 커서 위치에 문자 추가 → **pw에 저장됨**
- `cursor.previous()` : 커서를 왼쪽으로 이동 + 왼쪽 문자를 반환
- `cursor.next()` : 커서를 오른쪽으로 이동 + 오른쪽 문자를 반환
- `cursor.remove()` : 직전에 반환된 문자 삭제 (단독 호출 불가)

---

## 3. 자주 하는 실수
- `remove()`는 `previous()` 또는 `next()` 호출 후에만 가능
- `<`, `>`, `-` 처리 시 조건문 필수 (`hasPrevious()`, `hasNext()` 체크)
- `pw.add()`와 `cursor.add()`는 다름 → 문제에서는 반드시 `cursor.add()` 사용해야 커서 위치 기준 삽입 가능
- 최종 출력은 `StringBuilder` 사용 (성능상 필수)

---

## 4. 시간 복잡도
- 한 문자열 길이 = L  
- 각 문자 처리 = O(1)  
- 전체 = O(T × L) (충분히 빠름)

---

# ✅ 암기 키워드
- `ListIterator` = **커서**
- 삽입: `add()`, 삭제: `previous()+remove()`
- 조건 체크: `hasPrevious()`, `hasNext()`
- 출력: `StringBuilder`
