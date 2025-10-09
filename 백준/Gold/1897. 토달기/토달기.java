import java.io.*;
import java.util.*;

public class Main {
    static int D;
    static String start;
    static String[] dict;
    static boolean[] visited;
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        D = Integer.parseInt(st.nextToken());
        start = st.nextToken();
        dict = new String[D];
        visited = new boolean[D];

        for (int i = 0; i < D; i++) {
            dict[i] = br.readLine();
        }

        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        Queue<String> q = new ArrayDeque<>();
        q.offer(start);
        answer = start;

        while (!q.isEmpty()) {
            String cur = q.poll();

            for (int i = 0; i < D; i++) {
                if (!visited[i] && canTransform(cur, dict[i])) {
                    visited[i] = true;
                    q.offer(dict[i]);

                    // 길이가 더 길다면 갱신
                    if (dict[i].length() > answer.length() ||
                       (dict[i].length() == answer.length() && dict[i].compareTo(answer) < 0)) {
                        answer = dict[i];
                    }
                }
            }
        }
    }

    static boolean canTransform(String a, String b) {
        if (b.length() != a.length() + 1) return false;

        for (int i = 0; i < b.length(); i++) {
            String temp = b.substring(0, i) + b.substring(i + 1);
            if (temp.equals(a)) return true;
        }
        return false;
    }
}
