🚨 틀린 부분

버블 정렬로 구현

입력이 최대 20,000개 → O(N^2) 정렬은 시간 초과 확정.

👉 반드시 Arrays.sort + Comparator (O(N log N)) 사용해야 함.

길이가 같을 때 정렬 조건 미구현

코드에선 길이 비교만 하고, 길이가 같을 때 사전순 비교 (compareTo) 를 안 넣음.

중복 제거 안 함

문제 조건: 같은 단어 여러 번 입력되면 한 번만 출력해야 함.

👉 HashSet 또는 LinkedHashSet 사용 필요.

📌 암기해야 할 핵심 포인트

사전순 비교 → compareTo

a.compareTo(b)


음수: a < b

0: 같음

양수: a > b

정렬 기준 두 개 이상일 때 → Comparator

Arrays.sort(words, (a, b) -> {
    if (a.length() == b.length()) return a.compareTo(b);
    return a.length() - b.length();
});


중복 제거 후 정렬

HashSet<String> 으로 중복 제거

→ toArray(new String[0])

→ Arrays.sort()

출력 최적화

많은 단어 출력 시 System.out.println() 대신
StringBuilder에 담았다가 한 번에 출력.
