import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        long s = 0;
        for (int i = 0; i < n; i++) {
            s += a[i];
        }

        if (s % 4 != 0) {
            System.out.println(0);
            return;
        }

        long[] left = new long[n + 1];
        long[] right = new long[n + 1];
        List<Integer> center = new ArrayList<>();

        long lv = 0, rv = 0;
        for (int i = 1; i <= n; i++) {
            lv += a[i - 1];
            if (lv == s / 4) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = left[i - 1];
            }

            rv += a[n - i];
            if (rv == s / 4) {
                right[n - i] = right[n - i + 1] + 1;
            } else {
                right[n - i] = right[n - i + 1];
            }

            if (lv == s / 2 && i >= 2 && i <= n - 2) {
                center.add(i);
            }
        }

        long ans = 0;
        for (int ct : center) {
            ans += (left[ct - 1] * right[ct + 1]);
        }

        System.out.println(ans);
    }
}