import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int K = scanner.nextInt();
        int[] a = new int[n + 1];
        int[] R = new int[n + 1];
        int[] last = new int[1000001];

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        Arrays.fill(last, -1);

        for (int i = n; i >= 1; i--) {
            R[i] = last[a[i]];
            last[a[i]] = i;
        }

        int ans = -1;
        for (int i = 1; i <= n; i++) {
            if (R[i] != -1 && R[i] - i <= K) {
                ans = Math.max(ans, a[i]);
            }
        }

        System.out.println(ans);
    }
}