import java.util.*;

class Solution {
    public int solution(String dirs) {

        int y = 5, x = 5; // 중앙 시작
        Set<String> set = new HashSet<>();

        for (char c : dirs.toCharArray()) {
            int ny = y, nx = x;

            if (c == 'U') ny--;
            else if (c == 'D') ny++;
            else if (c == 'L') nx--;
            else if (c == 'R') nx++;

            // 범위 벗어나면 무시
            if (ny < 0 || nx < 0 || ny > 10 || nx > 10) continue;

            // 길 저장 (정방향 + 역방향)
            String path1 = y + "," + x + "->" + ny + "," + nx;
            String path2 = ny + "," + nx + "->" + y + "," + x;

            set.add(path1);
            set.add(path2);
            

            // 이동
            y = ny;
            x = nx;
        }

        return set.size() / 2;
    }
}