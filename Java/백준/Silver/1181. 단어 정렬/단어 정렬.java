import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 🔹 중복 제거 위해 HashSet 사용
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        // 🔹 HashSet → 배열 변환
        String[] words = set.toArray(new String[0]);

        // 🔹 정렬: 길이 → 사전순
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() == b.length()) {
                    return a.compareTo(b); // 사전순
                } else {
                    return a.length() - b.length(); // 길이순
                }
            }
        });

        // 🔹 출력
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("\n");
        }
        System.out.print(sb);
    }
}
