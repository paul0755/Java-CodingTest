import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int switch_count = sc.nextInt();
        int[] switch_status = new int[switch_count];
        for (int i = 0; i < switch_count; i++) {
            switch_status[i] = sc.nextInt();
        }

        int students_count = sc.nextInt();
        int[][] students_status = new int[students_count][2];
        for (int i = 0; i < students_count; i++) {
            students_status[i][0] = sc.nextInt(); // 성별
            students_status[i][1] = sc.nextInt(); // 받은 수
        }

        for (int i = 0; i < students_count; i++) {
            int gender = students_status[i][0];
            int num = students_status[i][1];

            if (gender == 1) { // 남학생
                for (int j = num; j <= switch_count; j += num) {
                    change(switch_status, j - 1);
                }
            } else { // 여학생
                int idx = num - 1;
                change(switch_status, idx);
                int left = idx - 1;
                int right = idx + 1;
                while (left >= 0 && right < switch_count && switch_status[left] == switch_status[right]) {
                    change(switch_status, left);
                    change(switch_status, right);
                    left--;
                    right++;
                }
            }
        }

        // 출력 (20개 단위로 줄바꿈)
        for (int i = 0; i < switch_count; i++) {
            System.out.print(switch_status[i] + " ");
            if ((i + 1) % 20 == 0) System.out.println();
        }
    }

    public static void change(int[] arr, int n) {
        arr[n] = 1 - arr[n]; // 0 -> 1, 1 -> 0
    }
}
