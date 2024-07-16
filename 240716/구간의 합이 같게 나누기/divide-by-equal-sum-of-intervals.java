import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int s = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            s += a[i];
        }

        if (s % 4 != 0) {
            System.out.println(0);
            return;
        }

        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        List<Integer> center = new ArrayList<>();

        int lv = 0, rv = 0;

        for (int i = 1; i <= n; i++) {
            lv += a[i - 1];
            if (lv == s / 4) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = left[i - 1];
            }

            if (lv == s / 2 && i >= 2 && i <= n - 2) {
                center.add(i);
            }
        }

        for(int i = n-1; i>=1; i--){
            rv += a[i];
            if (rv == s / 4) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = right[i + 1];
            }
        }

        int ans = 0;
        for (int ct : center) {
            ans += left[ct - 1] * right[ct + 1];
        }

        System.out.println(ans);
    }
}