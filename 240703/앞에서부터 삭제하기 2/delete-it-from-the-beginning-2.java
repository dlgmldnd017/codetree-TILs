import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        // 왼쪽에서부터 누적합을 계산 => O(N)
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        // 오른쪽에서부터 최소값을 기록 => O(N)
        int temp = 10001;
        int[] postfix = new int[n + 1];
        for (int i = n; i >= 0; i--) {
            postfix[i] = Math.min(temp, arr[i]);
            temp = postfix[i];
        }

        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += arr[i];
        }

        double ans = 0;
        // 왼쪽부터 k개 원소를 삭제 => O(N)
        for (int k = 1; k < n - 1; k++) {
            int summation = total - prefix[k] - postfix[k + 1];
            double avg = (double) summation / (n - k - 1);
            ans = Math.max(ans, avg);
        }

        System.out.printf("%.2f%n", ans);
    }
}